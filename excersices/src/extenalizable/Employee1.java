package extenalizable;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

import serialization.Employee;

public class Employee1 implements Externalizable {
	String name;
	Long id;
	Double salary;
	String department;
	
	public Employee1() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee1(String name, Long id, Double salary,String dpt) {
		super();
		this.name = name;
		this.id = id;
		this.salary = salary;
		this.department=dpt;
	}
	void disp(){
		System.out.println("name:"+ name + " id:"+id + " salary:"+ salary + " Depart:"+department);
	}

	@Override
	public void readExternal(ObjectInput stream) throws IOException, ClassNotFoundException {
		name=stream.readUTF();
		id=stream.readLong();
		salary=stream.readDouble();
		department=stream.readUTF();

	}

	@Override
	public void writeExternal(ObjectOutput stream) throws IOException {
	
				stream.writeUTF(name);
				stream.writeLong(id);
				stream.writeDouble(salary);
				stream.writeUTF(department);
	}

	

}
