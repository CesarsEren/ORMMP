package com.millenniumprogrammers.neocomer.model;
 
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
 
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Asociaciones{
    
	 private int id_asociacion;
	 private int id_rubro;
	 private String RUC;
	 private String Razon;
	 private String Direccion;
	 private String FechaRegistro;
 
 }
