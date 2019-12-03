package com.millenniumprogrammers.neocomer.model;
 
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
 
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Productos{
    
	 private int id_producto;
	 private int idvendedor;
	 private String nombreproducto;
	 private double precio;
 
 }
