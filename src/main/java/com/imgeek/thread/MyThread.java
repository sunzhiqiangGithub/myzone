package com.imgeek.thread;

import com.imgeek.jvm.MyFunctionInterface;
import lombok.extern.slf4j.Slf4j;

/**
 * auth:    xiemin
 * date:    2018-07-17
 * desc:    jdk底层线程使用
 */
class Thread1 implements Runnable {

    @Override
    public void run() {

    }
}

class Thread2 extends Thread {
    @Override
    public void run() {

    }
}

@Slf4j
public class MyThread extends Thread {
    private MyFunctionInterface functionInterface;
    private WaitingQueue<?> waitingQueue;

    public MyThread(MyFunctionInterface functionInterface)
    {
        this.functionInterface = functionInterface;
    }


    @Override
    public void run() {
        try {
            functionInterface.apply();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    public void setWaitingQueue(WaitingQueue<?> waitingQueue) {
        this.waitingQueue = waitingQueue;
    }
}
