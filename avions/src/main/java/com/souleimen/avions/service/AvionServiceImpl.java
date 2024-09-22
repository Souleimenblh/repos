package com.souleimen.avions.service;

//import java.util.ArrayList;

import java.util.List;


import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

//import com.souleimen.avions.dto.Avion;
import com.souleimen.avions.entities.Avion;
import com.souleimen.avions.entities.TypeAv;
import com.souleimen.avions.repos.AvionRepository;
import com.souleimen.avions.repos.TypeAvRepository;


@Service
public class AvionServiceImpl  implements AvionService	{
	
	
	@Autowired
	AvionRepository  avionRepository;;
	
	
	@Autowired
	TypeAvRepository typeAvRepository;
	
	@Override
	public Avion saveAvion(Avion p) {
		return avionRepository.save(p);
	}

	@Override
	public Avion updateAvion(Avion p) {
		
		return avionRepository.save(p);
	}

	@Override
	public void deleteAvion(Avion p) {

		avionRepository.delete(p);
	}

	@Override
	public void deleteAvionById(Long id) {
		avionRepository.deleteById(id);		
	}

	@Override
	public Avion getAvion(Long id) {
		return avionRepository.findById(id).get();
	}

	@Override
	public List<Avion> getAllAvions() {
	
		return avionRepository.findAll();
	}
	@Override
	public Page<Avion> getAllAvionsParPage(int page, int size) {
	return avionRepository.findAll(PageRequest.of(page, size));
	}

	@Override
	public List<Avion> findByMatriculeAvion(String matriculeAvion) {
		
		return avionRepository.findByMatriculeAvion(matriculeAvion);
	}

	@Override
	public List<Avion> findByMatriculeAvionContains(String matriculeAvion) {
		return avionRepository.findByMatriculeAvionContains(matriculeAvion);
	}

	@Override
	public List<Avion> findByfindByMatriculeCelometrage(String matriculeAvion, int celometrageAvion) {
	
		return avionRepository.findByMatriculeCelometrage(matriculeAvion,celometrageAvion);
	}

	@Override
	public List<Avion> findByTypeAv(TypeAv typeAv) {
		return avionRepository.findByTypeAv(typeAv);
	}

	@Override
	public List<Avion> findByTypeAvIdA(Long id) {

	    return avionRepository.findByTypeAvIdAv(id);
	}


	@Override
	public List<Avion> findByOrderByMatriculeAvAsc() {
		return avionRepository.findByOrderByMatriculeAvionAsc();
	}

	@Override
	public List<Avion> trierAvionsMatriculeCelometrage() {
		return avionRepository.trierAvionsMatriculeCelometrage();
	}

//	@Override
//	public List<Avion> getAllTypeAvs() {
//		return  avionRepository.findAll();
//	}
	
	@Override
	public List<TypeAv> getAllTypeAvs() {
		return typeAvRepository.findAll();

	}

//	@Override
//	public List<Avion> getAllTypeAvs() {
//		return  avionRepository.findAll();
//	}
	
}
