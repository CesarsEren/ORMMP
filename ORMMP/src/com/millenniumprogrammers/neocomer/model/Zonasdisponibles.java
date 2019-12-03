package com.millenniumprogrammers.neocomer.model;
 
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
 
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Zonasdisponibles{
    
	 private int id_zona;
	 private String Apodo;
	 private double longitud;
	 private double latitud;
	 private boolean estado;
 
 }
