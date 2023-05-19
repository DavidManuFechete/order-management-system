package ro.tuc.bll;

import ro.tuc.bll.validators.Validator;
import ro.tuc.dao.BillDAO;
import ro.tuc.dao.ClientDAO;
import ro.tuc.dao.OrderDAO;
import ro.tuc.model.Bill;
import ro.tuc.model.Client;
import ro.tuc.model.Order;
import java.util.ArrayList;
import java.util.List;
/**
 * Business Logic Level class used for accessing the methods from the Data Access Layer in order to provide
 * an extra stage of checking data in the case of the bills class there are no validators needed. The class
 * doesn't get any parameters, and as attributes it has the DAO specific for the order, e.g. BillDAO
 */
public class BillBLL {

    private List<Validator<Bill>> validators;
    private static BillDAO billDAO = new BillDAO();

    public BillBLL(){
        validators = new ArrayList<Validator<Bill>>();
        billDAO = new BillDAO();
    }


    public static void insertBill (Bill bill){
        billDAO.insert(bill);
    }

    public static List<Bill> findAllBills(){
        return BillDAO.selectAllBills();
    }

}
