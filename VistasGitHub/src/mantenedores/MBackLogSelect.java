package mantenedores;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import persistencia.DBHSQL;
import test.Conector;
import dto.DTOBackLog;

public class MBackLogSelect  {
	
	public int LimpiaBackLog()throws SQLException {
		Connection dbcon = null;	
		ResultSet resultado = null;
		int ret = 0;
		try {
		    /*-------------------------------------*/
		    Class.forName("org.hsqldb.jdbcDriver" );
            /*dbcon = DriverManager.getConnection("jdbc:hsqldb:hsqldb.core/bin/hsqldb/vistashsql", "sa", "");*/
		    dbcon = DriverManager.getConnection("jdbc:hsqldb:hsqldb.core/bin/hsqldb/vistashsql", "sa", "");
            /*-------------------------------------*/
            Statement stmt = dbcon.createStatement();
            //Borramos la tabla de prueba que utilizaremos
            try{ 
            	stmt.executeQuery("DELETE FROM VISTASHSQL"); 
            	ret = 1;
            } catch(java.sql.SQLException e){}
		} catch (Exception e) {
			 System.out.println("ERROR: Fallo al conectar con HSQLDB JDBC driver.");
			e.printStackTrace();
		} finally{
			if (dbcon != null) dbcon.close();
		}  
		return ret;          	
	}
	
	/**
	 * 
	 */
	public ArrayList<DTOBackLog> ListaBackLogs()  throws SQLException, IOException {
	Connection dbcon = null;	
	ResultSet resultado = null;
	DTOBackLog backlog;

		/* ---------------------------------------------------------------- */
		ArrayList<DTOBackLog> listadoBackLogs = new ArrayList<DTOBackLog>();	
		/* ---------------------------------------------------------------- */
		try {
		    /*-------------------------------------*/
		    Class.forName("org.hsqldb.jdbcDriver" );
            /*dbcon = DriverManager.getConnection("jdbc:hsqldb:hsqldb.core/bin/hsqldb/VISTASHSQL20", "sa", "");*/
           /* dbcon = DriverManager.getConnection("jdbc:hsqldb:hsqldb.core/bin/hsqldb/AGILHSQL26", "sa", "");*/
            dbcon = DriverManager.getConnection("jdbc:hsqldb:hsqldb.core/bin/hsqldb/VISTASMED", "sa", "");
            /*-------------------------------------*/
            Statement stmt = dbcon.createStatement();
            //Borramos la tabla de prueba que utilizaremos
           /* try{ stmt.executeQuery("DROP TABLE AGILHSQL26"); }
            catch(java.sql.SQLException e){}*/
            //Creamos una tabla < nombreTabla >
           /*stmt.executeQuery("CREATE TABLE VISTASMED (ID BIGINT PRIMARY KEY, "+
                                                "ACTIVIDAD VARCHAR(255), " +
            		                            "DET1 VARCHAR(255), " +
                                                "DET2 VARCHAR(255), "+
                                                "DET3 VARCHAR(255), " +
                                               "FECHA VARCHAR(255))");*/
           
            
           /* stmt.close();*/
            
            //Insertamos los registros
            /*stmt.executeQuery("INSERT INTO AGILHSQL26 (ID,ACTIVIDAD,DET1,DET2,DET3,FECHA) " + "VALUES (1,'AGILDAY','Activity','CORESYS:8080','#AB2777','26-11-2012')");*/
           
            /* stmt.executeQuery("INSERT INTO VISTASHSQL20 (ID,ACTIVIDAD,DET1,DET2,DET3,FECHA) " + "VALUES (2,'AB2777','F(x). Activity','G(x) Activity','#deac2f','14-11-2012')");
            stmt.executeQuery("INSERT INTO VISTASHSQL20 (ID,ACTIVIDAD,DET1,DET2,DET3,FECHA) " + "VALUES (3,'DELETE','Implementacion','MBackLogSelect','#0FFF00','14-11-2012')");
            stmt.executeQuery("INSERT INTO VISTASHSQL20 (ID,ACTIVIDAD,DET1,DET2,DET3,FECHA) " + "VALUES (4,'UPDATE','Implementacion','MBackLogSelect','#fff000','14-11-2012')");
            stmt.executeQuery("INSERT INTO VISTASHSQL20 (ID,ACTIVIDAD,DET1,DET2,DET3,FECHA) " + "VALUES (5,'CIISA 17:00','COLLECTIONS','ARRAYLIST','#56c4e8','15-11-2012')");
            stmt.executeQuery("INSERT INTO VISTASHSQL20 (ID,ACTIVIDAD,DET1,DET2,DET3,FECHA) " + "VALUES (6,'43568-HUNGRIA','Token Cruce Producto','WS Visualizacion','#56c4e8','14-11-2012')");
            stmt.executeQuery("INSERT INTO VISTASHSQL20 (ID,ACTIVIDAD,DET1,DET2,DET3,FECHA) " + "VALUES (7,'TF','Focus Manager','SWING','#F0FF00','14-11-2012')");
            stmt.executeQuery("INSERT INTO VISTASHSQL20 (ID,ACTIVIDAD,DET1,DET2,DET3,FECHA) " + "VALUES (8,'KANBAN','http://localhost:8080/Vistas','PosIT INGRESO','#56c4e8','14-11-2012')");
            stmt.executeQuery("INSERT INTO VISTASHSQL20 (ID,ACTIVIDAD,DET1,DET2,DET3,FECHA) " + "VALUES (9,'AB2777','ANALISIS D.M,','AHBKX015','#e9e74a','14-11-2012')");
            stmt.executeQuery("INSERT INTO VISTASHSQL20 (ID,ACTIVIDAD,DET1,DET2,DET3,FECHA) " + "VALUES (10,'AB2777','proxy.altec.bsch','localhost:8080','#56c4e8','14-11-2012')");
            stmt.executeQuery("INSERT INTO VISTASHSQL20 (ID,ACTIVIDAD,DET1,DET2,DET3,FECHA) " + "VALUES (11,'KANBAN','CROME ','	NO-PROXI','#56c4e8','14-11-2012')");
            stmt.executeQuery("INSERT INTO VISTASHSQL20 (ID,ACTIVIDAD,DET1,DET2,DET3,FECHA) " + "VALUES (12,'CIISA 17:00','Fundamentos OO','JAVA','#fff000','15-11-2012')");
            stmt.executeQuery("INSERT INTO VISTASHSQL20 (ID,ACTIVIDAD,DET1,DET2,DET3,FECHA) " + "VALUES (13,'AB2777','F(x). Activity','G(x) Activity','#AB2777','14-11-2012')");
            */

            // ********************************************************************** *************************************
            /*String SQL = "UPDATE VISTASHSQL15 SET (ACTIVIDAD ='ACTUALIZACION TF', DET1 ='Swing Focus Manager', DET2 ='Modo Manual') WHERE ID = 16";*/
            /*String SQL = "DELETE FROM VISTASHSQL15 WHERE ID = 14";*/
            // ******************************************************************* ****************************************
            //stmt.executeUpdate(SQL);
            // ******************************************************************* ****************************************
		    final String sql = "select ID, ACTIVIDAD, DET1, DET2, DET3, FECHA from VISTASMED ORDER BY ID desc";
		    PreparedStatement pStmt =  dbcon.prepareStatement(sql);  
			
	        //Obtenemos los registros de la BBDD para mostrarlos
			resultado = pStmt.executeQuery();
			
	        while (resultado.next()) {
	        	/* --------------------- */
	        	backlog = new DTOBackLog();
	        	/* --------------------- */
	        	backlog.setID(resultado.getInt(1));
	        	backlog.setActividad(resultado.getString(2));
	        	backlog.setDetalle1(resultado.getString(3));
	        	backlog.setDetalle2(resultado.getString(4));
	        	backlog.setDetalle3(resultado.getString(5));
	        	backlog.setFecha(resultado.getString(6));
	        	/* --------------------- */
	        	listadoBackLogs.add(backlog);
	        	/* --------------------- */
		    }
	        resultado.close();      //liberamos resultados
            pStmt.close();           //liberamos recursos
	        
		} catch (Exception e) {
			 System.out.println("ERROR: Fallo al conectar con HSQLDB JDBC driver.");
			e.printStackTrace();
		} finally{
			if (dbcon != null) dbcon.close();
		}
	    
		return listadoBackLogs;
    }
	
	public int identidad (){
		Connection dbhsql = null;
		ResultSet Ret;
		int ret = 0;
		try{
			final String sql ="select COUNT(*) from VISTASMED";
			/*dbhsql = new DBHSQL().getConexion();*/
			Class.forName("org.hsqldb.jdbcDriver" );
			dbhsql = DriverManager.getConnection("jdbc:hsqldb:hsqldb.core/bin/hsqldb/VISTASMED", "sa", "");
			PreparedStatement pStmt = dbhsql.prepareStatement(sql);
			Ret = pStmt.executeQuery();
			if(Ret.next()){
			  ret = Ret.getInt(1);
			} else {
			  ret = 0;	
			}
			Ret.close();
			pStmt.close();
		} catch (Exception e){
			System.out.println("ERROR: Fallo COUNT(*)");
			e.printStackTrace();
		}
		return ret;
	}
	
	public int GrabaBackLog (int id, String actividad, String detalle1, String detalle2, String detalle3, String fecha)  throws SQLException {
		Connection dbhsql = null;	
		ResultSet resultado = null;
		id = id +1;
		
		String Fecha = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		String Hora  = new SimpleDateFormat("h:mm a").format(new Date());
		
		try {
		    /*dbhsql = new DBHSQL().getConexion();*/
			Class.forName("org.hsqldb.jdbcDriver" );
			dbhsql = DriverManager.getConnection("jdbc:hsqldb:hsqldb.core/bin/hsqldb/VISTASMED", "sa", "");
		    Statement stmt = dbhsql.createStatement();
		    stmt.executeQuery("INSERT INTO VISTASMED (ID,ACTIVIDAD,DET1,DET2,DET3,FECHA) " + 
		    				  "VALUES (" + id + ", '" + 
		    				  					actividad + "', '" + 
		    				  						detalle1 + "', ' " + 
		    				  							detalle2 + "','" + 
		    				  								detalle3 + "', '" + 
		    				  									fecha + " " + Hora + "')");
            stmt.close();
            return 1;
		    
		} catch (Exception e) {
			 System.out.println("ERROR: Fallo al conectar con HSQLDB JDBC driver.");
			e.printStackTrace();
			return 0;
		} finally{
			if (dbhsql != null) dbhsql.close();
		}
		
	}
	
	
}


