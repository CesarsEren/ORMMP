package com.millenniumprogrammers.neocomer.model;
 
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
 
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reclamos{
    
	 private int id_reclamo;
	 private int id_cliente;
	 private int id_vendedor;
	 private int id_venta;
	 private String detalle_solucion;
	 private String detalle_reclamo;
	 private String FechaReg;
	 private String FechaVenc;
	 private boolean solucionado;
 
 }
