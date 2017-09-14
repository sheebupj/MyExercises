package serialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeSerialization {
	public static void main(String[] args) {
		try(FileInputStream fileInputStream= new FileInputStream("employee.ser");
			ObjectInputStream objectInputStream= new ObjectInputStream(fileInputStream);){
			Employee empDser =(Employee)objectInputStream.readObject();
			empDser.disp();
		}catch(ClassNotFoundException cnf){
			cnf.printStackTrace();
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
	}

}
