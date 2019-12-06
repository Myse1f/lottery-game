package com.myse1f.lotterygame.controller;

import com.myse1f.lotterygame.utils.Lottery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LotteryController {

    private final Lottery lottery;

    @Autowired
    public LotteryController(Lottery lottery) {
        this.lottery = lottery;
    }

    @PostMapping("/draw")
    public Result draw() {
        Result result = new Result();
        try {
            String winner = lottery.draw();
            Map<String, String> data = new HashMap<>();
            data.put("winner", winner);
            result.setCode(Result.ResultCode.SUCCESS.getCode());
            result.setMessage(Result.ResultCode.SUCCESS.getErrMsg());
            result.setData(data);
        } catch (Exception e) {
            result.setCode(Result.ResultCode.EXCEPTION.getCode());
            result.setMessage(Result.ResultCode.EXCEPTION.getErrMsg());
        }
        return result;
    }
}
