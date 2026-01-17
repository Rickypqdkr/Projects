package com.nelricksoft.restaurante.restaurante.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nelricksoft.restaurante.restaurante.entities.TipoDescuento;
import com.nelricksoft.restaurante.restaurante.repositories.TipoDescuentoRepository;

@Component //**** Le dice a spring que gestione esta clase. *********/
public class DataLoader implements CommandLineRunner{
    private final TipoDescuentoRepository tipoDescuentoRepository;

    
    public DataLoader(TipoDescuentoRepository tipoDescuentoRepository){
        this.tipoDescuentoRepository = tipoDescuentoRepository;
    }

    @Override
    public void run(String... args) throws Exception{
        //****** Este codigo se ejecuta una vez que la aplicacion inicie *****/
        if(tipoDescuentoRepository.count() == 0){
            TipoDescuento general = new TipoDescuento();
            general.setNombre_descuento("General");
            general.setPorcentaje_descuento(0.0);

            TipoDescuento estudiante = new TipoDescuento();
            estudiante.setNombre_descuento("Estudiante");
            estudiante.setPorcentaje_descuento(15.0);

            tipoDescuentoRepository.save(general);
            tipoDescuentoRepository.save(estudiante);

            System.out.println("Tipos de descuentos cargados en la base de datos");
        }
    }
}
