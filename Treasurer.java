package MEM;

import java.util.ArrayList;
import java.util.Scanner;

public class Treasurer {

	
	
	public static ArrayList<String> list = new ArrayList<String>() ;
	
	public static ArrayList<Months> months;
	
	public static double income(double clubmoney, double money){
		double income = money + clubmoney;
		list.add(money + " was added into the club account" );
		return income;
	}
	
	public static double expenses(double clubmoney, double money, String reason){
		double income = clubmoney - money;
		list.add(money + " was used to pay for " + reason );
		return income;
	}
	
	
	public static void TitleScreen(double accmoney){
		Scanner input = new Scanner(System.in);
		
		System.out.println("Welcome Treasurer the Club has " + accmoney + " do what you want");
		
		while(true){
		System.out.println("If you want to put money in press I or if you want to take money out press X");
		String outcome = input.nextLine();
		
		if(outcome.equalsIgnoreCase("i")){
        inc(accmoney);
		}
		else if (outcome.equalsIgnoreCase("x")){
        exp(accmoney);
		}
		else if (outcome.equalsIgnoreCase("l")){
			printlog(accmoney);
		}
		else
		{
			System.out.println("Didnt recieve a correct response, Try again");
		}
		}
	}
	
	
	public static void exp(double accmoney){
		Scanner input = new Scanner(System.in);
		System.out.println("How much money will you like to take out?");
		Double money = input.nextDouble();
		System.out.println("Why is this money being taken out?");
		System.out.println();
		String reason = input.nextLine();
		
		
		accmoney = expenses(accmoney,money, reason);
	    System.out.println("new acc money is " + accmoney);
	    TitleScreen(accmoney);
	}
	
public static void inc(double accmoney){
	Scanner input = new Scanner(System.in);
	System.out.println("How much money will you like to add?");
	Double money = input.nextDouble();
    accmoney = income(accmoney,money);
    System.out.println("new acc money is " + accmoney);
    TitleScreen(accmoney);
	}
	

public static void printlog(double accmoney){
	for (String temp : list) {
		System.out.println(temp);
	}
	TitleScreen(accmoney);
}

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    double accmoney = 5000;
		Scanner input = new Scanner(System.in);
		
		TitleScreen(accmoney);
		
		
		
	}

}
