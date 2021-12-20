/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.C4G16.Reto5.repository;

import com.C4G16.Reto5.interfaces.OrderInterface;
import com.C4G16.Reto5.model.Order;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author edgarchaparro
 */
@Repository
public class OrderRepository {
    @Autowired
    private OrderInterface crud;
        
    public List<Order> getAll(){
        return crud.findAll();
    }
    
    public Optional<Order> getOrder(Integer id){
        return crud.findById(id);
    }

   public List <Order> getOrderZone(String zone){
       return crud.findBySalesManZone(zone);
   }
    
    public Order save(Order order){
        return crud.save(order);
    }
    
    public Optional<Order> nextNumber() {
        return crud.findTopByOrderByIdDesc();
    }

    public List<Order> getOrdersBySalesMan(Integer id) {
        return crud.findBySalesManId(id);
    }

    public List<Order> getOrdersByStatusById(String status, Integer id) {
        return crud.findByStatusAndSalesManId(status, id);
    }

    public List<Order> getOrdersByRegisterDayById(Date date, Integer id) {
            List<Order> lista = crud.findByRegisterDayAndSalesManId(date, id);
        return lista;
    }
}
