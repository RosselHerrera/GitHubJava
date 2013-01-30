package persistencia;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dto.DTOBackLog;

public class HelperHSQL {
	
	/**
	 * Helper para crear tabla ("CREATE TABLE")
	 * 
	 * @author Lozoronca
	 * @param sSQL
	 * @param sTable
	 * @return Complitud
	 * @throws SQLException
	 */
	public int HelperCreateTable(String sSQL, String sTable) throws SQLException {
		int ret = 0;
		Connection dbcon = null;
		try {
		    /*-------------------------------------*/
		    Class.forName("org.hsqldb.jdbcDriver" );
            dbcon = DriverManager.getConnection("jdbc:hsqldb:hsqldb.core/bin/hsqldb/" + sTable, "sa", "");
            /*-------------------------------------*/
            Statement stmt = dbcon.createStatement();
            //Borramos la tabla de prueba que utilizaremos
            try{ stmt.executeQuery("DROP TABLE " + sTable); }
            catch(java.sql.SQLException e){}
            //Creamos una tabla < nombreTabla >
            stmt.executeQuery(sSQL);
            stmt.close();
            ret = 1;
		} catch (Exception e) {
			 System.out.println("ERROR: Fallo al conectar con HSQLDB JDBC driver.");
			e.printStackTrace();
		} finally{
			if (dbcon != null) dbcon.close();
		}    
		return ret;
	}
	
	/**
	 * Obtención del total de registros persistentes
	 * @author Lozoronca
	 * @param sTable
	 * @return
	 */
	public int HelperIdentidad (String sTable){
		Connection dbhsql = null;
		ResultSet Ret;
		int ret = 0;
		try{
			final String sql ="select COUNT(*) from " + sTable;
			Class.forName("org.hsqldb.jdbcDriver" );
			dbhsql = DriverManager.getConnection("jdbc:hsqldb:hsqldb.core/bin/hsqldb/" + sTable, "sa", "");
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
	
	/**
	 * @author Lozoronca
	 * @param sTable
	 * @param vSQL
	 * @return
	 * @throws SQLException
	 */
	public int HelperInsertaHSQL (String sTable, String vSQL) throws SQLException {
		int Ret = 0;
		Connection dbcon = null;	
		try {			
			Class.forName("org.hsqldb.jdbcDriver" );
			dbcon = DriverManager.getConnection ("jdbc:hsqldb:hsqldb.core/bin/hsqldb/" + sTable, "sa", "");
			Statement stmt = dbcon.createStatement();
			stmt.executeQuery(vSQL);
			stmt.close();
			Ret = 1;
		} catch (Exception e) {
			 System.out.println("ERROR: Fallo al conectar con HSQLDB JDBC driver.");
			e.printStackTrace();
			Ret = 0;
		} finally{
			if (dbcon != null) dbcon.close();
		}
		return Ret;
	}
	
	/**
	 * @author Lozoronca
	 * @param sTable
	 * @param vSQL
	 * @return
	 * @throws SQLException
	 */
	public int HelperUpdateHSQL (String sTable, String vSQL) throws SQLException {
		int Ret = 0;
		Connection dbcon = null;	
		try {			
			Class.forName("org.hsqldb.jdbcDriver" );
			dbcon = DriverManager.getConnection ("jdbc:hsqldb:hsqldb.core/bin/hsqldb/" + sTable, "sa", "");
			Statement stmt = dbcon.createStatement();
			stmt.executeUpdate(vSQL);
			stmt.close();
			Ret = 1;
		} catch (Exception e) {
			 System.out.println("ERROR: Fallo al conectar con HSQLDB JDBC driver.");
			e.printStackTrace();
			Ret = 0;
		} finally{
			if (dbcon != null) dbcon.close();
		}
		return Ret;
	}
	
	/**
	 * @author Lozoronca
	 * @return
	 * @throws SQLException
	 * @throws IOException
	 */
	public ArrayList<DTOBackLog> HelperListaBackLogs()  throws SQLException, IOException {
		Connection dbcon = null;	
		ResultSet resultado = null;
		DTOBackLog backlog;
			/* ---------------------------------------------------------------- */
			ArrayList<DTOBackLog> listadoBackLogs = new ArrayList<DTOBackLog>();	
			/* ---------------------------------------------------------------- */
			try {
			    /*-------------------------------------*/
			    Class.forName("org.hsqldb.jdbcDriver" );							   //VISTASHSQL20 AGILHSQL26
			    dbcon = DriverManager.getConnection ("jdbc:hsqldb:hsqldb.core/bin/hsqldb/VISTASMED", "sa", "");
	            /*-------------------------------------*/
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
	            pStmt.close();          //liberamos recursos
		        
			} catch (Exception e) {
				 System.out.println("ERROR: Fallo al conectar con HSQLDB JDBC driver.");
				e.printStackTrace();
			} finally{
				if (dbcon != null) dbcon.close();
			}
			return listadoBackLogs;
	    }

	
	
}
