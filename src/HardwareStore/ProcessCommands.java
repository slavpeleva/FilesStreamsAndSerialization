package HardwareStore;

public class ProcessCommands {
	private Store store;

	public void commandProcessing(int command, String[] arg) {
		switch (command) {
		case 1:
			Inventory inv = new Inventory(Integer.parseInt(arg[0]), arg[1]);
			if (arg[2] != null&& !arg[2].isEmpty()) {
				inv.setAvailability(Integer.parseInt(arg[2]));
			}
			if (arg[3] != null&& !arg[3].isEmpty()) {
				inv.setPrice(Double.parseDouble(arg[3]));
			}
			this.store.addTool(inv);

			break;
		case 2:
			this.store.removeTool(Integer.parseInt(arg[0]));
			break;
		case 3:
			Inventory inv1 = new Inventory(Integer.parseInt(arg[0]), arg[1]);
			if (arg[2] != null&& !arg[2].isEmpty()) {
				inv1.setAvailability(Integer.parseInt(arg[2]));
			}
			if (arg[3] != null&& !arg[3].isEmpty()) {
				inv1.setPrice(Double.parseDouble(arg[3]));
			}
			this.store.updateTool(inv1);
			break;
		case 4:
			this.store.displayStorage();
			break;

		default:
			System.out.println("Invalid command");
			break;
		}
	}

	public ProcessCommands() {
		super();
		this.store = new Store();
	}
}
