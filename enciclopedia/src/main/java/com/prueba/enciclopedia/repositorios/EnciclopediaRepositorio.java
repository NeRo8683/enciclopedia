/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.enciclopedia.repositorios;

import com.prueba.enciclopedia.entidades.Enciclopedia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EnciclopediaRepositorio extends JpaRepository<Enciclopedia, String>{
    
    @Query("SELECT l FROM Enciclopedia l WHERE l.title = :title")
    public Enciclopedia buscarPorTitulo(@Param("title") String title);        
}
