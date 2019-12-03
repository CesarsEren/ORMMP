package com.millenniumprogrammers.neocomer.model;
 
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
 
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ventas{
    
	 private int id_venta;
	 private int id_cliente;
	 private int id_vendedor;
	 private String DNI;
	 private String NombreCompleto;
	 private double PrecioProd;
	 private int cantidad;
	 private char Tipo;
	 private char Serie;
	 private char Numero;
 
 }
