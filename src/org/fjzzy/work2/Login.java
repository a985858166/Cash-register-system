package org.fjzzy.work2;

import java.util.Scanner;

public class Login {
	private static Scanner sc;

	public static void main(String[] args) {
		AdminData.addto();
		Data.addto1();
		LoginData.register1();
		
		sc = new Scanner(System.in);
		
		LoginData login = new LoginData();
		while(true){
			System.out.println("--------------欢迎使用29收银系统--------------");
			System.out.println("1 登录");
			System.out.println("2 管理");
			System.out.println("3 退出");
			System.out.print("请输入你的选择:");
			String Choice = sc.next();
			switch (Choice) {
		
			case "1":
				System.out.print("用户名：");
				String user = sc.next();
				System.out.print("密码：");
				String password = sc.next();
				
				if(login.Login(user, password)){
					System.out.println("登入成功");
					User P = new User(user);
					P.Panel1();
					
				}else {
					System.out.println("用户名或密码错误！");				}
				
				
				break;
	        
	        case "2":
	        	System.out.print("管理账号：");
	        	String adminuser = sc.next();
	        	System.out.print("管理密码：");
	        	String adminpassword = sc.next();
	        	if (AdminData.Login(adminuser, adminpassword)) {
					System.out.println("登入成功");
					Admin.admin();
				}else {
					System.out.println("登入失败");
				}
	        	
	        	
	        	break;
				
	        case "3":
	        	System.out.println("程序以退出");
				System.exit(0);
				break;
			default:
				System.out.print("输入错误请重新输入：");
				
				
			}
			
		}
		

	}

}
