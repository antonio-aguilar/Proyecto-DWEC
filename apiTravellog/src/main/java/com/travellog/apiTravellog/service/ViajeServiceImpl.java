package com.travellog.apiTravellog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.travellog.apiTravellog.dao.ViajeDAO;
import com.travellog.apiTravellog.entity.Viaje;

public class ViajeServiceImpl implements ViajeService {

	@Autowired
    private ViajeDAO viajeDAO;
	
	@Override
	public List<Viaje> findAll() {
		  List<Viaje> listUsers= viajeDAO.findAll();
		  return listUsers;
	}

	@Override
	public Viaje findById(int id) {
		Viaje viaje = viajeDAO.findById(id);
        return viaje;
	}

	@Override
	public void save(Viaje viaje) {		
		viajeDAO.save(viaje);
	}

	@Override
	public void deleteById(int id) {
		viajeDAO.deleteById(id);
	}

}
