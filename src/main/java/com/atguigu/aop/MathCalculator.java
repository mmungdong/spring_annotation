package com.atguigu.aop;
/**
 * 业务逻辑类
 * @author 51019
 *
 */
public class MathCalculator {
	
	public int div(int i,int j) {
		System.out.println("MathCalculator...div...");
		return i/j;
	}

}
