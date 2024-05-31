/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package das.moh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import za.ac.tut.i.MemberInterface;

/**
 *
 * @author Judas
 */
public class MemberDB implements MemberInterface<Member>{
    
    private Connection connection;

    public MemberDB(String dbUrl,String username,String password) throws SQLException {
        connection = getConnection(dbUrl,username,password);
        
    }

    private Connection getConnection(String dbUrl, String username, String password) throws SQLException {
        Connection theConn = DriverManager.getConnection(dbUrl, username, password);
        return theConn;
        
    }

    @Override
    public boolean add(Member y) throws SQLException {
       String sql = "INSERT INTO MEMBERS(NAME,SURNAME,ID,GENDER,CONTRACT,TRAINER,TIME)"
               + "VALUES (?,?,?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, y.getName());
        ps.setString(2, y.getSurname());
        ps.setInt(3, y.getIdNum());
        ps.setString(4, y.getGender().toString());
        ps.setString(5, y.getContractType().toString());
        ps.setBoolean(6, y.getTrainer());
        ps.setTimestamp(7, Timestamp.from(Instant.now()));
        
        ps.executeUpdate();
        ps.close();
        return  true;
        
       
    }

    @Override
    public boolean update(Member y) throws SQLException {
        String sql = "UPDATE MEMBERS SET SURNAME =?,CONTRACT= ?,TRAINER = ?"
                + "WHERE ID = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        
        ps.setString(1, y.getSurname());
        ps.setString(2, y.getContractType().toString());
        ps.setBoolean(3, y.getTrainer());
        ps.setInt(4, y.getIdNum());
        
        ps.executeUpdate();
        ps.close();
        return true;
    }

    @Override
    public boolean delete(Integer id) throws SQLException {
        String sql = "DELETE FROM MEMBERS"
                + "WHERE ID = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        ps.close();
        
        return true;
    }

    @Override
    public List<Member> getAll() throws SQLException {
        String sql = "SELECT * FROM MEMBERS";
        List<Member> members = new ArrayList<>();
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        while(rs.next())
        {
             String name = rs.getString("NAME");
             String surname = rs.getString("SURNAME");
             int id = rs.getInt("ID");
             Character gender = rs.getString("GENDER").charAt(0);
             String contract = rs.getString("CONTRACT");
             Boolean trainer = rs.getBoolean("TRAINER");
             Timestamp ts = rs.getTimestamp("TIME");
             
             Member member = new Member(name, surname, id, gender, contract, trainer, ts);
             members.add(member);
        }
        return members;
    }

    @Override
    public Member get(Integer id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
