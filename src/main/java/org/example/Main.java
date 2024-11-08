package org.example;

import java.util.Arrays;
import java.util.stream.IntStream;

class Main {
    public static void main(String[] args) {
        int[] datas = new int[10];

        //채우기_3개(datas, 5);
        //나누기(datas, 2);
        try {
        }
        catch ( ArrayIndexOutOfBoundsException e ) {
            System.out.println("!!!!!!!!!!!!!!!!!!!!.");
        }
        catch ( ArithmeticException e ) {
            System.out.println("0으로 나눌 수 없습니다.");
        }
        catch ( Exception e ) {
            System.out.println("알 수 없는 이유로 수행되지 않았습니다.");
        }
        /*

         */

        for ( int i = 0; i < datas.length; i++ ) {
            System.out.println("datas[" + i +  "] : " + datas[i]);
        }
    }


}
