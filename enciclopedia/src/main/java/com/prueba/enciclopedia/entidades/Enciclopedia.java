/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.enciclopedia.entidades;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Enciclopedia {

    @Id
    private String title;
    private String content;
    
    @Temporal(TemporalType.DATE)
    private Date alta;

    public Enciclopedia() {
    }

    public Enciclopedia(String title, String content, Date alta) {
        this.title = title;
        this.content = content;
        this.alta = alta;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getAlta() {
        return alta;
    }

    public void setAlta(Date alta) {
        this.alta = alta;
    }

    @Override
    public String toString() {
        return "library{" + "title=" + title + ", content=" + content + ", alta=" + alta + '}';
    }
    
    
}
