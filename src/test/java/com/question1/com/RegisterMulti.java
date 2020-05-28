package com.question1.com;

public class RegisterMulti extends Register{

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		for(int i =1;i<=5;i++)
		{
			connection("http://demo.guru99.com/test/newtours/register.php");
			registerUser();
			Register.driver.close();
		}
		
	}

}
