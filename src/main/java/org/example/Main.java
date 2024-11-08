package org.example;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        System.out.println("==프로그램 시작==");

        Scanner sc = new Scanner(System.in);

        System.out.println("명령어 입력 : "); //문장 입력 대기
        String command = sc.nextLine();

        System.out.println("입력된 명령어 : "); //입력값 출력
        System.out.println(command);

        sc.close();  //스캐너 종료

        System.out.println("==프로그램 끝==");
    }
}
