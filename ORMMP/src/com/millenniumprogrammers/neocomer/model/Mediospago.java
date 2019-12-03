package com.millenniumprogrammers.neocomer.model;
 
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
 
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mediospago{
    
	 private int id_cliente;
	 private String NroTarjeta;
	 private String CCV;
	 private String FechaVenc;
 
 }
