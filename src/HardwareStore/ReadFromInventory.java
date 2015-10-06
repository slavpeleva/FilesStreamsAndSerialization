package HardwareStore;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;

public class ReadFromInventory {
	private ObjectInputStream input;
	
	private void openForReadInventoryFile(){
		try {
			input = new ObjectInputStream(new FileInputStream("inventory.ser"));
		} catch (FileNotFoundException e) {
			System.err.println("No such file");		
		} catch (IOException e) {
			System.err.println("Error opening file");			
		}
	}
	public HashMap<Integer, Inventory> readFromInventory(){
		openForReadInventoryFile();
		HashMap<Integer, Inventory>  inv = null;
		try {
			 inv= (HashMap<Integer, Inventory>)input.readObject();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			closeReadFromInventoryFile();
		}
		return inv;
	}
	private void closeReadFromInventoryFile(){
		try {
			if (input != null) {
				input.close();
			}
		} catch (IOException e) {
			System.err.println("Problem with closing file");
			//System.exit(1);
		}
	}
	public boolean isFileEmpty(){
		try {
			openForReadInventoryFile();
		} catch (Exception e) {
			return true;
		}
		finally{
			closeReadFromInventoryFile();
		}
		return false;
	}
}
