package org.fjzzy.work2;

import java.util.Scanner;

public class Admin {

	private static Scanner sc;

	public static void admin() {
		LoginData login = new LoginData();
		sc = new Scanner(System.in);
		while(true){
			System.out.println("1 查看商品");
			System.out.println("2 添加商品");
			System.out.println("3 修改商品价格");
			System.out.println("4 修改商品库存");
			System.out.println("5 删除商品");
			System.out.println("6 查看收银员");
			System.out.println("7 修改收银员密码");
			System.out.println("8 添加收银员");
			System.out.println("9 删除收银员");
			System.out.println("10 修改管理员账号密码");
			System.out.println("11 注销");
			System.out.print("请输入你的选择:");
			String Choice = sc.next();
			switch (Choice) {
			case "1":
				Data.display();
				
				break;
			
	        case "2":
				Data.addto();
				
				break;
	        case "3":
				Data.modify1();
				
				break;
	        case "4":
				Data.modify2();
				
				break;
	        case "5":
	        	
				Data.delete();
				
		    break;
	        case "6":
				login.see();
				
				break;
	        case "7":
				LoginData.see1();
				
				break;
            case "8":
	        	
            	System.out.print("用户名：");
	        	String newuser = sc.next();
	        	System.out.print("密码：");
	        	String newpassword = sc.next();
	        	if(login.register(newuser, newpassword)){
	        		System.out.println("添加成功");
	        	}else {
					System.out.println("添加失败");
				}
				
		    break;
            case "9":
				LoginData.delete();
				
				break;
            
	        case "10":
				AdminData.modify();
				
				break;
	        case "11":
	        	System.out.println("已成功注销");
				return;

			default:
				System.out.println("输入错误");
			
				break;
			}
		}
		

	}

}
