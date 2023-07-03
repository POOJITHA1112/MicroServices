package com.service;

public class A {
	private int ab;
	private int cd;

	A(A abc) {
		this.ab = abc.ab;
		this.cd = abc.cd;
	}

	A(int ab, int cd) {
		this.ab = ab;
		this.cd = cd;
	}
	
	public int getAb() {
		return ab;
	}

	public void setAb(int ab) {
		this.ab = ab;
	}

	public int getCd() {
		return cd;
	}

	public void setCd(int cd) {
		this.cd = cd;
	}

	public static void main(String[] args) {
		A a=new A(1, 2);
		
		A a2=new A(a);
		System.out.println(a.ab);
		System.out.println(a2.ab);
		System.out.println(a.cd);
		System.out.println(a2.cd);
		a2.setCd(10);
		System.out.println(a2.cd);
		
	}
}
