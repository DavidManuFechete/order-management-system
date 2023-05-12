package ro.tuc;
import ro.tuc.connection.ConnectionFactory;

import java.sql.Connection;

public class App {
    public static void main( String[] args ) {

        try{
            Connection connection = ConnectionFactory.getConnection();
            System.out.println("Succesfully connected");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
