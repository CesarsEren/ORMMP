package com.millenniumprogrammers.neocomer.model;
 
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
 
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Trabajadores{
    
	 private int id_trabajador;
	 private int id_persona;
	 private String correo;
	 private String password;
	 private boolean estado;
	 private int id_rol;
 
 }
