package com.myse1f.lotterygame.controller;

import com.myse1f.lotterygame.bean.Lottery;
import com.myse1f.lotterygame.utils.Web3jUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.web3j.protocol.Web3j;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LotteryController {

    private final Lottery lottery;
    private final Web3j web3j;

    @Autowired
    public LotteryController(Lottery lottery, Web3j web3j) {
        this.lottery = lottery;
        this.web3j = web3j;
        this.drawing = false;
    }

    private boolean drawing;

    @CrossOrigin
    @PostMapping("/draw")
    public Result draw(@RequestParam("settlement")int settlement) {
        Result result = new Result();
        try {
            if (!drawing) {
                int currentHeight = Web3jUtils.getBlockHeight(web3j).getBlockNumber().intValue();
                if (currentHeight < settlement) {
                    result.setCode(Result.ResultCode.WAITING.getCode());
                    result.setMessage(Result.ResultCode.WAITING.getErrMsg());
                } else {
                    drawing = true;
                    String winner = lottery.draw();
                    Map<String, String> data = new HashMap<>();
                    data.put("winner", winner);
                    result.setCode(Result.ResultCode.SUCCESS.getCode());
                    result.setMessage(Result.ResultCode.SUCCESS.getErrMsg());
                    result.setData(data);
                    drawing = false;
                }
            } else {
                result.setCode(Result.ResultCode.BUSY.getCode());
                result.setMessage(Result.ResultCode.BUSY.getErrMsg());
            }
        } catch (Exception e) {
            result.setCode(Result.ResultCode.EXCEPTION.getCode());
            result.setMessage(Result.ResultCode.EXCEPTION.getErrMsg());
        }
        return result;
    }
}
