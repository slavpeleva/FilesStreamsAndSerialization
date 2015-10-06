package Exceptions;

public class DuplicatedIdException extends InventoryExceptions {

	public DuplicatedIdException(int id) {
		super("Already exist", "Id "+id);
		// TODO Auto-generated constructor stub
	}

}
