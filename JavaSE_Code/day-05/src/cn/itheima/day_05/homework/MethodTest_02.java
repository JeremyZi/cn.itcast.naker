package cn.itheima.day_05.homework;

import java.util.Scanner;

public class MethodTest_02 {

	/*
	1.定义方法public static boolean isSXH(int num)，
		功能:判断数字num是否是水仙花数,如果是返回true,如果不是返回false。
	2.在main方法中调用该方法，传入数字，打印结果。(所谓的水仙花数是指一个三位数，其各位数字的立方和等于该数本身。)
		打印：传入数字153，结果为true，该数字是水仙花数。
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一个三位数：");
		int num = sc.nextInt();
		System.out.println(isSXH(num));

	}

	//返回类型为boolean,参数类型为int
	public static boolean isSXH(int num) {

		int singleDigit = num % 10;
		int tensDigit = num / 10 % 10;
		int hundredDigit = num / 100;

		return singleDigit * singleDigit * singleDigit + tensDigit * tensDigit * tensDigit + hundredDigit * hundredDigit * hundredDigit == num;


	}
}
