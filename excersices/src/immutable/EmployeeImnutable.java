package immutable;

public class EmployeeImnutable {
	private final int ino;
	private final String name;
	private final Address address;
	public EmployeeImnutable(int ino, String name, Address adr) {
		super();
		this.ino = ino;
		this.name = name;
		address= new Address();
		
		address.name=adr.name;
		address.hName=adr.hName;
		}
	public int getIno() {
		return ino;
	}
	public String getName() {
		return name;
	}
	public Address getAddress() {
		return (Address)address.clone();
	}
	
	

}
class Address{
	String name;
	String hName;
	
	protected Object clone(){
		return this.clone();
		
	}
	
	
	
}
