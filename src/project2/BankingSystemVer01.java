package project2;

import java.util.Scanner;

import ver01.Account;
import ver01.MenuChoice;

public class BankingSystemVer01  implements MenuChoice{

	static Account[] accountArray = new Account[50];
	static Scanner scanner = new Scanner(System.in);
	
	
	
	public static void main(String[] args){
		
		while (true) {
			showMenu();
			int selectNo = scanner.nextInt();
			switch(selectNo) {
			case MenuChoice.MAKE:
				makeAccount();
				break;
			case MenuChoice.DEPOSIT:
				depositMoney();
				break;
			case MenuChoice.WITHDRAW:
				withdrawMoney();
				break;
			case MenuChoice.INQUIRE:
				showAccInfo();
				break;
			case MenuChoice.EXIT:
				System.out.println("프로그램을 종료합니다.");
				return;
			}
		}
	}
	
	public static void showMenu() {
		System.out.println("1.계좌계설");
		System.out.println("2.입금");
		System.out.println("3.출금");
		System.out.println("4.전체계좌정보출력");
		System.out.println("5.프로그램종료");
	}
	
	public static void makeAccount() {
		System.out.println("--------");
		System.out.println("계좌생성");
		System.out.println("--------");
		System.out.print("계좌번호: ");
		String no = scanner.next();
		
		System.out.print("계좌주");
		String owner = scanner.next();
		
		System.out.println("잔고");
		int balance = scanner.nextInt();
		
		for(int i=0; i<accountArray.length; i++) {
			if(accountArray[i] == null) {
				accountArray[i] = new Account(no,owner,balance);
				System.out.println("결과 : 계좌가 생성되었습니다.");
			}
			else {
				accountArray[i].getno().equals(no);
					System.out.println("동일한 계좌번호가 있습니다.");
			}
			break;
		}
	}
	
	public static void depositMoney() {
		System.out.println("--------");
		System.out.println("입금");
		System.out.println("--------");
		System.out.print("계좌번호: ");
		String no = scanner.next();
		System.out.print("입금액");
		int dep = scanner.nextInt();
		
		if(findAccount(no) == null) {
			System.out.println("입력한 계좌번호를 찾지 못했습니다.");
		}
		else {
			findAccount(no).setBalance(findAccount(no).getBalance()+dep);
			System.out.println("입금되었습니다.");
		}
		
		
	}
	
	public static void withdrawMoney() {
		System.out.println("--------");
		System.out.println("출금");
		System.out.println("--------");
		System.out.print("계좌번호: ");
		String no = scanner.next();
		System.out.print("출금액");
		int withd = scanner.nextInt();
		
		if(findAccount(no) == null) {
			System.out.println("입력한 계좌번호를 찾지 못했습니다.");
		}
		else {
			if(withd > findAccount(no).getBalance()) {
				System.out.println("잔액보다 큰 액수입니다.");
			}
			else {
				findAccount(no).setBalance(findAccount(no).getBalance() - withd);
				System.out.println("출금되었습니다.");
			}
		}
	}
	
	public static void showAccInfo() {
		System.out.println("--------");
		System.out.println("계좌목록보기");
		System.out.println("--------");
		
		for (int i = 0; i < accountArray.length; i++) {
			if (accountArray[i] == null) {
				break;
			}
			System.out.println("계좌번호: "+ accountArray[i].getno());
			System.out.println("고객이름: " +accountArray[i].getowner());
			System.out.println("잔고: "+accountArray[i].getBalance());
		
		}
		System.out.println("전체계좌정보 출력이 완료되었습니다.");
	}
	
	private static Account findAccount(String no) {
		for(int i=0; i < accountArray.length; i++) {
			if(accountArray[i] == null) {
				break;
			}
			if (accountArray[i].getno().equals(no)) {
				return accountArray[i];
			}
		}
		return null;
	}
}
	




