package Exceptions;

public class InventoryExceptions extends Exception{
	private String message;
	private String field;
	
	public InventoryExceptions(String message, String field) {
		super(message);
		this.message = message;
		this.field = field;
	}
	
	public String getMessage(){
		return this.field + " : " + this.message;
	}
}
