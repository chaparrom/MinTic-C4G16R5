/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.C4G16.Reto5.service;

import com.C4G16.Reto5.model.Cookware;
import com.C4G16.Reto5.repository.CookwareRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author edgarchaparro
 */
@Service
public class CookwareService {
        
    @Autowired
    private CookwareRepository cookwareRepository;
    public List<Cookware> getAll(){
        return cookwareRepository.getAll();
    }

    public Optional<Cookware> getCookware(String reference){
        return cookwareRepository.getCookware(reference);
    }
    
    public List<Cookware> getCookwareByPrice(double price) {
        return cookwareRepository.getCookwareByPrice(price);
    }
    
    public List<Cookware> getCookwareByDescription(String description) {
        return cookwareRepository.getCookwareByDescription(description);
    }
    
    public Cookware save(Cookware cookware){
        
        Optional <Cookware> temporal = cookwareRepository.getCookware(cookware.getReference());

        if (temporal.isEmpty()) 
            return cookwareRepository.save(cookware);
        else
            return cookware;
    }
    
    public Cookware update(Cookware cookware) {
        
        Optional <Cookware> temporal = cookwareRepository.getCookware(cookware.getReference());

        if (!temporal.isEmpty()) {
            if (cookware.getBrand() != null) 
                temporal.get().setBrand(cookware.getBrand());
            if (cookware.getCategory() != null) 
                temporal.get().setCategory(cookware.getCategory());
            if (cookware.getMateriales() != null) 
                temporal.get().setMateriales(cookware.getMateriales());
            if (cookware.getDimensiones() != null)
                temporal.get().setDimensiones(cookware.getDimensiones());
            if (cookware.getDescription()!= null)
                temporal.get().setDescription(cookware.getDescription());
            if (cookware.isAvailability())
                temporal.get().setAvailability(true);
            else
                temporal.get().setAvailability(false);
            temporal.get().setPrice(cookware.getPrice());
            temporal.get().setQuantity(cookware.getQuantity());
            if (cookware.getPhotography()!= null)
                temporal.get().setPhotography(cookware.getPhotography());
            
            return cookwareRepository.save(temporal.get());
        }
        else{
            return cookware;
        }
    }

    public boolean delete(String reference) {
        
        Optional <Cookware> temporal = cookwareRepository.getCookware(reference);
        
        if (!temporal.isEmpty()) {
            cookwareRepository.delete(temporal.get());
            return true;
        }
        else
            return false;
    }    
}
