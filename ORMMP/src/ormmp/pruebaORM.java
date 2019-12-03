package ormmp;

import java.io.IOException;
import java.lang.reflect.Field;

public class pruebaORM {

	public static void main(String[] args) throws IOException{

		
		try {
			Class cls = Class.forName("com.millenniumprogrammers.neocomer.model.Roles");
			
			Field[]campos = cls.getDeclaredFields();
			
			for(Field cam : campos)
			System.out.println(cam.getName().toString());
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
