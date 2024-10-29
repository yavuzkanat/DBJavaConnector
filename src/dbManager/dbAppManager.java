package dbManager;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;



public class dbAppManager {
	static String dbUrl = "jdbc:mysql://localhost:3306/%s";
	static String dbName = "";
	static String dbUser= "";
	static String dbPass = "";
	static String dbTableName = "";
	public  void setdbTableName(String Table) {
		dbAppManager.dbTableName = Table;
	}
	public  void setDbName(String DBName) {
		dbAppManager.dbName =DBName;
	}
	public  void setDbPass(String Pass) {
		dbAppManager.dbPass = Pass;
	}

	public void setDbUserName(String dbUsername) {
		dbAppManager.dbUser = dbUsername;
	}
	
	public Boolean DBCheckConnected(){
		/** It connects to database and if it's return true  */
			try {
				
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection(String.format(dbUrl, dbName),dbUser,dbPass);
				con.close();
				return true;
				
				
				
				
			}catch (Exception e){
				return false;
			
			}
			
		
	}public ArrayList<String> DBColumnName(){
		ArrayList<String> ColumnName = new ArrayList<String>();
		ArrayList<String> ErrorMsg = new ArrayList<String>();

		
		try {
			Connection GetAll = DriverManager.getConnection(String.format(dbUrl, dbName),dbUser,dbPass);
			Statement state = GetAll.createStatement();
			ResultSet result = state.executeQuery("SELECT * FROM "+dbTableName);
			if(result.next()) {
				ResultSetMetaData MetaData = result.getMetaData();
				int Count = MetaData.getColumnCount();
				for(int i = 1;i<=Count;i++) {
					ColumnName.add(MetaData.getColumnName(i));
				}
			}
			GetAll.close();
			return ColumnName;
			
			
		}catch(Exception e){
			ErrorMsg.add(e.getMessage());
			return ErrorMsg;
			
			
		}
		
		
		
		
		
	}
	public ArrayList<String> DBGetAllData() {
		ArrayList<String> AllData = new ArrayList<String>();
		ArrayList<String> ErrorMsg = new ArrayList<String>();
		
		
		try {
			Connection GetAll = DriverManager.getConnection(String.format(dbUrl, dbName),dbUser,dbPass);
			Statement state = GetAll.createStatement();
			ResultSet result = state.executeQuery("SELECT * FROM "+dbTableName);
			if(result.next()) {
				ResultSetMetaData MetaData = result.getMetaData();
				int Count = MetaData.getColumnCount();
				for(int i = 1;i<=Count;i++) {
					AllData.add(result.getString(i));
				}
			}
			GetAll.close();
			return AllData;
			
			
		}catch(Exception e){
			ErrorMsg.add(e.getMessage());
			return ErrorMsg;
			
		}
		
		
	}
	   
}
