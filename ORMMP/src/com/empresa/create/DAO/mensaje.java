/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empresa.create.DAO;

/**
 *
 * @author cesars
 */
public class mensaje<T> {

    T objecto;

    String dato;

    public mensaje() {
    }

    public mensaje(T objecto, String dato) {
        this.objecto = objecto;
        this.dato = dato;
    }

    public T getObjecto() {
        return objecto;
    }

    public void setObjecto(T objecto) {
        this.objecto = objecto;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

}
