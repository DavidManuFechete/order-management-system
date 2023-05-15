package ro.tuc.model;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class ClientTableModel extends AbstractTableModel {

    private List<Client> clientList = new ArrayList<>();
    @Override
    public int getRowCount() {
        return clientList.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Client atClient = (Client) clientList.toArray()[rowIndex];
        switch (columnIndex){
            case 0:
                return atClient.getId();
            case 1:
                return atClient.getName();
            case 2:
                return atClient.getAddress();
            case 3:
                return atClient.getEmail();
            case 4:
                return atClient.getAge();
        }
        return null;
    }

    public List<Client> getClientList() {
        return clientList;
    }

    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }
}
