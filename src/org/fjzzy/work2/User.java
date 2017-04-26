package org.fjzzy.work2;

import java.util.Scanner;

public class User {
	String user;
	private Scanner sc;
	public User(String user){
		this.user=user;
	}
	public void Panel1(){
		
		LoginData L = new LoginData();
		
		sc = new Scanner(System.in);
		
		boolean b = true;
		while(b){
			System.out.println("--------------欢迎使用29收银系统--------------");
			System.out.println("销售额:"+L.seemoney(user));
			System.out.println("本月预计工资："+L.seemoney1(user));
			System.out.println("1 生成商品订单");
			System.out.println("2 修改密码");
			System.out.println("3 注销");
			System.out.print("请输入你的选择:");
			String Choice = sc.nextLine();
			switch (Choice) {
			case "1":
				Purchase.purchase1(user);
				
				break;
	       
	        case "2":
	        	
	        	
	        	L.modify(user);
	        	
	        	
				
				break;
	        case "3":
	        	System.out.println("注销成功");
	        	b = false;
				
				break;

			default:
				System.out.print("输入有误请重新输入：");
				Choice = sc.nextLine();
				break;
			}
		}
		
	}

}
