package com.nelricksoft.restaurante.restaurante.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity//************ es un etiqueta para la clase que se va a convertir en una tabla en la base de datos */
@Data//************ Ayuda con los getters y setters ********************************* */
public class Sedes {

    @Id //************* Primary key ***************** */
    @GeneratedValue(strategy = GenerationType.IDENTITY)//******** genera clave primaria ***** */
    private Integer id;
    private String nombreSede;
    private String direccion;
    private String telefono;

    
}
