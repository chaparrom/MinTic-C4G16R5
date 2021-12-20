/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.C4G16.Reto5.interfaces;

import com.C4G16.Reto5.model.Order;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author edgarchaparro
 */
public interface OrderInterface extends MongoRepository<Order, Integer> {
    
        Optional<Order> findTopByOrderByIdDesc();
        List<Order> findBySalesManZone(String zone);
        List<Order> findBySalesManId(Integer id);
//        Query("{'status':?0, 'salesMan.id:?1}")
        List<Order> findByStatusAndSalesManId(String status, Integer id); 
//        @Query("{'registerDay': ?0, 'salesMan.id: ?1}") 
        List<Order> findByRegisterDayAndSalesManId(Date date, Integer id);        
    
}
