/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.C4G16.Reto5.interfaces;

import com.C4G16.Reto5.model.Cookware;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author edgarchaparro
 */
public interface CookwareInterface extends MongoRepository<Cookware, String> {
    
    Optional<Cookware> findByReference(String reference);
    List<Cookware> findByPrice(double price);
    List<Cookware> findByDescriptionContainingIgnoreCase(String description);
}
