package org.fjzzy.work2;

import java.util.ArrayList;
import java.util.Scanner;

public class Data {
	
	static ArrayList<String> listId = new ArrayList<String>();
	static ArrayList<String> listName = new ArrayList<String>();
	static ArrayList<Double> listPrice  = new ArrayList<Double>();
	static ArrayList<Integer> listStock  = new ArrayList<Integer>();
	public static int i;
	private static Scanner sc;
	private static Scanner sc1;
	public static void addto1(){
		listId.add(number());listName.add("矿泉水");listPrice.add(1.00);listStock.add(1000);
		listId.add(number());listName.add("菊花茶");listPrice.add(1.50);listStock.add(1000);
		listId.add(number());listName.add("酸梅汤");listPrice.add(3.00);listStock.add(1000);
		listId.add(number());listName.add("脉动");listPrice.add(4.00);listStock.add(1000);
		listId.add(number());listName.add("可乐");listPrice.add(3.00);listStock.add(1000);
	}
	public static void display(){
		
		
		System.out.println("============================================");
		System.out.println("\t\t商品列表");
		System.out.println("--------------------------------------------");
		System.out.println("商品编号\t商品名称\t\t商品单价\t商品库存");
		for(int i =0;i<listId.size();i++){
			
			System.out.println(listId.get(i)+"\t"+listName.get(i)+"\t\t"+listPrice.get(i)+"\t"+listStock.get(i));
		}
		
	}
	public static String number(){
		
		
		if(listId.size()+1<10){
			return "00"+String.valueOf(listId.size()+1);	
		}else {
			if(listId.size()+1<100){
				return "0"+String.valueOf(listId.size()+1);
			}else {
				return String.valueOf(listId.size()+1);
			}
		}
		
	}
	public static void addto(){
		sc = new Scanner(System.in);
		
		System.out.print("请输入商品名称：");
		String name;
		while(true){
			name = sc.next();
			if (listName.contains(name)) {
				System.out.print("此商品以存在不能重复添加请重新输入商品名称：");
				
			}else {
				break;
			}
		}
		System.out.print("请输入单价：");
		Double price;
		while (true) {
			if(sc.hasNextDouble()){
				price = sc.nextDouble();
				if(price>=0){
					break;
				}else {
					System.out.print("单价不能为负数请重新输入：");
				}
			}else {
				String str = sc.next();
				String str2 = str;
				str = str2;
				System.out.print("单价只允许阿拉伯数字请重新输入：");
			}
		}
		System.out.print("请输入库存：");
		int stock;
		
		while (true) {
			if(sc.hasNextInt()){
				stock = sc.nextInt();
				if(stock>=0){
					break;
				}else {
					System.out.print("库存不能为负数请重新输入：");
				}
			}else {
				String str = sc.next();
				String str2 = str;
				str = str2;
				System.out.print("库存数量只允许阿拉伯数字请重新输入：");
			}
		}
		listId.add(number());listName.add(name);listPrice.add(price);listStock.add(stock);
		System.out.println("添加商品完成");
			
	}
	public static boolean judge(String ID){
		return listId.contains(ID);
	}
	public static Integer number1(String ID){
		
		return listStock.get(listId.indexOf(ID));
	}
	public static String name(String ID){
		
		return listName.get(listId.indexOf(ID));
	}
	public static Double price(String ID){
		return listPrice.get(listId.indexOf(ID));
	}
	public static void reduce(String ID,Integer i){
		listStock.set(listId.indexOf(ID), listStock.get(listId.indexOf(ID))-i);
	}
	public static void delete(){
		Data.display();
		System.out.println("输入000可返回上一级");
		System.out.print("请输入你要删除商品的编号：");
		sc1 = new Scanner(System.in);
		String ID = sc1.next();
		while(!Data.judge(ID) | ID.equals("000")){
			if (ID.equals("000")) {
				System.out.println("已成功返回上一级");
				return;
			}
			System.out.print("无法找到该商品ID请重新输入：");
			ID = sc1.next();
			
		}
		i = listId.indexOf(ID);
		listId.remove(i);
		listName.remove(i);
		listPrice.remove(i);
		listStock.remove(i);
		while(i<=listId.size()){
			if (i==0) {
				i++;
			}
			listId.set(i-1, delete1(i-1));
			i++;
		}
		System.out.println("删除商品成功");
		
		
	}
	public static String delete1(Integer i){
		if(i+1<10){
			return "00"+String.valueOf(i+1);	
		}else {
			if(listId.size()+1<100){
				return "0"+String.valueOf(i+1);
			}else {
				return String.valueOf(i+1);
			}
		}
		
		
	}
	public static void modify1(){
		Data.display();
		System.out.println("输入000可返回上一级");
		System.out.print("请输入你要修改商品的编号：");
		sc = new Scanner(System.in);
		String ID = sc.next();
		while(!Data.judge(ID) | ID.equals("000")){
			if (ID.equals("000")) {
				System.out.println("已成功返回上一级");
				return;
			}
			System.out.print("无法找到该商品ID请重新输入：");
			ID = sc.next();
			
		}
		System.out.print("请输入修改后的单价：");
		sc1 = new Scanner(System.in);
		Double price;
		while (true) {
			if(sc.hasNextDouble()){
				price = sc.nextDouble();
				if(price>=0){
					break;
				}else {
					System.out.print("单价不能为负数请重新输入：");
				}
			}else {
				String str = sc.next();
				String str2 = str;
				str = str2;
				System.out.print("单价只允许阿拉伯数字请重新输入：");
			}
		}
		i = listId.indexOf(ID);
		listPrice.set(i, price);
		System.out.println("价格修改成功！");
	}
	public static void modify2(){
		Data.display();
		System.out.println("输入000可返回上一级");
		System.out.print("请输入你要修改商品的编号：");
		sc = new Scanner(System.in);
		String ID = sc.next();
		while(!Data.judge(ID) | ID.equals("000")){
			if (ID.equals("000")) {
				System.out.println("已成功返回上一级");
				return;
			}
			System.out.print("无法找到该商品ID请重新输入：");
			ID = sc.next();
			
		}
		System.out.print("请输入修改后的库存：");
		sc1 = new Scanner(System.in);
		int Stock;
		while (true) {
			if(sc.hasNextInt()){
				Stock = sc.nextInt();
				if(Stock>=0){
					break;
				}else {
					System.out.print("库存不能为负数请重新输入：");
				}
			}else {
				String str = sc.next();
				String str2 = str;
				str = str2;
				System.out.print("库存数量只允许阿拉伯数字请重新输入：");
			}
		}
		i = listId.indexOf(ID);
		listStock.set(i, Stock);
		System.out.println("库存修改成功！");
	}

}
