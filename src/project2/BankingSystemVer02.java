package project2;

import java.util.Scanner;


import ver02.AccountManager;
import ver02.MenuChoice;

public class BankingSystemVer02  implements MenuChoice{

	
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args){
		
		AccountManager manager = new AccountManager();
		while (true) {
			manager.showMenu();
			int selectNo = scanner.nextInt();
			switch(selectNo) {
			case MenuChoice.MAKE:
				manager.makeAccount();
				break;
			case MenuChoice.DEPOSIT:
				manager.depositMoney();
				break;
			case MenuChoice.WITHDRAW:
				manager.withdrawMoney();
				break;
			case MenuChoice.INQUIRE:
				manager.showAccInfo();
				break;
			case MenuChoice.EXIT:
				System.out.println("프로그램을 종료합니다.");
				return;
			}
		}
	}
}
	
