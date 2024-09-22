package com.souleimen.avions.restcontrollers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//import com.souleimen.avions.dto.Avion;
import com.souleimen.avions.entities.Avion;
import com.souleimen.avions.repos.AvionRepository;
import com.souleimen.avions.service.AvionService;
@RestController
@RequestMapping("/api")
@CrossOrigin("*")
//@CrossOrigin(origins = "http://localhost:4200")

public class AvionRESTController {
@Autowired
AvionService avionService;

//@RequestMapping(method = RequestMethod.GET)
//public List<Avion> getAllAvions() {
//return avionService.getAllAvions();
//}



@RequestMapping(method = RequestMethod.GET)
public List<Avion> getAllAvions() {
return avionService.getAllAvions();
}

//@RequestMapping(value="/getbyid/{id}",method = RequestMethod.GET)
@RequestMapping(value="/{id}", method = RequestMethod.GET)
@GetMapping ("/getbyid/{id}")
public Avion getAvionById(@PathVariable("id") Long id) {
return avionService.getAvion(id);
 }

//@RequestMapping(value = "/addavio" ,method = RequestMethod.POST)
//@PostMapping("/addavio")
//@PreAuthorize("hasAuthority('Admin')")
@RequestMapping(method = RequestMethod.POST)
public Avion createAvion(@RequestBody Avion avion) {
return avionService.saveAvion(avion);
}


@RequestMapping(method = RequestMethod.PUT)
//@RequestMapping(value = "/updateavio" ,method = RequestMethod.POST)
//@PutMapping("/updateavio")
public Avion updateAvion(@RequestBody Avion avion) {
return avionService.updateAvion(avion);
}

@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
//@RequestMapping(value="/delavio/{id}",method = RequestMethod.DELETE)
//@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
//@DeleteMapping("/delavio/{id}")
public void deleteAvion(@PathVariable("id") Long id) {
	avionService.deleteAvionById(id);
}

//id
//@RequestMapping(value="/Aviostyp/{idA}",method = RequestMethod.GET)
//public List<Avion> getAvionsByCatId(@PathVariable("idA") Long idA) {
//return avionService.findByTypeAvIdA(idA);
//}

@RequestMapping(value="/aviostyp/{idAv}",method = RequestMethod.GET)
//@RequestMapping(value="/aviostyp/{idAv}",method = RequestMethod.GET)
public List<Avion> findByTypeAvIdAv(@PathVariable("idAv") Long idA) {
return avionService.findByTypeAvIdA(idA);
}

@RequestMapping(value="/aviosByMatricule/{nom}",method = RequestMethod.GET)
//@RequestMapping(value="/aviosByMatricule/{nom}",method = RequestMethod.GET)
public List<Avion> findByNomAvionContains(@PathVariable("nom") String nom) {
return avionService.findByMatriculeAvion(nom);
}
}