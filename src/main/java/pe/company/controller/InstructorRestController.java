package pe.company.controller;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.company.model.Instructor;
import pe.company.service.InstructorService;


@RestController
@RequestMapping("/instructor")
public class InstructorRestController {
	
	@Autowired
	private InstructorService instructorService;
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar(){
		Collection<Instructor> itemsInstructor = instructorService.findAll();
		return new ResponseEntity<>(itemsInstructor, HttpStatus.OK);
	}
	
	@GetMapping("/buscar/{instructorId}")
	public ResponseEntity<?> buscar(@PathVariable int instructorId){
		Instructor instructorDB = instructorService.findById(instructorId);
		
		if(instructorDB!=null) {
			return new ResponseEntity<>(instructorDB, HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		
	}
	
	@PostMapping("/agregar")
	public ResponseEntity<?> agregar(@RequestBody Instructor instructor){
		instructorService.insert(instructor);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@PutMapping("/editar/{instructorId}")
	public ResponseEntity<?> editar(@PathVariable int instructorId,
			@RequestBody Instructor newInstructor){
		
		Instructor instructorDB = instructorService.findById(instructorId);

		if(instructorDB!=null) {
			instructorDB.setNombre(newInstructor.getNombre());
			instructorDB.setApellidos(newInstructor.getApellidos());
			instructorDB.setPassword(newInstructor.getPassword());
			instructorDB.setEmail(newInstructor.getEmail());
			instructorDB.setFregistro(newInstructor.getFregistro());
			instructorService.update(instructorDB);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/borrar/{instructorId}")
	public ResponseEntity<?> borrar(@PathVariable int instructorId){
		Instructor instructorDB = instructorService.findById(instructorId);
		if(instructorDB!=null) {
			instructorService.delete(instructorId);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}

}
