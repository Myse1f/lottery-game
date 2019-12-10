package com.myse1f.lotterygame.bean;

import com.myse1f.lotterygame.generated.LotteryGame;
import com.myse1f.lotterygame.utils.Web3jConstants;
import com.myse1f.lotterygame.utils.Web3jUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.gas.DefaultGasProvider;
import org.web3j.tx.gas.StaticGasProvider;

import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.ExecutionException;

@Component
public class Lottery {

    private final Web3j web3j;
    private LotteryGame lotteryContract;
    private String contractAddress;

    @Autowired
    public Lottery(Web3j web3j, Myself myself, @Value("${contract.address}") String contractAddress) throws IOException {
        this.web3j = web3j;
        this.contractAddress = contractAddress;
        lotteryContract = LotteryGame.load(
                contractAddress, this.web3j,
                myself.getCredentials(),
                new StaticGasProvider(Web3jConstants.GAS_PRICE, Web3jConstants.GAS_LIMIT_GREETER_TX)
        );
        if (!lotteryContract.isValid()) {
            throw new RuntimeException("Contract invalid");
        }
    }

    public LotteryGame getLotteryContract() {
        return lotteryContract;
    }

    public int getSettlementBlock() throws ExecutionException, InterruptedException {
        BigInteger settlement = lotteryContract.getSettlementBlock().sendAsync().get();
        return settlement.intValue();
    }

    public String draw() throws Exception {
        TransactionReceipt receipt = lotteryContract.draw().sendAsync().get();
        return lotteryContract.getDrawnEvents(receipt).get(0).winner;
    }
}
