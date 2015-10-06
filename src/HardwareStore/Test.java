package HardwareStore;

import java.util.HashMap;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		System.out.println("Enter command:");
		System.out.println("1-add item");
		System.out.println("2-remove item");
		System.out.println("3-update item");
		System.out.println("4-display item");
		System.out.println("5-exit");
		Scanner in = new Scanner(System.in);
		ProcessCommands command = new ProcessCommands();
		boolean hasFinnish = false;
		do {
			String inputCommand= in.nextLine();
			String[] inputArgs = new String[4];
			int commandNum= Integer.parseInt(inputCommand);
			if (commandNum ==5) {
				hasFinnish = true;
				break;
			}
			else if (commandNum == 1) {
				System.out.print("Please enter Id: ");
				inputArgs[0]= in.nextLine();
				System.out.print("Please enter name: ");
				inputArgs[1]= in.nextLine();
				try {
					inputArgs[2]= in.nextLine();
				} catch (Exception e) {
					inputArgs[2]=null;
				}
				try {
					inputArgs[3]= in.nextLine();
				} catch (Exception e) {
					inputArgs[3]= null;
				}
				
				command.commandProcessing(1, inputArgs);
			}	
			else if (commandNum == 2) {
				inputArgs[0]= in.nextLine();				
				command.commandProcessing(2, inputArgs);
			}	
			else if (commandNum == 3) {
				inputArgs[0]= in.nextLine();
				inputArgs[1]= in.nextLine();
				try {
					inputArgs[2]= in.nextLine();
				} catch (Exception e) {
					inputArgs[2]=null;
				}
				try {
					inputArgs[3]= in.nextLine();
				} catch (Exception e) {
					inputArgs[3]= null;
				}
				command.commandProcessing(3, inputArgs);
			}	
			else if (commandNum == 4) {			
				command.commandProcessing(4, inputArgs);
				
			}
			System.out.println("do u want to continue?");
			
		} while (!hasFinnish);
		in.close();
	}

}
