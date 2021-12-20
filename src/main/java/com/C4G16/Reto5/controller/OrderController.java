/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.C4G16.Reto5.controller;

import com.C4G16.Reto5.model.Order;
import com.C4G16.Reto5.service.OrderService;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author edgarchaparro
 */
@RestController
@RequestMapping("/api/order")
@CrossOrigin("*")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/all")
    public List<Order> getAll() {
        return orderService.getAll();
    }

    @GetMapping("/{id}")
    public Optional <Order> getOrder(@PathVariable("id") Integer id) {
        return orderService.getOrder(id);
    }

    @GetMapping("/zona/{zone}")
    public List <Order> getOrder(@PathVariable("zone") String zone) {
        return orderService.getOrderZone(zone);
    }

    @GetMapping("salesman/{id}")
    public List<Order> getOrdersBySalesMan(@PathVariable("id") Integer id) {
        return orderService.getOrdersBySalesMan(id);
    }

    @GetMapping("state/{status}/{id}")
    public List<Order> getOrdersByStatusById(@PathVariable("status") String status, @PathVariable("id") Integer id) {
        return orderService.getOrdersByStatusById(status,id);
    }

    @GetMapping("date/{date}/{id}")
    public List<Order> getOrdersByRegisterDayById(@PathVariable("date") String date, @PathVariable("id") Integer id) throws ParseException {
        return orderService.getOrdersByRegisterDateById(date, id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Order save(@RequestBody Order order) {
        return orderService.save(order);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Order update(@RequestBody Order order) {
        return orderService.update(order);
    }
}
