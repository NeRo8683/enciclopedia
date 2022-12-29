/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.enciclopedia.servicio;

import com.prueba.enciclopedia.entidades.Enciclopedia;
import com.prueba.enciclopedia.excepciones.MiException;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.prueba.enciclopedia.repositorios.EnciclopediaRepositorio;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;

@Service
public class EnciclopediaServicio {
    
    @Autowired 
    private EnciclopediaRepositorio enciclopediaRepositorio;
    
    @Transactional
    public void crearEnciclopedia(String title, String content)throws MiException{
        
        validar(title, content);
                       
        Enciclopedia enciclopedia = new Enciclopedia();
        enciclopedia.setTitle(title);
        enciclopedia.setContent(content);
        enciclopedia.setAlta(new Date());
        
        enciclopediaRepositorio.save(enciclopedia);
    }
    
    public List<Enciclopedia> listarEnciclopedia(){
        List<Enciclopedia> enciclopedias = new ArrayList<>();
        enciclopedias = enciclopediaRepositorio.findAll();
        return enciclopedias;
    }
    @Transactional
    public void modificarEnciclopedia(String title, String content)throws MiException{
        validar(title, content);
        Optional<Enciclopedia> rta = enciclopediaRepositorio.findById(title);
        if (rta.isPresent()) {
            Enciclopedia enciclopedia = rta.get();
            enciclopedia.setTitle(title);
            enciclopedia.setContent(content);
            enciclopediaRepositorio.save(enciclopedia);
        }
    }
    
    private void validar(String title, String content)throws MiException{
        if (title == null || title.isEmpty()) {
            throw new MiException("El title no puede estar vacio o nulo");
        }
        
        if (title == null || content.isEmpty()) {
            throw new MiException("El content no puede estar vacio o nulo");
        }
    }
    
    
}
