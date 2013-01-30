package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conector {
	
	private static Connection dbcon;
    public static Connection getConexion(){

        if (dbcon==null){
            try {
                Class.forName("org.hsqldb.jdbcDriver" );
                dbcon = DriverManager.getConnection("jdbc:hsqldb:hsqldb.core/bin/hsqldb/vistashsql", "sa", "");
                //dbcon = DriverManager.getConnection("jdbc:hsqldb:hsql//localhost/vistashsql", "sa", "");
                //dbcon = DriverManager.getConnection("jdbc:hsqldb:C:hsqldb.core/bin/hsqldb/vistashsql", "sa", "");
                //dbcon = DriverManager.getConnection("jdbc:hsqldb:mem:vistashsql", "sa", "");
            }catch (Exception e) {
                System.out.println("ERROR: Fallo al conectar con HSQLDB JDBC driver.");
                e.printStackTrace();
            }
        }
        return dbcon;
    }

    public static void endConexion(){
        if (dbcon!=null){
            try {
                dbcon.close();
            }catch (Exception e) {
                System.out.println("ERROR: Fallo al cerrar HSQLDB.");
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        //creo un statement de la conexión
        try{
            Statement stmt = Conector.getConexion().createStatement();
            //Borramos la tabla de prueba que utilizaremos
            try{stmt.executeQuery("DROP TABLE VISTASHSQL");}
            catch(java.sql.SQLException e){}

            //Creamos una tabla TEPUALHSQL CON COLUMNAS ID, NOMBRE, APELLIDO, EDAD
            stmt.executeQuery("CREATE TABLE VISTASHSQL (ID BIGINT PRIMARY KEY, "+
                                                "ACTIVIDAD VARCHAR(255), " +
            		                            "DET1 VARCHAR(255), " +
                                                "DET2 VARCHAR(255), "+
                                                "DET3 VARCHAR(255), " +
                                                "FECHA VARCHAR(255))");

            //Insertamos dos registros
            stmt.executeQuery("INSERT INTO VISTASHSQL (ID,ACTIVIDAD,DET1,DET2,DET3,FECHA) "+
                               "VALUES (1,'CRITERIO : AgilDay2012','CRITERIO ACEPTACION', 'br', 'br','2012-11-07')");
            stmt.executeQuery("INSERT INTO VISTASHSQL (ID,ACTIVIDAD,DET1,DET2,DET3,FECHA) "+
            		           "VALUES (2,'CRITERIO : AgilDay2012','CRITERIO ACEPTACION', 'br', 'br','2012-11-07')");
            stmt.executeQuery("INSERT INTO VISTASHSQL (ID,ACTIVIDAD,DET1,DET2,DET3,FECHA) "+
            		           "VALUES (3,'CRITERIO : AgilDay2012','CRITERIO ACEPTACION', 'br', 'br','2012-11-07')");
            // Realizamos una modificación de un registro
            stmt.executeUpdate("UPDATE VISTASHSQL SET ACTIVIDAD='KANBAN' WHERE ID=2");

            //Obtenemos los registros de la BBDD para mostrarlos por consola
            ResultSet resultado = stmt.executeQuery("select * from VISTASHSQL");
            while (resultado.next()){
                System.out.println(resultado.getInt("ID")+ " , " +
                			   " " +resultado.getString("ACTIVIDAD")+ " , " +
                               " " +resultado.getString("DET1")+ " , "+
                               " " +resultado.getString("DET2")+ " , "+
                               " " +resultado.getString("DET3")+ " , "+
                                    resultado.getString("FECHA"));

            }
            resultado.close();//liberamos resultados

            stmt.close();//liberamos recursos

            Conector.endConexion();//cerramos conexión

        }catch(Exception e){
            System.out.println("ERROR: Fallo al recoger datos de la bbdd.");
            e.printStackTrace();
        }

    }

}
