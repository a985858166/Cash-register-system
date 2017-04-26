package org.fjzzy.work2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class LoginData {
	static ArrayList<String> listuser = new ArrayList<String>();
	static ArrayList<String> listpassword = new ArrayList<String>();
	static ArrayList<Double> listmoney = new ArrayList<Double>();
	private Scanner sc;
	private static Scanner sc2;
	private static Scanner sc3;
	public void see(){
		
		
		Iterator<String> it1 = listuser.iterator();
		Iterator<Double> it2 = listmoney.iterator();
		Iterator<Double> it3 = listmoney.iterator();
		System.out.println("收银员列表\t销售额\t预计工资");
		while(it1.hasNext()){
			
			
			System.out.println(it1.next()+"\t"+it2.next()+"\t"+(it3.next()*0.05+2000));
		}
	}
	public static void see1(){
		System.out.println("输入000取消修改密码！");
		sc3 = new Scanner(System.in);
		String user;
		int i;
		while(true){
			System.out.print("请输入你要修改的收银员用户名：");
			user = sc3.next();
			if (user.equals("000")) {
				System.out.println("取消成功");
				return;
			}else {
				if (listuser.contains(user)) {
					i = listuser.indexOf(user);
					System.out.print("请输入新密码：");
					listpassword.set(i, sc3.next());
					System.out.println("密码修改成功！");
					return;
				}else {
					System.out.println("此收银员不存在！");
				}
			}
		}
	}
	public boolean Login(String user, String password) {
		if(listuser.indexOf(user)!=-1){
			if(listpassword.get(listuser.indexOf(user)).equals(password)){
				return true;
			}
		}
		
		
		return false;
	}

	public boolean register(String newuser, String newpassword) {
		if (listuser.contains(newuser)) {
			return false;
		}else {
			listuser.add(newuser);
			listpassword.add(newpassword);
			listmoney.add(0.0);
			
			return true;
		}
		
	}
	public static void register1(){
		listuser.add("123");
		listpassword.add("123");
		listmoney.add(0.0);
	}
	public Double seemoney(String user){
		return listmoney.get(listuser.indexOf(user));
	}
	public Double seemoney1(String user){
		return 2000.0 + listmoney.get(listuser.indexOf(user))*0.05;
	}

	public void payment(String user,Double Total){
		listmoney.set(listuser.indexOf(user), listmoney.get(listuser.indexOf(user))+Total);
	}
	public void modify(String user){
		sc = new Scanner(System.in);
		System.out.print("旧密码：");
		String oldpassword = sc.next();
		System.out.print("新密码：");
		String newpassword = sc.next();
		if(listpassword.get(listuser.indexOf(user)).equals(oldpassword)){
			listpassword.set(listuser.indexOf(user), newpassword);
			System.out.println("密码修改完成！");
		}else {
			System.out.println("旧密码错误！修改失败");
			
			return;
		}
	}
	public static void delete(){
		System.out.println("输入000可取消删除！");
		sc2 = new Scanner(System.in);
		String user;
		int i;
		while(true){
			System.out.print("请输入你要删除的收银员用户名：");
			user = sc2.next();
			if (user.equals("000")) {
				System.out.println("取消成功");
				return;
			}else {
				if (listuser.contains(user)) {
					i = listuser.indexOf(user);
					listuser.remove(i);
					listpassword.remove(i);
					listmoney.remove(i);
					System.out.println("删除成功！");
					return;
				}else {
					System.out.println("此收银员不存在！");
				}
			}
		}
	}
	

}
