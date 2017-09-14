package extenalizable;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import serialization.Employee;

public class ExtenalzableWrite {
	public static void main(String[] args) {
		Employee1 emp = new Employee1("sheebu", 724L, 38000.0,"abc");
		try(
				FileOutputStream fileOutputStream= new FileOutputStream("employee1.ser");
				ObjectOutputStream objectOutputStream= new ObjectOutputStream(fileOutputStream);){
				emp.writeExternal(objectOutputStream);
			}catch(IOException ioe){
				ioe.printStackTrace();
			}
	}

}
