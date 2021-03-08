package com.travellog.apiTravellog.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.travellog.apiTravellog.entity.Viaje;

@Repository
public class ViajeDAOImpl implements ViajeDAO{

	@Autowired
    private EntityManager entityManager;
	
	@Override
	public List<Viaje> findAll() {
		
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Viaje> theQuery = currentSession.createQuery("from viaje", Viaje.class);

        List<Viaje> viajes = theQuery.getResultList();

        return viajes;
	}

	@Override
	public Viaje findById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);

        Viaje viaje = currentSession.get(Viaje.class, id);

        return viaje;
	}

	@Override
	public void save(Viaje viaje) {
		Session currentSession = entityManager.unwrap(Session.class);

        currentSession.saveOrUpdate(viaje);  
	}

	@Override
	public void deleteById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);

        Query<Viaje> theQuery = currentSession.createQuery("delete from Viaje where viaje_id=:id_viaje");

        theQuery.setParameter("id_viaje", id);
        theQuery.executeUpdate();
		
	}

}
