package ro.tuc.presentation;

import ro.tuc.model.Bill;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *  Class used for creating the bill text field. For each bill it creates a unique bill which contains in its title the
 *  bill time of creation and inside the bill various information about the bill like the name of the buyer, the product
 *  bought and the amount of that product.
 */
public class BillMaker {
    private String billName;

    public BillMaker(){

    }
    public void createBill(){
        Date currentDate = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HHmmss-MMddyyyy");
        String timestamp = simpleDateFormat.format(currentDate);
        billName = "Bill-" + timestamp + ".txt";
        File logOfEvents = new File(billName);
        try{
            logOfEvents.createNewFile();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public void writeBill(Bill bill){
        try{
            FileWriter logWriter = new FileWriter(billName,true);
            logWriter.write(bill.toString());
            logWriter.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
