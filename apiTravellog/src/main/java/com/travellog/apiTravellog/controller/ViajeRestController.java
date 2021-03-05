package com.travellog.apiTravellog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import com.travellog.apiTravellog.service.ViajeService;
import com.travellog.apiTravellog.service.ViajeServiceImpl;
import com.travellog.apiTravellog.entity.Viaje;

//Indiciamos que es un controlador rest
@RestController
@RequestMapping("/api") //esta sera la raiz de la url, es decir http://127.0.0.1:8080/api/
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST}) // Evita problmas COR

public class ViajeRestController {

	 //Inyectamos el servicio para poder hacer uso de el
    @Autowired
    private ViajeService viajeService;
	
    @Bean
	public ViajeService viajeService() {
	    return new ViajeServiceImpl();
	}
    
    //
    // GETS
    //
    
    @GetMapping("/viajes")
    public List<Viaje> findAll(){
        //retornará todos los viajes
        return viajeService.findAll();
    }
    
    @GetMapping("/viajes/{viajeId}")
    public Viaje getUser(@PathVariable int viajeId){
        Viaje viaje = viajeService.findById(viajeId);

        if(viaje == null) {
            throw new RuntimeException("Viaje id not found -"+viajeId);
        }
        //retornará al viaje con id pasado en la url
        return viaje;
    }
    
    //
    // POST
    //
    
    @PostMapping("/viajes")
    public Viaje addViaje(@RequestBody Viaje viaje) {
    	
        viaje.setViaje_id(0);

        //Este metodo guardará al viaje enviado
        viajeService.save(viaje);

        return viaje;
    }
    
    // 
    // PUT
    //
    
    @PutMapping("/viajes")
    public Viaje updateUser(@RequestBody Viaje viaje) {

        viajeService.save(viaje);

        //este metodo actualizará al viaje enviado

        return viaje;
    }
    
    //
    // DELETE
    //
    
    @DeleteMapping("viajes/{viajeId}")
    public String deleteUser(@PathVariable int viajeId) {

        Viaje viaje = viajeService.findById(viajeId);

        if(viaje == null) {
            throw new RuntimeException("Viaje id not found -"+viajeId);
        }

        viajeService.deleteById(viajeId);

        //Esto método, recibira el id de un viaje por URL y se borrará de la bd.
        return "Deleted user id - "+viajeId;
    }
}
