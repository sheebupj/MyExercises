package extenalizable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ExtenizableRead {
	public static void main(String[] args) {
		Employee1 emp=new Employee1();
		try(
				FileInputStream fileInputStream= new FileInputStream("employee1.ser");
				ObjectInputStream objectInputStream= new ObjectInputStream(fileInputStream);){
				emp.readExternal(objectInputStream);
				emp.disp();
			}catch(ClassNotFoundException cnf){
				cnf.printStackTrace();
			}catch(IOException ioe){
				ioe.printStackTrace();
			}
	}

}
