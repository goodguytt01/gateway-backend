package com.innovation.emall.system.provider;


import java.util.Scanner;

import java.util.Scanner;

public class Main{
    public static void main(String[]args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String num = in.nextLine();
            System.out.println(Integer.parseInt(num,16));
        }
    }
}
