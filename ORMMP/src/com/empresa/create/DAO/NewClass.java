/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empresa.create.DAO;

import com.empresa.create.Beans.productos;

/**
 *
 * @author cesars
 */
public class NewClass {

    public static void main(String[] args) {
        //   productos xp = new productos();
        //   System.out.println(xp.getClass().getSimpleName());
        mensaje<productos> rpta = new mensaje<>();
        //System.out.println(rpta.getObjecto().getClass().getSimpleName());
        rpta.objecto = new productos(1, "cesars", 2, 5.0);
        //System.out.println(rpta.objecto);
        rpta.dato = "cusasd";
        System.out.println(rpta.dato);
        System.out.println(rpta.objecto.getClass());
    }
}   
