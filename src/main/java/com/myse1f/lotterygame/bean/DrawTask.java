package com.myse1f.lotterygame.bean;

import com.myse1f.lotterygame.utils.Web3jUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.web3j.protocol.Web3j;

@Component
public class DrawTask {
    private static final Logger log = LoggerFactory.getLogger(DrawTask.class);

    private final Web3j web3j;
    private final Lottery lottery;

    @Autowired
    public DrawTask(Web3j web3j, Lottery lottery) {
        this.web3j = web3j;
        this.lottery = lottery;

        new DrawThread().start();
    }

    private class DrawThread extends Thread {
        public DrawThread() {
            super("Draw Thread");
            setPriority(Math.max(Thread.MIN_PRIORITY, Thread.currentThread().getPriority()-1));
            setDaemon(true);
        }

        @Override
        public void run() {
            while (true) {
                try {
                    int settlement = lottery.getSettlementBlock();
                    if (settlement != 0 && settlement <= Web3jUtils.getBlockHeight(web3j).getBlockNumber().intValue()) {
                        String winner = lottery.draw();
                        log.info("Winner is {}", winner);
                    }
                    Thread.sleep(20000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

}