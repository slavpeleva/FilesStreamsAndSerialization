package HardwareStore;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class WriteToolsInInventory {
	private ObjectOutputStream output;

	private void openInventoryFile() {
		try {
			output = new ObjectOutputStream(new FileOutputStream(
					"inventory.ser"));
		} catch (FileNotFoundException e) {
			System.err.println("File not found");

		} catch (IOException e) {
			System.err.println("Problem with opening");
		}
	}
	public void writeToInventoryFile(HashMap<Integer, Inventory> inv){
		try {
			openInventoryFile();
			output.writeObject(inv);
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}finally{
			closeInventoryFile();
		}
	}
	
	private void closeInventoryFile() {
		if (output != null) {
			try {
				output.close();
			} catch (IOException e) {
				System.err.println(e.getMessage());
				//System.exit(1);
			}
		}
	}
}
