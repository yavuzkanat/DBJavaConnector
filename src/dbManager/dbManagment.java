package dbManager;


import java.util.Scanner;

public class dbManagment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		System.out.println("Hello user !");
		Scanner userAns = new Scanner(System.in);
		System.out.print("Enter MYSQL username : ");
		String UserName = userAns.nextLine();
		System.out.println();
		System.out.print("Enter MYSQL password :");
		String Password = userAns.nextLine();
		System.out.println();
		System.out.print("Enter MYSQL database name :");
		String DatabaseName = userAns.nextLine();
		System.out.println();
		System.out.print("Enter MYSQL Table name :");
		String TableName = userAns.nextLine();
		System.out.println();
		userAns.close();
		dbAppManager app = new dbAppManager();
		app.setDbUserName(UserName);
		app.setDbPass(Password);
		app.setDbName(DatabaseName);
		app.setdbTableName(TableName);
		
		System.out.println("Loging...");
		
		if(app.DBCheckConnected()) {
			
			System.out.println("Connected.");
		}else {
			System.out.println("Error Accured.");
		}
		
		
			String TableHeader  = " %s |  %s ";
			
			System.out.println("------------------"+ String.format(TableHeader,DatabaseName,TableName) +"--------------------");
			System.out.println("----------------------------------------------------------------------");
			for(String Cat:app.DBColumnName()) {
				System.out.print(Cat+"                ");
				
			
			}
			System.out.println("");
			System.out.println("---------------------------------------------------------------------");
			for(String tab:app.DBGetAllData()) {
				System.out.print(tab.replaceAll(" ", "")+"                 ");
				
			}
			System.out.println();
			System.out.println("----------------------------------------------------------------------");
			 
			
			;
			
		
	}
}
