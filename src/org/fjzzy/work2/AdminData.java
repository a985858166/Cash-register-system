package org.fjzzy.work2;

import java.util.ArrayList;
import java.util.Scanner;

public class AdminData {
	static ArrayList<String> listuser = new ArrayList<String>();
	static ArrayList<String> listpassword = new ArrayList<String>();
	private static Scanner sc;
	public static boolean Login(String user, String password) {
		if(listuser.indexOf(user)!=-1){
			if(listpassword.get(listuser.indexOf(user)).equals(password)){
				return true;
			}
		}
		return false;
	}
	
	public static void modify(){
		sc = new Scanner(System.in);
		listuser.clear();
		listpassword.clear();
		System.out.print("请输入新的账号：");
		listuser.add(sc.next());
		System.out.print("请输入新的密码：");
		listpassword.add(sc.next());
		System.out.println("修改成功！");
		
		
	}
	public static void addto(){
		listuser.add("admin");
		listpassword.add("admin");
	}

}
