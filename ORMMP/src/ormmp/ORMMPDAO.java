package ormmp;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.empresa.utils.ItemsForCRUD;

//import org.apache.ibatis.annotations.Mapper;
//import org.springframework.stereotype.Repository;

import com.empresa.utils.TableData;
import com.empresa.utils.TableParts;
import com.empresa.utils.TablePartsDAO;

import utilitarios.Conexion;
/*
 * 
 * @author Cesars Pinedo Olivera
 * 
 * */
public class ORMMPDAO {

	public static void main(String[] args) {

		Conexion conectar = new Conexion("com.microsoft.sqlserver.jdbc.SQLServerDriver",
				"jdbc:sqlserver://localhost:1433;databaseName=Empresa", "sa", "12345678");
		List<String> tablas = new ArrayList<>();
		// List<List<TableData>> datatablemayor = new ArrayList<>();
		try {
			ResultSet rs = conectar.EjecutarSQL("EXEC USP_GETTABLES");
			while (rs.next()) {
				String str = rs.getString(1);
				tablas.add(Character.toUpperCase(str.charAt(0)) + str.substring(1, str.length()).toLowerCase());
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		TablePartsDAO foo = new TablePartsDAO();
		for (String tabla : tablas) { 
			try {
				foo.setClassname(tabla);
				foo.setPackagename("com.millenniumprogrammers.neocomer.repository");
				foo.setMetodos(CrearCRUD(Class.forName("com.millenniumprogrammers.neocomer.model."+tabla)));
				CrearInterfaces(foo);
			} catch (ClassNotFoundException e) { 
				e.printStackTrace();
			}
		}
		// List<?> | ? | int | int | int | int
		// SelectALL|SelectById|Register|Update|Delete|DeleteById

	}

	private static String CrearCRUD(ItemsForCRUD ifc) {
		// TODO Auto-generated method stub
		
		String[]funciones = {"SelectALL","SelectById","Register","Update","Delete","DeleteById"};
		StringBuilder metodos = new StringBuilder();
		
		List<String>listaatributos = ifc.getListatributos();
		String atributosanidadoes="";
		for(String x : listaatributos)
		{
			atributosanidadoes +=x; 
		} 
		metodos
		.append("@Select(\"Select "+atributosanidadoes+" from "+ifc.getEntity()+"\") \n")
		.append("\t public List<"+ifc.getEntity()+"> "+funciones[0]+"();")
		.append("\n")
		.append("\t @Select(\"Select "+atributosanidadoes+" from "+ifc.getEntity()+" where "+listaatributos.get(0)+"= #{"+listaatributos.get(0)+"} \")");
		
		
		
				
		return metodos.toString();
	}
	
	private static String CrearCRUD(Class<?> ifc) {
		// TODO Auto-generated method stub
		
		String[]funciones = {"SelectALL","SelectById","Register","Update","Delete","DeleteById"};
		StringBuilder metodos = new StringBuilder();
		
		//List<String>listaatributos = ifc.getListatributos();
		Field[]campos = ifc.getDeclaredFields();
		String atributosanidadoesselect="";
		String atributosanidadoes="";
		String atributosanidadoesparam="";
		int ultimo=campos.length;
		for(int i = 0;i<ultimo;i++)
		{
			atributosanidadoesselect+=((i==ultimo-1)?campos[i].getName().toString():campos[i].getName().toString()+",");
			if(i!=0)
			{
			atributosanidadoes+=((i==ultimo-1)?campos[i].getName().toString():campos[i].getName().toString()+",");
			}
		}		
		for(int i = 1;i<ultimo;i++) 
		{
			atributosanidadoesparam+=((i==ultimo-1)?"#{"+campos[i].getName().toString()+"}":"#{"+campos[i].getName().toString()+"},");	
		}
		String[] camposset = atributosanidadoes.split(",");
		String[] camposset2= atributosanidadoesparam.split(","); 
		
		String strupdate="";
		int ultimo2 = camposset.length;
		for(int i = 1;i<ultimo2;i++)
		{
			strupdate += i==ultimo2-1?camposset[i]+"="+camposset2[i]:camposset[i]+"="+camposset2[i]+",";
		}
		metodos
		.append("\t@Select(\"Select "+atributosanidadoesselect+" from "+ifc.getSimpleName()+"\") \n" )
		.append("\tpublic List<"+ifc.getSimpleName()+"> "+funciones[0]+"(); \n \n") 
		
		.append("\t@Select(\"Select "+atributosanidadoesselect+" from "+ifc.getSimpleName()+" where "+campos[0].getName().toString()+"= #{"+campos[0].getName().toString()+"} \") \n")
		.append("\tpublic "+ifc.getSimpleName()+" "+funciones[1]+"("+ifc.getSimpleName()+" bean); \n \n")
		
		.append("\t@Insert(\"insert into "+ifc.getSimpleName()+"("+atributosanidadoes+") ")
		.append("values("+atributosanidadoesparam+")\" ) \n")
		.append("\tpublic int "+funciones[2]+"("+ifc.getSimpleName()+" bean ); \n \n")
				
		.append("\t@Update(\"update "+ifc.getSimpleName()+" set "+strupdate+" where "+camposset[0]+"="+camposset2[0]+" \") \n")
		.append("\tpublic int "+funciones[3]+"("+ifc.getSimpleName()+" bean);");
		 
		return metodos.toString();
	}

	// List<String>campos,String TableName,
	public static void CrearInterfaces(TablePartsDAO parts) {
		FileWriter fichero = null;
		PrintWriter pw = null;
		try {
			// fichero = new
			// FileWriter("E:\\ServiceProver\\src\\java\\pe\\com\\proveer\\beans\\model\\" +
			// parts.getClassname() + ".java");
			// fichero = new FileWriter("C:\\Users\\cesars\\Desktop\\clases\\" +
			// parts.getClassname() + ".java");
			
			//fichero = new FileWriter("C:\\Users\\cesars\\git\\NeoComerController\\neocomer\\src\\main\\java\\com\\millenniumprogrammers\\neocomer\\repository\\"+ parts.getClassname() + "DAO.java");
			fichero = new FileWriter("C:\\Users\\Administrador\\git\\NeoComerController\\neocomer\\src\\main\\java\\com\\millenniumprogrammers\\neocomer\\repository\\"+ parts.getClassname() + "DAO.java");
			//fichero = new FileWriter("D:\\USB JUNIO AZUL\\ORMMP\\src\\com\\millenniumprogrammers\\neocomer\\repository\\"+ parts.getClassname() + "DAO.java");

			pw = new PrintWriter(fichero);
			pw.print("" + "package " + parts.getPackagename() + ";\n \n"
					+ "import java.util.List; \n"
					+ "import org.apache.ibatis.annotations.Delete; \n"
					+ "import org.apache.ibatis.annotations.Insert; \n"
					+ "import org.apache.ibatis.annotations.Mapper; \n"
					+ "import org.apache.ibatis.annotations.Select; \n"
					+ "import org.apache.ibatis.annotations.Update; \n"
					+ "import org.springframework.stereotype.Repository;\n"
					+ "import com.millenniumprogrammers.neocomer.model."+parts.getClassname()+"; \n \n" 
					+ "@Repository \n" 
					+ "@Mapper \n"
					+ "public interface " + parts.getClassname() + "DAO {\n" 
					+ "\n" 
					+ parts.getMetodos() + "\n \n }\n" + "");
		} catch (IOException e) {
			System.err.println(e);
		} finally {
			try {
				if (null != fichero) {
					fichero.close();
				}
			} catch (IOException e2) {
				System.err.println(e2.getMessage());
			}
		}
	}

}
