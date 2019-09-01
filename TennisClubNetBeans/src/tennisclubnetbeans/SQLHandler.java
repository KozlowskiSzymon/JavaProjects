/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennisclubnetbeans;

import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Szymon
 */
public class SQLHandler {
    
    String showTableSQLDepartments = "select * from \"Placowki\" order by \"id_placowki\"";
    String showTableSQLWorkers = "select * from \"Pracownicy\" order by \"id_pracownika\"";
    String showTableSQLSchedule = "select * from \"Grafiki\" order by \"id_grafiku\"";
    String searchDepartmentsSQL;
    String searchWorkersSQL;
    String searchScheduleSQL;
    private int columnCount;
    public List<String> tempList;

    
    
    public List<List<String>> getWholeTable(Connection conn, String sql) throws SQLException{
        List<String> columnNames = new ArrayList<>();
        List<List<String>> resultList;
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        ResultSet result = preparedStatement.executeQuery(sql);
        ResultSetMetaData meta = result.getMetaData();
        columnCount = meta.getColumnCount();
        for(int  i = 1; i <= columnCount; i++){

               columnNames.add(meta.getColumnLabel(i));
              
        }
        tempList = new ArrayList<>(columnNames);
        resultList = DbUtils.resultSetToNestedList(result);
        return resultList;
    }
    
    public List<String> getColumnNames(){
        return tempList;
    }
    
    public void makeDepartmentsUpdateRequest(Connection conn, String[] data, List<String> columns) throws SQLException{
        
        String sql = "update \"Placowki\" set \"" + columns.get(0) + "\"="+ data[0] 
                                                  +", \""+columns.get(1)+"\"='"+data[1]
                                                  +"', \""+columns.get(2)+"\"='"+data[2]
                                                  +"', \""+columns.get(3)+"\"='"+data[3]
                                                  +"', \""+columns.get(4)+"\"='"+data[4]
                                                  +"', \""+columns.get(5)+"\"='"+data[5]
                                                  +"', \""+columns.get(6)+"\"='"+data[6]
                                                  +"', \""+columns.get(7)+"\"='"+data[7]
                                                  +"' where \""+columns.get(0)+"\"="+data[0];

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.executeUpdate();

    }
        public void makeWorkersUpdateRequest(Connection conn, String[] data, List<String> columns) throws SQLException{
        
        String sql = "update \"Pracownicy\" set \"" + columns.get(0) + "\"="+ data[0] 
                                                  +", \""+columns.get(1)+"\"='"+data[1]
                                                  +"', \""+columns.get(2)+"\"='"+data[2]
                                                  +"', \""+columns.get(3)+"\"='"+data[3]
                                                  +"', \""+columns.get(4)+"\"='"+data[4]
                                                  +"', \""+columns.get(5)+"\"='"+data[5]
                                                  +"', \""+columns.get(6)+"\"='"+data[6]
                                                  +"', \""+columns.get(7)+"\"='"+data[7]
                                                  +"', \""+columns.get(8)+"\"='"+data[8]
                                                  +"', \""+columns.get(9)+"\"='"+data[9]
                                                  +"', \""+columns.get(10)+"\"='"+data[10]
                                                  +"', \""+columns.get(11)+"\"='"+data[11]
                                                  +"', \""+columns.get(12)+"\"='"+data[12]
                                                  +"', \""+columns.get(13)+"\"='"+data[13].charAt(1)
                                                  +"', \""+columns.get(14)+"\"='"+data[14].charAt(1)
                                                  +"', \""+columns.get(15)+"\"='"+data[15]
                                                  +"' where \""+columns.get(0)+"\"="+data[0];

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.executeUpdate();

    }
    public void makeScheduleUpdateRequest(Connection conn, String[] data, List<String> columns) throws SQLException{
        
        String sql = "update \"Grafiki\" set \"" + columns.get(0) + "\"="+ data[0] 
                                                  +", \""+columns.get(1)+"\"='"+data[1]
                                                  +"', \""+columns.get(2)+"\"='"+data[2]
                                                  +"', \""+columns.get(3)+"\"='"+data[3]
                                                  +"', \""+columns.get(4)+"\"='"+data[4].charAt(1)
                                                  +"' where \""+columns.get(0)+"\"="+data[0];

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.executeUpdate();

    }
    
    public void makeClientUpdateRequest(Connection conn, String[] data, List<String> columns) throws SQLException{
        
        String sql = "update \"Klienci\" set \"" + columns.get(0) + "\"="+ data[0] 
                                                  +", \""+columns.get(1)+"\"='"+data[1]
                                                  +"', \""+columns.get(2)+"\"='"+data[2]
                                                  +"', \""+columns.get(3)+"\"='"+data[3]
                                                  +"', \""+columns.get(4)+"\"='"+data[4]
                                                  +"', \""+columns.get(5)+"\"='"+data[5]
                                                  +"', \""+columns.get(6)+"\"='"+data[6]
                                                  +"', \""+columns.get(7)+"\"='"+data[7]
                                                  +"', \""+columns.get(8)+"\"='"+data[8]
                                                  +"', \""+columns.get(9)+"\"='"+data[9]
                                                  +"', \""+columns.get(10)+"\"='"+data[10]
                                                  +"' where \""+columns.get(0)+"\"="+data[0];

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.executeUpdate();

    }
    
    public void makeDepartmentsAddRequest(Connection conn, String[] data) throws SQLException{
        String sql = "insert into \"Placowki\" values("+data[0]+
                                                    ",'"+data[1]+
                                                    "','"+data[2]+
                                                    "','"+data[3]+
                                                    "','"+data[4]+
                                                    "','"+data[5]+
                                                    "','"+data[6]+
                                                    "',"+data[7]+")";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.executeUpdate();
    }
    
    public void makeWorkersAddRequest(Connection conn, String[] data) throws SQLException{
        String sql = "insert into \"Pracownicy\" values("+data[0]+
                                                    ",'"+data[1]+
                                                    "','"+data[2]+
                                                    "','"+data[3]+
                                                    "','"+data[4]+
                                                    "','"+data[5]+
                                                    "','"+data[6]+
                                                    "','"+data[7]+
                                                    "','"+data[8]+
                                                    "','"+data[9]+
                                                    "','"+data[10]+
                                                    "','"+data[11]+
                                                    "','"+data[12]+
                                                    "',"+data[13].charAt(1)+
                                                    ","+data[14].charAt(1)+
                                                    ","+data[15]+")";
        System.out.println(sql);
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.executeUpdate();
    }
    public void makeScheduleAddRequest(Connection conn, String[] data) throws SQLException{
        String sql = "insert into \"Grafiki\" values("+data[0]+
                                                    ",'"+data[1]+
                                                    "','"+data[2]+
                                                    "','"+data[3]+
                                                    "',"+data[4].charAt(1)+")";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.executeUpdate();
    }
    
    public void makeDepartmentsRemoveRequest(Connection conn, int id) throws SQLException{
        String sql = "delete from \"Placowki\" where \"id_placowki\" = " + id;
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.executeUpdate();
    }
    
    public void makeWorkersRemoveRequest(Connection conn, int id) throws SQLException{
        String sql = "delete from \"Pracownicy\" where \"id_pracownika\" = " + id;
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.executeUpdate();
    }
        
    public void makeScheduleRemoveRequest(Connection conn, int id) throws SQLException{
        String sql = "delete from \"Grafiki\" where \"id_grafiku\" = " + id;
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.executeUpdate();
    }
    
    public void makeDepartmentsSearchRequest(Connection conn, String[] data, List<String> columns) throws SQLException{
        String[] temp = new String[7];
        
        if(data[0] != null)
            temp[0] = "\"" + columns.get(0) + "\" like '" + data[0] + "%'";
        else
            temp[0] = null;
        for(int i = 1; i < data.length; i++){
            if(data[i] != null)
                temp[i] = "and \"" + columns.get(i) + "\" like '" + data[i] + "%'";
            else
                temp[i] = null;
        }
        String sql = "select * from \"Placowki\" where "+temp[0]+temp[1]+temp[2]+temp[3]+temp[4]+temp[5]+temp[6]+"order by \"id_placowki\"";
        searchDepartmentsSQL = sql;
        System.out.println(sql);
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.executeUpdate();        
    }
    
    public void makeWorkersSearchRequest(Connection conn, String[] data, List<String> columns) throws SQLException{
        String[] temp = new String[13];
        
        if(data[0] != null)
            temp[0] = "\"" + columns.get(0) + "\" like '" + data[0] + "%'";
        else
            temp[0] = null;
        for(int i = 1; i < data.length; i++){
            if(data[i] != null)
                temp[i] = "and \"" + columns.get(i) + "\" like '" + data[i] + "%'";
            else
                temp[i] = null;
        }      
        String sql = "select * from \"Pracownicy\" where "+temp[0]+temp[1]+temp[2]+temp[3]+temp[4]+temp[5]+temp[6]+temp[7]+temp[8]+temp[9]+temp[10]+temp[11]+temp[12]+"order by \"id_pracownika\"";
        searchWorkersSQL = sql;
        System.out.println(sql);
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.executeUpdate();        
    }
        
    public void makeScheduleSearchRequest(Connection conn, String[] data, List<String> columns) throws SQLException{
        String[] temp = new String[5];
        
        if(data[0] != null)
            temp[0] = "\"" + columns.get(0) + "\" like '" + data[0] + "%'";
        else
            temp[0] = null;
        for(int i = 1; i < data.length; i++){
            if(data[i] != null)
                temp[i] = "and \"" + columns.get(i) + "\" like '" + data[i] + "%'";
            else
                temp[i] = null;
        }
        String sql = "select * from \"Grafiki\" where "+temp[0]+temp[1]+temp[2]+temp[3]+temp[4]+"order by \"id_grafiku\"";
        searchScheduleSQL = sql;
        System.out.println(sql);
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.executeUpdate();       
    }
    
}
