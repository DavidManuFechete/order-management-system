package ro.tuc.dao;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import ro.tuc.connection.ConnectionFactory;
import ro.tuc.presentation.ClientsView;
import ro.tuc.presentation.Controller;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * Javadoc for AbstractDAO [...]
 * @param <T>
 */
public class AbstractDAO<T> {
    protected static final Logger LOGGER = Logger.getLogger(AbstractDAO.class.getName());
    private final static int INVALID_VALUE = 99999;

    private final Class<T> type;
    @SuppressWarnings("unchecked")
    public AbstractDAO() {
        this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    private String createSelectQuery(String field) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append(" * ");
        sb.append(" FROM orders_management.");
        sb.append(type.getSimpleName().toLowerCase());
        sb.append(" WHERE " + field + " =?");
        return sb.toString();
    }

    public List<T> findAll() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT ").append(" * ").append(" FROM ").append(type.getSimpleName());
        String query = stringBuilder.toString();
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
        }
        catch (SQLException e){
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findAll " + e.getMessage());
        }
        return null;
    }

    public T findById(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createSelectQuery("id");
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            return createObjects(resultSet).get(0);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    private List<T> createObjects(ResultSet resultSet) {
        List<T> list = new ArrayList<T>();
        Constructor[] ctors = type.getDeclaredConstructors();
        Constructor ctor = null;
        for (int i = 0; i < ctors.length; i++) {
            ctor = ctors[i];
            if (ctor.getGenericParameterTypes().length == 0)
                break;
        }
        try {
            while (resultSet.next()) {
                ctor.setAccessible(true);
                T instance = (T)ctor.newInstance();
                for (Field field : type.getDeclaredFields()) {
                    String fieldName = field.getName();
                    Object value = resultSet.getObject(fieldName);
                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName, type);
                    Method method = propertyDescriptor.getWriteMethod();
                    method.invoke(instance, value);
                }
                list.add(instance);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        return list;
    }

    public JTable generateTable(List<T> list){

        DefaultTableModel model = new DefaultTableModel();
        Field[] fields = list.get(0).getClass().getDeclaredFields();
        ArrayList<String> columns = new ArrayList<String>();
        for (Field field : fields){
            field.setAccessible(true);
            columns.add(field.getName());
        }
        for (String columnName : columns){
            model.addColumn(columnName);
        }
        for (T element : list){
            ArrayList<Object> objects = new ArrayList<>();
            Field[] elementField = element.getClass().getDeclaredFields();
            for (Field field : elementField){
                field.setAccessible(true);
                try{
                    objects.add(field.get(element));
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
            model.addRow(objects.toArray());
        }
        JTable table = new JTable(model);
        return table;
    }

    public T insert(T t) {

        Connection connection = null;
        PreparedStatement statement = null;
        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("INSERT INTO orders_management.").append(type.getSimpleName().toLowerCase());
        queryBuilder.append(" VALUES(");// insert into orders_management.type VALUES(ceva, ceva, ceva, ceva, ..)
        for (Field field : t.getClass().getDeclaredFields()){
            field.setAccessible(true);
            Object value;
            try{
                value = field.get(t);
                if(value.getClass().getSimpleName().equals("String")){
                    queryBuilder.append("'").append(value).append("',");
                }
                else{
                    queryBuilder.append(value).append(",");
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        if (queryBuilder.charAt(queryBuilder.length() - 1) == ','){
            queryBuilder.deleteCharAt(queryBuilder.length() - 1);
            queryBuilder.append(")");
        }
        String query = queryBuilder.toString();
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.execute(query);
            connection.close();
            statement.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return t;
    }

    public T delete(T t){

        Connection connection = null;
        PreparedStatement statement = null;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DELETE FROM orders_management.").append(type.getSimpleName().toLowerCase()).append(" WHERE id = ");
        try{
            connection = ConnectionFactory.getConnection();
            Field[] fields = t.getClass().getDeclaredFields();
            fields[0].setAccessible(true);
            stringBuilder.append(fields[0].get(t));
            String query = stringBuilder.toString();
            statement = connection.prepareStatement(query);
            statement.execute(query);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        ConnectionFactory.close(statement);
        ConnectionFactory.close(connection);
        return t;
    }
    public T update(T t) {

        Connection connection = null;
        PreparedStatement statement = null;
        StringBuilder queryBuilder = new StringBuilder();
        Object value = null;
        boolean first = true;
        int id = INVALID_VALUE;
        queryBuilder.append("UPDATE orders_management.").append(type.getSimpleName().toLowerCase());
        // UPDATE orders_management.client
        try{
            Field[] fields = t.getClass().getDeclaredFields();
            fields[0].setAccessible(true);
            value = fields[0].get(t); // value o sa fie id u pe care vrem sa l editam
        }
        catch(Exception e){
            e.printStackTrace();
        }
        queryBuilder.append(" SET ");
        for (Field field : t.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                if (first) {
                    first = false;
                    id = (int) field.get(t);
                } else {
                    queryBuilder.append(field.getName().toLowerCase()).append(" = ");
                    if (field.getType().getSimpleName().equals("String")) {
                        queryBuilder.append("'").append(field.get(t)).append("',");
                    } else {
                        queryBuilder.append(field.get(t)).append(",");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (id == INVALID_VALUE) {
                System.out.println("Invalid");
                return null;
            }
        }
        queryBuilder.deleteCharAt(queryBuilder.length() - 1);
        queryBuilder.append(" WHERE id = ").append(id);
        String query = queryBuilder.toString();
        System.out.println(query);
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.execute(query);
            connection.close();
            statement.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return t;
    }
}