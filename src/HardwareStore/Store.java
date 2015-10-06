package HardwareStore;

import java.util.HashMap;

import Exceptions.DuplicatedIdException;
import Exceptions.InvalidIdException;

public class Store {
	private HashMap<Integer, Inventory> storage;
	private WriteToolsInInventory write;
	private ReadFromInventory read;

	public Store() {
		super();
		this.write = new WriteToolsInInventory();
		this.read = new ReadFromInventory();
		if (this.read.isFileEmpty()) {
			this.storage = new HashMap<Integer, Inventory>();
		}
		else {
			readStorage();
		}
	}

	public void addTool(Inventory inv) {
		if (this.storage.containsKey(inv.getId())) {
			try {
				throw new DuplicatedIdException(inv.getId());
			} catch (DuplicatedIdException e) {
				System.err.println(e.getMessage());
			}
		} else {
			this.storage.put(inv.getId(), inv);
			updateStorage();
		}

	}

	public void removeTool(int id) {
		if (!this.storage.containsKey(id)) {
			try {
				throw new InvalidIdException();
			} catch (InvalidIdException e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
			}
		} else {
			this.storage.remove(id);
			updateStorage();
		}
	}

	public void updateTool(Inventory inv) {
		if (!this.storage.containsKey(inv.getId())) {
			try {
				throw new InvalidIdException();
			} catch (InvalidIdException e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
			}
		} else {
			this.storage.put(inv.getId(), inv);
			updateStorage();
		}
	}

	public void displayStorage() {
		StringBuilder sb = new StringBuilder();
		sb.append("ID	Name	Availability	Price").append("\n");
		readStorage();
		this.storage.forEach((k, v) -> sb.append(
				v.getId() + "	" + v.getName() + "	" + v.getAvailability() + "		"
						+ v.getPrice()).append("\n"));
		System.out.println(sb.toString());

	}

	private void updateStorage() {
		write.writeToInventoryFile(this.storage);

	}

	private void readStorage() {
		this.storage = read.readFromInventory();
	}
}
