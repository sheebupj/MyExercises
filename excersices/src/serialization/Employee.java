package serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Employee extends ParentWithoutSeriazable implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String name;
	Long id;
	Double salary;
	String Department="abc";
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(String name, Long id, Double salary,Double d) {
		super(d);
		this.name = name;
		this.id = id;
		this.salary = salary;
	}
	void disp(){
		System.out.println("name:"+ name + " id:"+id + " salary:"+ salary + " Depart:"+Department + " " + double1);
	}
	

}
