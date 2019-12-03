package com.millenniumprogrammers.neocomer.model;
 
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
 
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Puestos{
    
	 private int id_puesto;
	 private String Detalle;
	 private String Color;
	 private boolean Estado;
 
 }
