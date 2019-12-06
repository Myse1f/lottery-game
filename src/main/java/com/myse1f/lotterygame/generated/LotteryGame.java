package com.myse1f.lotterygame.generated;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.5.9.
 */
@SuppressWarnings("rawtypes")
public class LotteryGame extends Contract {
    private static final String BINARY = "0x608060405267016345785d8a00006002556003805460ff1916600b179055670de0b6b3a7640000341461007d576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260278152602001806107596027913960400191505060405180910390fd5b600080546001600160a01b031916331790556106bb8061009e6000396000f3fe6080604052600436106100555760003560e01c80630eecae211461005a57806341c0e1b514610071578063785ffb371461008657806393e84cd9146100b1578063c8feb1d2146100b9578063f71d96cb146100e0575b600080fd5b34801561006657600080fd5b5061006f610126565b005b34801561007d57600080fd5b5061006f610373565b34801561009257600080fd5b5061009b610436565b6040805160ff9092168252519081900360200190f35b61006f61043f565b3480156100c557600080fd5b506100ce6105ac565b60408051918252519081900360200190f35b3480156100ec57600080fd5b5061010a6004803603602081101561010357600080fd5b50356105b2565b604080516001600160a01b039092168252519081900360200190f35b6000546001600160a01b0316331461016f5760405162461bcd60e51b81526004018080602001828103825260268152602001806106616026913960400191505060405180910390fd5b60035460015460ff909116146101b65760405162461bcd60e51b81526004018080602001828103825260298152602001806106386029913960400191505060405180910390fd5b600454431161020c576040805162461bcd60e51b815260206004820181905260248201527f536574746c656d656e74426c6f636b2069736e27742076616c69642079657421604482015290519081900360640190fd5b600454610100014310610266576040805162461bcd60e51b815260206004820152601f60248201527f536574746c656d656e74426c6f636b206973206f7574206f6620646174652100604482015290519081900360640190fd5b60035460045460408051914060208084019190915242838301528151808403830181526060909301909152815191012060009160ff9081169116816102a757fe5b06905060018160ff16815481106102ba57fe5b60009182526020822001546002546003546040516001600160a01b039093169360001960ff9283160190911690910280156108fc02929091818181858888f1935050505015801561030f573d6000803e3d6000fd5b5060018160ff168154811061032057fe5b60009182526020822001546040516001600160a01b03909116917fd9b9044da3167fe82c0e21394db224885a43b7de20efc6133458294f2c6bc96091a260006004819055610370906001906105d9565b50565b6000546001600160a01b031633146103bc5760405162461bcd60e51b81526004018080602001828103825260248152602001806106146024913960400191505060405180910390fd5b60005b60015460ff821610156104275760018160ff16815481106103dc57fe5b60009182526020822001546002546040516001600160a01b039092169281156108fc029290818181858888f1935050505015801561041e573d6000803e3d6000fd5b506001016103bf565b506000546001600160a01b0316ff5b60035460ff1681565b6002543414610495576040805162461bcd60e51b815260206004820152601760248201527f4f6e6520626574206e6565647320302e31206574686572000000000000000000604482015290519081900360640190fd5b60035460015460ff909116116104f2576040805162461bcd60e51b815260206004820152601a60248201527f57616974696e6720666f72206c6f747465727920726573756c74000000000000604482015290519081900360640190fd5b60018054808201825560009182527fb10e2d527612073b26eecdfd717e6a320cf44b4afac2b0732d9fcbe2b7fa0cf60180546001600160a01b0319163390811790915560405190917f74ff4718bf0d5b38ef942dd8fd82b6a7af50cb06df94b380e3bd953df8e34a3c91a260035460015460ff90911614156105aa57600a4301600481905560408051918252517fe45efc3a43a9768362528ace2c611727dae9028310c54360255d6987d777b5769181900360200190a15b565b60045481565b600181815481106105bf57fe5b6000918252602090912001546001600160a01b0316905081565b5080546000825590600052602060002090810190610370919061061091905b8082111561060c57600081556001016105f8565b5090565b9056fe4f6e6c7920636f6e7472616374206f776e65722063616e2063616c6c206b696c6c2829216e756d626572206f6620706c6179657220646f65736e2774207265616368207468726573686f6c642e4f6e6c7920636f6e7472616374206f776e65722063616e2063616c6c20636f6d6d6974282921a265627a7a72315820aac88502dc51308833b0efbbc798eb0ef5a276fc59de081bc693b226aebec6a964736f6c634300050d003252657175697265203120656874657220746f206465706c6f792074686520636f6e747261637421";

    public static final String FUNC_THRESHOLD = "THRESHOLD";

    public static final String FUNC_PLAYERS = "players";

    public static final String FUNC_SETTLEMENTBLOCKNUMBER = "settlementBlockNumber";

    public static final String FUNC_PLAY = "play";

    public static final String FUNC_DRAW = "draw";

    public static final String FUNC_KILL = "kill";

    public static final Event DRAWING_EVENT = new Event("Drawing", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
    ;

    public static final Event DRAWN_EVENT = new Event("Drawn", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}));
    ;

    public static final Event PLAY_EVENT = new Event("Play", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}));
    ;

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
        _addresses.put("5777", "0x0956657C6c9Eb916cF54288131b30BF4AD69aDab");
    }

    @Deprecated
    protected LotteryGame(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected LotteryGame(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected LotteryGame(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected LotteryGame(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public List<DrawingEventResponse> getDrawingEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(DRAWING_EVENT, transactionReceipt);
        ArrayList<DrawingEventResponse> responses = new ArrayList<DrawingEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            DrawingEventResponse typedResponse = new DrawingEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.settlementBlockNumber = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<DrawingEventResponse> drawingEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, DrawingEventResponse>() {
            @Override
            public DrawingEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(DRAWING_EVENT, log);
                DrawingEventResponse typedResponse = new DrawingEventResponse();
                typedResponse.log = log;
                typedResponse.settlementBlockNumber = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<DrawingEventResponse> drawingEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(DRAWING_EVENT));
        return drawingEventFlowable(filter);
    }

    public List<DrawnEventResponse> getDrawnEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(DRAWN_EVENT, transactionReceipt);
        ArrayList<DrawnEventResponse> responses = new ArrayList<DrawnEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            DrawnEventResponse typedResponse = new DrawnEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.winner = (String) eventValues.getIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<DrawnEventResponse> drawnEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, DrawnEventResponse>() {
            @Override
            public DrawnEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(DRAWN_EVENT, log);
                DrawnEventResponse typedResponse = new DrawnEventResponse();
                typedResponse.log = log;
                typedResponse.winner = (String) eventValues.getIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<DrawnEventResponse> drawnEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(DRAWN_EVENT));
        return drawnEventFlowable(filter);
    }

    public List<PlayEventResponse> getPlayEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(PLAY_EVENT, transactionReceipt);
        ArrayList<PlayEventResponse> responses = new ArrayList<PlayEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            PlayEventResponse typedResponse = new PlayEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.player = (String) eventValues.getIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<PlayEventResponse> playEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, PlayEventResponse>() {
            @Override
            public PlayEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(PLAY_EVENT, log);
                PlayEventResponse typedResponse = new PlayEventResponse();
                typedResponse.log = log;
                typedResponse.player = (String) eventValues.getIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<PlayEventResponse> playEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(PLAY_EVENT));
        return playEventFlowable(filter);
    }

    public RemoteFunctionCall<BigInteger> THRESHOLD() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_THRESHOLD, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<String> players(BigInteger param0) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_PLAYERS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<BigInteger> settlementBlockNumber() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_SETTLEMENTBLOCKNUMBER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> play(BigInteger weiValue) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_PLAY, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteFunctionCall<TransactionReceipt> draw() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_DRAW, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> kill() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_KILL, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static LotteryGame load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new LotteryGame(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static LotteryGame load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new LotteryGame(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static LotteryGame load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new LotteryGame(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static LotteryGame load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new LotteryGame(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<LotteryGame> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, BigInteger initialWeiValue) {
        return deployRemoteCall(LotteryGame.class, web3j, credentials, contractGasProvider, BINARY, "", initialWeiValue);
    }

    public static RemoteCall<LotteryGame> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, BigInteger initialWeiValue) {
        return deployRemoteCall(LotteryGame.class, web3j, transactionManager, contractGasProvider, BINARY, "", initialWeiValue);
    }

    @Deprecated
    public static RemoteCall<LotteryGame> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue) {
        return deployRemoteCall(LotteryGame.class, web3j, credentials, gasPrice, gasLimit, BINARY, "", initialWeiValue);
    }

    @Deprecated
    public static RemoteCall<LotteryGame> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue) {
        return deployRemoteCall(LotteryGame.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "", initialWeiValue);
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static class DrawingEventResponse extends BaseEventResponse {
        public BigInteger settlementBlockNumber;
    }

    public static class DrawnEventResponse extends BaseEventResponse {
        public String winner;
    }

    public static class PlayEventResponse extends BaseEventResponse {
        public String player;
    }
}
