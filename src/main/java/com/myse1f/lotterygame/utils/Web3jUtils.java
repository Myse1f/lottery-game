package com.myse1f.lotterygame.utils;

import org.web3j.crypto.Credentials;
import org.web3j.crypto.RawTransaction;
import org.web3j.crypto.TransactionEncoder;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.*;
import org.web3j.utils.Convert;
import org.web3j.utils.Numeric;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

public class Web3jUtils {

    public static String getClientVersion(Web3j web3j) throws InterruptedException, ExecutionException {
        Web3ClientVersion client = web3j
                .web3ClientVersion()
                .sendAsync()
                .get();

        return client.getWeb3ClientVersion();
    }

    public static EthCoinbase getCoinbase(Web3j web3j) throws ExecutionException, InterruptedException {
        return web3j
                .ethCoinbase()
                .sendAsync()
                .get();
    }

    public static EthAccounts getAccounts(Web3j web3j) throws ExecutionException, InterruptedException {
        return web3j
                .ethAccounts()
                .sendAsync()
                .get();
    }

    public static BigDecimal weiToEther(BigInteger wei) {
        return Convert.fromWei(wei.toString(), Convert.Unit.ETHER);
    }

    public static BigInteger etherToWei(BigDecimal ether) {
        return Convert.toWei(ether, Convert.Unit.ETHER).toBigInteger();
    }

    public static BigInteger getBalanceWei(Web3j web3j, String address) throws InterruptedException, ExecutionException {
        EthGetBalance balance = web3j
                .ethGetBalance(address, DefaultBlockParameterName.LATEST)
                .sendAsync()
                .get();

        return balance.getBalance();
    }

    public static BigDecimal getBalanceEther(Web3j web3j, String address) throws ExecutionException, InterruptedException {
        return weiToEther(getBalanceWei(web3j, address));
    }

    /**
     * Return the nonce (tx count) for the specified address.
     */
    public static BigInteger getNonce(Web3j web3j, String address) throws InterruptedException, ExecutionException {
        EthGetTransactionCount ethGetTransactionCount =
                web3j.ethGetTransactionCount(address, DefaultBlockParameterName.LATEST).sendAsync().get();

        return ethGetTransactionCount.getTransactionCount();
    }

    /**
     * Waits for the receipt for the transaction specified by the provided tx hash.
     * Makes 40 attempts (waiting 1 sec. between attempts) to get the receipt object.
     * In the happy case the tx receipt object is returned.
     * Otherwise, a runtime exception is thrown.
     */
    public static TransactionReceipt waitForReceipt(Web3j web3j, String transactionHash)
            throws Exception
    {

        int attempts = Web3jConstants.CONFIRMATION_ATTEMPTS;
        int sleep_millis = Web3jConstants.SLEEP_DURATION;

        Optional<TransactionReceipt> receipt = getReceipt(web3j, transactionHash);

        while(attempts-- > 0 && !receipt.isPresent()) {
            Thread.sleep(sleep_millis);
            receipt = getReceipt(web3j, transactionHash);
        }

        if (attempts <= 0) {
            throw new RuntimeException("No Tx receipt received");
        }

        return receipt.get();
    }

    /**
     * Transfers the specified amount of Wei from the coinbase to the specified account.
     * The method waits for the transfer to complete using method waitForReceipt.
     */
    public static TransactionReceipt transferAndWait(Web3j web3j, String from, String to, BigInteger amountWei, Credentials credentials)
            throws Exception
    {
        BigInteger nonce = getNonce(web3j, from);
        // this is a contract method call -> gas limit higher than simple fund transfer
        BigInteger gasLimit = Web3jConstants.GAS_LIMIT_ETHER_TX.multiply(BigInteger.valueOf(2));
        RawTransaction rawTransaction = RawTransaction.createEtherTransaction(
                nonce,
                Web3jConstants.GAS_PRICE,
                gasLimit,
                to,
                amountWei);
        byte[] signedMessage = TransactionEncoder.signMessage(rawTransaction, credentials);
        String hexValue = Numeric.toHexString(signedMessage);
        EthSendTransaction ethSendTransaction = web3j
                .ethSendRawTransaction(hexValue)
                .sendAsync()
                .get();

        String txHash = ethSendTransaction.getTransactionHash();

        return waitForReceipt(web3j, txHash);
    }

    /**
     * Returns the TransactionRecipt for the specified tx hash as an optional.
     */
    public static Optional<TransactionReceipt> getReceipt(Web3j web3j, String transactionHash)
            throws Exception
    {
        EthGetTransactionReceipt receipt = web3j
                .ethGetTransactionReceipt(transactionHash)
                .sendAsync()
                .get();

        return receipt.getTransactionReceipt();
    }
}
