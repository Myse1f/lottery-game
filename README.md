# Lottery Game Backend
The back end is to draw the lottery based on Ethereum.

## Before running
You need to add configuration file with properties `web3j.http_service`, `myself.private_key` and `contract.address`.
They are web3 http provider, contract owner and contract address respectively.e.g
```properties
web3j.http_servie=http://127.0.0.1:7545
myself.private_key=0x...
conrtact.address=0x...
```

## Java Contract Wrapper
The contract wrapper is generated by [web3j](http://web3j.io) with truffle json output

```$ web3j truffle generate [--javaTypes|--solidityTypes] /path/to/<truffle-smart-contract-output>.json -o /path/to/src/main/java -p com.your.organisation.name```