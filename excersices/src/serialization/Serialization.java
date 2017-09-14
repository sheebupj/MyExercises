package serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serialization {
	public static void main(String[] args) {
		Employee emp = new Employee("sheebu", 724L, 38000.0,200.0);
		try(
			FileOutputStream fileOutputStream= new FileOutputStream("employee.ser");
			ObjectOutputStream objectOutputStream= new ObjectOutputStream(fileOutputStream);){
			objectOutputStream.writeObject(emp);
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
		
	}

}
