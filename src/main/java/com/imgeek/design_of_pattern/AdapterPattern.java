package com.imgeek.design_of_pattern;

import java.util.Arrays;

/**
 * 功能描述: 适配器模式
 *
 * @author sunzhiqiang
 * @create 2018-08-11
 */
public class AdapterPattern {

    public static void main(String[] args){

        ElectricCompary electricCompary = new ElectricCompary();

        Computer computer = new Computer();
        computer.play(new ElectricAdapter(electricCompary));
    }
}

/**
 * 被适配接口
 */
interface AlternatingCurrent {

    byte[] getAC();
}

class ElectricCompary implements AlternatingCurrent {

    public byte[] getAC() {

        return new byte[]{1,-1,3,-3,5,-2,6,-1,3,-2};
    }
}


/**
 * 目标接口
 */
interface DirectCurrent {

    byte[] getDC();
}

/**
 * 适配器
 */
class ElectricAdapter implements DirectCurrent{

    private AlternatingCurrent ac;

    public ElectricAdapter(AlternatingCurrent ac){
        this.ac = ac;
    }

    public byte[] getDC() {

        byte[] acCurrent = ac.getAC();

        byte[] dcCurrent = new byte[acCurrent.length];
        for (int i = 0; i < acCurrent.length; i++) {
            dcCurrent[i] = (byte) Math.abs(acCurrent[i]);
        }

        return dcCurrent;
    }
}

class Computer {

    public void play(DirectCurrent dc){

        byte[] array = dc.getDC();
        System.out.println("使用直流电:" + Arrays.toString(array));
    }
}




