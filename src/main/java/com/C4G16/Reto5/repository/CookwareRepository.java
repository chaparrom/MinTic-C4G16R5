/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.C4G16.Reto5.repository;

import com.C4G16.Reto5.interfaces.CookwareInterface;
import com.C4G16.Reto5.model.Cookware;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author edgarchaparro
 */
@Repository
public class CookwareRepository {
    
    @Autowired
    private CookwareInterface crud;
        
    public List<Cookware> getAll(){
        return crud.findAll();
    }
    
    public Optional<Cookware> getCookware(String reference){
        return crud.findByReference(reference);
    }
    
    public List<Cookware> getCookwareByPrice(double price) {
        return crud.findByPrice(price);
    }
    
    public List<Cookware> getCookwareByDescription(String description) {
        return crud.findByDescriptionContainingIgnoreCase(description);
    }
    
    public Cookware save(Cookware cookware){
        return crud.save(cookware);
    }
    
    public void delete(Cookware cookware){
        crud.delete(cookware);
    }
}
