/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.C4G16.Reto5.service;

import com.C4G16.Reto5.model.Order;
import com.C4G16.Reto5.repository.OrderRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author edgarchaparro
 */
@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAll() {
        return orderRepository.getAll();
    }

    public Optional<Order> getOrder(Integer id) {
        return orderRepository.getOrder(id);
    }

    public List <Order> getOrderZone(String zone) {
        return orderRepository.getOrderZone(zone);
    }

    public Order save(Order order) {

        if (order.getId() == null) {
            Optional<Order> temporal = orderRepository.nextNumber();
            if (!temporal.isEmpty()) {
                order.setId(temporal.get().getId() + 1);
            } else {
                order.setId(1);
            }
        }
        return orderRepository.save(order);
    }

    public Order update(Order order) {

        Optional<Order> temporal = orderRepository.getOrder(order.getId());

        if (!temporal.isEmpty()) {
            if (order.getStatus() != null) {
                temporal.get().setStatus(order.getStatus());
            }
            return orderRepository.save(temporal.get());
            
        } else {
            return order;
        }
    }

    public List<Order> getOrdersBySalesMan(Integer id) {
        return orderRepository.getOrdersBySalesMan(id);
    }

    public List<Order> getOrdersByStatusById(String status, Integer id) {
        return orderRepository.getOrdersByStatusById(status, id);
    }

    public List<Order> getOrdersByRegisterDateById(String date, Integer id) throws ParseException {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date newdate = formatter.parse(date);
            return orderRepository.getOrdersByRegisterDayById(newdate, id);
        
    }

}
