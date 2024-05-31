/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.i;


import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Judas
 * @param <Y>
 */
public interface MemberInterface<Y>{
     boolean add(Y y) throws SQLException;
     boolean update(Y y) throws SQLException;
     boolean delete(Integer id) throws SQLException;
     List<Y> getAll() throws SQLException;
     Y get(Integer id) throws SQLException;
    
    
    
    
    
}
