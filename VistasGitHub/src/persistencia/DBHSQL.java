package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBHSQL {
	
	private static Connection dbcon;
    public static Connection getConexion(){
    	
        if (dbcon==null){
            try {
                Class.forName("org.hsqldb.jdbcDriver" );
                dbcon = DriverManager.getConnection("jdbc:hsqldb:hsqldb.core/bin/hsqldb/vistashsql", "sa", "");
                //dbcon = DriverManager.getConnection("jdbc:hsqldb:hsql//localhost/vistashsql", "sa", "");
                //dbcon = DriverManager.getConnection("jdbc:hsqldb:C:hsqldb.core/bin/hsqldb/vistashsql", "sa", "");
            }catch (Exception e) {
                System.out.println("ERROR: Fallo al conectar con HSQLDB JDBC driver.");
                e.printStackTrace();
            }
        }
        return dbcon;
    }
    
    public void endConexion(){
        if (dbcon!=null){
            try {
                dbcon.close();
            }catch (Exception e) {
                System.out.println("ERROR: Fallo al cerrar HSQLDB.");
                e.printStackTrace();
            }
        }
    } 

}
