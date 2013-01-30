package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ClassTestUpdate {
	
	private static Connection dbcon;
    public static Connection getConexion(){

        if (dbcon==null){
            try {
                Class.forName("org.hsqldb.jdbcDriver" );
                dbcon = DriverManager.getConnection("jdbc:hsqldb:hsqldb.core/bin/hsqldb/vistashsql15", "sa", "");
               /* dbcon = DriverManager.getConnection("jdbc:hsqldb:mem:vistashsql", "sa", "");*/
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

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/* -------------------------------------------------------------------------------- */
		 String SQL = "UPDATE VISTASHSQL SET ACTIVIDAD ='KANBAN :: AgilDay2012' WHERE ID = 2";
		 try{
	            Statement stmt = Conector.getConexion().createStatement();
	            // Realizamos una modificación de un registro
	                     stmt.executeUpdate(SQL);
	    /* -------------------------------------------------------------------------------- */                  
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
	     /* -------------------------------------------------------------------------------- */
              }catch(Exception e){
                  System.out.println("ERROR: Fallo al recoger datos de la bbdd.");
                  e.printStackTrace();
              }
	}

}
