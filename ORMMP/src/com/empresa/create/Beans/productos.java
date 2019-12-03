package com.empresa.create.Beans;

public class productos {

    int codigo;

    String nombre;

    int cantidad;

    double precio;

    public productos(int codigo, String nombre, int cantidad, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public productos() {
    }

    public void setcodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getcodigo() {
        return this.codigo;
    }

    public void setnombre(String nombre) {
        this.nombre = nombre;
    }

    public String getnombre() {
        return this.nombre;
    }

    public void setcantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getcantidad() {
        return this.cantidad;
    }

    public void setprecio(double precio) {
        this.precio = precio;
    }

    public double getprecio() {
        return this.precio;
    }
}
