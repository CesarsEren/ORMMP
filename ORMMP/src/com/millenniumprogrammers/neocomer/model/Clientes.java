package com.millenniumprogrammers.neocomer.model;
 
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
 
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Clientes{
    
	 private int id_cliente;
	 private int id_persona;
	 private String correo;
	 private String password;
 
 }
