package com.myse1f.lotterygame.generated;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.DynamicArray;
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
    private static final String BINARY = "0x608060405267016345785d8a00006002556003805460ff1916600b179055670de0b6b3a7640000341461007d576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252602781526020018061083f6027913960400191505060405180910390fd5b600080546001600160a01b031916331790556107a18061009e6000396000f3fe6080604052600436106100705760003560e01c80638b5b9ccc1161004e5780638b5b9ccc146100c857806393e84cd91461012d578063e75235b814610135578063f88649a11461016057610070565b80630eecae2114610075578063198847551461008c57806341c0e1b5146100b3575b600080fd5b34801561008157600080fd5b5061008a610191565b005b34801561009857600080fd5b506100a1610405565b60408051918252519081900360200190f35b3480156100bf57600080fd5b5061008a61040c565b3480156100d457600080fd5b506100dd6104cf565b60408051602080825283518183015283519192839290830191858101910280838360005b83811015610119578181015183820152602001610101565b505050509050019250505060405180910390f35b61008a610531565b34801561014157600080fd5b5061014a6106aa565b6040805160ff9092168252519081900360200190f35b34801561016c57600080fd5b506101756106b3565b604080516001600160a01b039092168252519081900360200190f35b6000546001600160a01b031633146101da5760405162461bcd60e51b81526004018080602001828103825260268152602001806107476026913960400191505060405180910390fd5b60035460015460ff909116146102215760405162461bcd60e51b815260040180806020018281038252602981526020018061071e6029913960400191505060405180910390fd5b6004544311610277576040805162461bcd60e51b815260206004820181905260248201527f536574746c656d656e74426c6f636b2069736e27742076616c69642079657421604482015290519081900360640190fd5b6004546101000143106102d1576040805162461bcd60e51b815260206004820152601f60248201527f536574746c656d656e74426c6f636b206973206f7574206f6620646174652100604482015290519081900360640190fd5b60035460045460408051914060208084019190915242838301528151808403830181526060909301909152815191012060009160ff90811691168161031257fe5b06905060018160ff168154811061032557fe5b600091825260209091200154600580546001600160a01b0319166001600160a01b039092169190911790556001805460ff831690811061036157fe5b60009182526020822001546002546003546040516001600160a01b039093169360001960ff9283160190911690910280156108fc02929091818181858888f193505050501580156103b6573d6000803e3d6000fd5b506005546040516001600160a01b03909116907fd9b9044da3167fe82c0e21394db224885a43b7de20efc6133458294f2c6bc96090600090a260006004819055610402906001906106c2565b50565b6004545b90565b6000546001600160a01b031633146104555760405162461bcd60e51b81526004018080602001828103825260248152602001806106fa6024913960400191505060405180910390fd5b60005b60015460ff821610156104c05760018160ff168154811061047557fe5b60009182526020822001546002546040516001600160a01b039092169281156108fc029290818181858888f193505050501580156104b7573d6000803e3d6000fd5b50600101610458565b506000546001600160a01b0316ff5b6060600180548060200260200160405190810160405280929190818152602001828054801561052757602002820191906000526020600020905b81546001600160a01b03168152600190910190602001808311610509575b5050505050905090565b6002543414610587576040805162461bcd60e51b815260206004820152601760248201527f4f6e6520626574206e6565647320302e31206574686572000000000000000000604482015290519081900360640190fd5b60035460015460ff909116116105e4576040805162461bcd60e51b815260206004820152601a60248201527f57616974696e6720666f72206c6f747465727920726573756c74000000000000604482015290519081900360640190fd5b60018054808201825560008290527fb10e2d527612073b26eecdfd717e6a320cf44b4afac2b0732d9fcbe2b7fa0cf60180546001600160a01b03191633908117909155905460408051918252517f0c635b74dfccae79c39119dc6d80498e3cdcaae2ab17216ed32fe2ce36cfe09a9181900360200190a260035460015460ff90911614156106a857600a4301600481905560408051918252517fe45efc3a43a9768362528ace2c611727dae9028310c54360255d6987d777b5769181900360200190a15b565b60035460ff1690565b6005546001600160a01b031690565b5080546000825590600052602060002090810190610402919061040991905b808211156106f557600081556001016106e1565b509056fe4f6e6c7920636f6e7472616374206f776e65722063616e2063616c6c206b696c6c2829216e756d626572206f6620706c6179657220646f65736e2774207265616368207468726573686f6c642e4f6e6c7920636f6e7472616374206f776e65722063616e2063616c6c20636f6d6d6974282921a265627a7a723158208019ab4f289c4573ac45b04e5186585ee852367531c470466609cd966484f25364736f6c634300050d003252657175697265203120656874657220746f206465706c6f792074686520636f6e747261637421";

    public static final String FUNC_PLAY = "play";

    public static final String FUNC_DRAW = "draw";

    public static final String FUNC_KILL = "kill";

    public static final String FUNC_GETPLAYERS = "getPlayers";

    public static final String FUNC_GETSETTLEMENTBLOCK = "getSettlementBlock";

    public static final String FUNC_GETTHRESHOLD = "getThreshold";

    public static final String FUNC_GETLASTWINNER = "getLastWinner";

    public static final Event DRAWING_EVENT = new Event("Drawing", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
    ;

    public static final Event DRAWN_EVENT = new Event("Drawn", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}));
    ;

    public static final Event PLAY_EVENT = new Event("Play", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}));
    ;

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
        _addresses.put("5777", "0x9aF84C9465402BFC484735391e401A1f24fbF1Cd");
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
            typedResponse.numOfPlayers = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
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
                typedResponse.numOfPlayers = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<PlayEventResponse> playEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(PLAY_EVENT));
        return playEventFlowable(filter);
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

    public RemoteFunctionCall<List> getPlayers() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETPLAYERS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Address>>() {}));
        return new RemoteFunctionCall<List>(function,
                new Callable<List>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    public List call() throws Exception {
                        List<Type> result = (List<Type>) executeCallSingleValueReturn(function, List.class);
                        return convertToNative(result);
                    }
                });
    }

    public RemoteFunctionCall<BigInteger> getSettlementBlock() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETSETTLEMENTBLOCK, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> getThreshold() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETTHRESHOLD, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<String> getLastWinner() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETLASTWINNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
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

        public BigInteger numOfPlayers;
    }
}
