package ormmp;

import com.empresa.utils.DataType;
import com.empresa.utils.TableData;
import com.empresa.utils.TableParts;
//import com.millenniumprogrammers.neocomer.model.Categoria;

//import lombok.AllArgsConstructor;
//import lombok.NoArgsConstructor;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utilitarios.Conexion;

public class ORMMP {

    public static void main(String[] args) {
        // TODO code application logic here
    	Conexion conectar = new Conexion("com.microsoft.sqlserver.jdbc.SQLServerDriver", "jdbc:sqlserver://localhost:1433;databaseName=Empresa", "sa", "12345678");
        //Conexion conectar = new Conexion("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/proveerdb", "root", "12345678");
        List<String> tablas = new ArrayList<>();
        /*-------LLENAR NOMBRES DE LAS TABLAS //CLASES NAME*/
        List<List<TableData>> datatablemayor = new ArrayList<>();
        try {
            ResultSet rs = conectar.EjecutarSQL("EXEC USP_GETTABLES");
            while (rs.next()) {
                String str = rs.getString(1);
                tablas.add(Character.toUpperCase(str.charAt(0)) + str.substring(1, str.length()).toLowerCase());
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        //-------------------------------LLLENAR DATOS DE LAS TABLAS*-------------------
        for (String clasename : tablas) {

            List<TableData> detalle = new ArrayList<>();
            System.out.println("Se creo la clase " + clasename + " mapeando la tabla " + clasename);
            try {
                ResultSet rs = conectar.EjecutarSQL("EXEC USP_GET_DATA_TABLE '" + clasename+"'");
                while (rs.next()) {
                    //TableData tabledata = new TableData(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                    //detalle.add(new TableData(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
                	//detalle
                	TableData td = new TableData();
                	td.setField(rs.getString(4));
                	td.setType(rs.getString(8));
                	detalle.add(td);
                } 
                String atributos = new ORMMP().CrearAtributos(detalle);
                //String funciones = new ORMMP().CrearFunciones(detalle);
                new ORMMP().crearClases(new TableParts("com.millenniumprogrammers.neocomer.model", clasename, atributos + " \n " ));//+ funciones));

            } catch (SQLException e) {
                System.err.println(e.getMessage());
            } finally {
                datatablemayor.add(detalle);
            }
        }

        /*---------------comprobador-----------------*/
 /*int i = 0;
        while (i < tablas.size()) {
            System.out.println("-----\t" + tablas.get(i));
            /* System.out.println(datatablemayor.size());
            System.out.println(datatablemayor.get(0).get(0).getField());
            System.out.println("------------------");
            System.out.println(datatablemayor.get(1).get(0).getField());
        for (int j = 0; j < datatablemayor.get(i).size(); j++) {
            System.out.println("------------------------------");
            System.out.println("|" + datatablemayor.get(i).get(j).getField() + "| \t"
                    + datatablemayor.get(i).get(j).getType() + "| \t"
                    + datatablemayor.get(i).get(j).getNull() + "| \t"
                    + datatablemayor.get(i).get(j).getKey() + "| \t"
                    + datatablemayor.get(i).get(j).getDefault() + " | \t"
                    + datatablemayor.get(i).get(j).getExtra());
        }
        System.out.println("------------------------------");
        i++;
    }
    --------------------------------*/
 /*
        TableParts partes = new TableParts();
        FileWriter TableClass = null;
        //-------------------------------

        partes.setPackagename(
                "com.empresa.create.Beans");
        partes.setClassname(
                "");
        //-------------------------------
        PrintWriter pw = null;*/
    }

    public void crearClases(TableParts parts) {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            //fichero = new FileWriter("E:\\ServiceProver\\src\\java\\pe\\com\\proveer\\beans\\model\\" + parts.getClassname() + ".java");
            //fichero = new FileWriter("C:\\Users\\cesars\\Desktop\\clases\\" + parts.getClassname() + ".java");
            //fichero = new FileWriter("C:\\Users\\cesars\\git\\NeoComerController\\neocomer\\src\\main\\java\\com\\millenniumprogrammers\\neocomer\\model\\" + parts.getClassname() + ".java");
            fichero = new FileWriter("C:\\Users\\Administrador\\git\\NeoComerController\\neocomer\\src\\main\\java\\com\\millenniumprogrammers\\neocomer\\model\\"+ parts.getClassname() + ".java");
            
            
            
            pw = new PrintWriter(fichero);
            pw.print(""
                    + "package " + parts.getPackagename() + ";\n \n" 
                    +"import lombok.AllArgsConstructor;\n"
                    +"import lombok.Data;\n"
                    +"import lombok.NoArgsConstructor;\n \n" 
                    
                    + "@Data\n"
                    + "@AllArgsConstructor\n"
                    + "@NoArgsConstructor\n"
                    + "public class " + parts.getClassname() + "{\n"
                    + "    \n"
                    + parts.getAtributes()
                    + "}\n"
                    + "");
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

    public String CrearAtributos(List<TableData> tabledata) {
        String atributos = "";
        for (int i = 0; i < tabledata.size(); i++) {
            String TypeData = tabledata.get(i).getType();

            //atributos += "\t private " + comprobar(TypeData.substring(0, TypeData.contains("(") ? TypeData.indexOf("(") : TypeData.length())) + "  " + tabledata.get(i).getField() + "; \n \n";
            atributos += "\t private " + comprobar(TypeData)+" "+tabledata.get(i).getField()+";\n";
        }
        //atributos += "\t public void set";
        return atributos;
    }

    /*public String CrearFunciones(List<TableData> tabledata) {
        String funciones = "";
        for (int i = 0; i < tabledata.size(); i++) {
            String TypeData = tabledata.get(i).getType();
            funciones += "\t public void set" + tabledata.get(i).getField() + "("
                    + comprobar(TypeData.substring(0, TypeData.contains("(") ? TypeData.indexOf("(") : TypeData.length()))
                    + " " + tabledata.get(i).getField() + ")"
                    + "\n \t{"
                    + "this." + tabledata.get(i).getField() + " = "
                    + tabledata.get(i).getField()
                    + "; \n \t } \n";
            funciones += "\t public " + comprobar(TypeData.substring(0, TypeData.contains("(") ? TypeData.indexOf("(") : TypeData.length())) + " get" + tabledata.get(i).getField() + "( ) { "
                    + "\n"
                    + "\t return this." + tabledata.get(i).getField()
                    + "; \n}";
        }
        return funciones;
    }*/

    public String comprobar(String SqlData) {
        String respuesta = "Añada la condición por favor";
        switch (SqlData.toUpperCase()) {
            case "DATE":
            case "DATETIME":
            case "VARCHAR":
            case "NCHAR": 
                respuesta = "String";
                break;
            case "DOUBLE":
            case "DECIMAL":
                respuesta = "double";
                break;
            case "BIT":
                respuesta = "boolean";
                break;
            default:
                respuesta = SqlData;
                break;
        }
        return respuesta;
    }
    //String Tiposdedatos = {"INT","DOUBLE","DECIMAL"};
}
