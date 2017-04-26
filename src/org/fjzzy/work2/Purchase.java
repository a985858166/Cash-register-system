
package org.fjzzy.work2;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Scanner;

public class Purchase {
	static int OrderNum=1;
	
	private static Scanner sc;
	public static void purchase1(String user){
		ArrayList<String> list1 = new ArrayList<String>();
		ArrayList<String> list2 = new ArrayList<String>();
		ArrayList<Double> list3 = new ArrayList<Double>();
		ArrayList<Integer> list4 = new ArrayList<Integer>();
		ArrayList<Double> list5 = new ArrayList<Double>();
		
		sc = new Scanner(System.in);
		
		Data.display();
		System.out.println("====================================");
		LoginData L = new LoginData();
		
		
		String Str;
		Double Total=0.0;
		System.out.println("订单编号输入000可取消本次生成订单！");
		do {
			System.out.print("请输入你要购买的商品编号：");
			String ID = sc.next();
			while(!Data.judge(ID) | ID.equals("000")){
				if (ID.equals("000")) {
					System.out.println("本次服务到处结束");
					return;
				}
				System.out.print("无法找到该商品ID请重新输入：");
				ID = sc.next();
				
			}
			System.out.print("请输入要购买的商品数量：");
			int number;
			while(true){
				if (sc.hasNextInt()) {
					number = sc.nextInt();
					if (number>Data.number1(ID)) {
						System.out.print("购买的商品数量大于库存请重新输入：");
					}else {
						break;
					}
				}else {
					
					String str = sc.next();
					String str2 = str;
					str = str2;
					
					
					System.out.print("商品数量只允许阿拉伯数字请重新输入：");
				}
			}
			
			
			
			list1.add(ID);
			list2.add(Data.name(ID));
			list3.add(Data.price(ID));
			list4.add(number);
			list5.add(number*Data.price(ID));
			Total = Total + number*Data.price(ID);
			
			System.out.print("添加商品成功，是否继续添加商品（继续添加商品请输入Y或y，结算请输入N或n）:");
			Str = sc.next();
			while(!Str.equals("Y") && !Str.equals("y") && !Str.equals("N") && !Str.equals("n")){
				System.out.print("输入有误请重新输入：");
				Str = sc.next();
			}

		} while (Str.equals("Y") || Str.equals("y"));
		
		System.out.println("--------------------------------------------");
		System.out.println("============================================");
		if(OrderNum<10){
			System.out.println("订单编号：0000"+OrderNum);
		}else {
			if(OrderNum<100){
				System.out.println("订单编号：000"+OrderNum);
			}else {
				if(OrderNum<1000){
					System.out.println("订单编号：00"+OrderNum);
				}else {
					if (OrderNum<10000) {
						System.out.println("订单编号：0"+OrderNum);
					}else {
						System.out.println("订单编号："+OrderNum);
					}
				}
				
			}
		}
		 
		System.out.println("商品编号\t商品名称\t\t商品单价\t购买数量\t商品金额");
		Iterator<String> it1 = list1.iterator();
		Iterator<String> it1s = list1.iterator();
		Iterator<String> it2 = list2.iterator();
		Iterator<Double> it3 = list3.iterator();
		Iterator<Integer> it4 = list4.iterator();
		Iterator<Integer> it4s = list4.iterator();
		Iterator<Double> it5 = list5.iterator();
		while(it1.hasNext()){
			System.out.println(it1.next()+"\t"+it2.next()+"\t\t"+it3.next()+"\t"+it4.next()+"\t"+it5.next());
		}
		System.out.println("--------------------------------------------");
		System.out.println("\t\t\t\t\t合计："+Total);
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH)+1;
		int date = calendar.get(Calendar.DATE);
		int hour = calendar.get(Calendar.HOUR);
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);
		System.out.println("订单日期："+year+"-"+month+"-"+date+" "+hour+":"+minute+":"+second);
		System.out.println("============================================");
		OrderNum++;
		System.out.println("购物单已成功生成");
		while(it1s.hasNext()){
			Data.reduce(it1s.next(), it4s.next());
		}
		L.payment(user, Total);
		
		
		
	}
}
