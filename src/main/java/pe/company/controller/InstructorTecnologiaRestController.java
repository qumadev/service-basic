package pe.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.company.model.Instructor;
import pe.company.model.InstructorTecnologia;
import pe.company.model.Tecnologia;
import pe.company.service.InstructorService;
import pe.company.service.TecnologiaService;

import java.util.Collection;

@RestController
@RequestMapping("/instructor_tecnologia")
public class InstructorTecnologiaRestController {

    @Autowired
    private InstructorService instructorService;

    @Autowired
    private TecnologiaService tecnologiaService;

    @GetMapping("/listar")
    public ResponseEntity<?> listar(@RequestBody Instructor instructor)
    {
        Instructor instructorDb=instructorService.findById(instructor.getInstructorId());

        if(instructorDb!=null)
        {
            Collection<Tecnologia> itemsTecnologia=instructorDb.getItemsTecnologia();
            return new ResponseEntity<>(itemsTecnologia, HttpStatus.OK);
        }

        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/agregar")
    public ResponseEntity<?> agregar(@RequestBody InstructorTecnologia instructor_tecnologia)
    {
        Instructor instructorDb=instructorService.findById(
                instructor_tecnologia.getInstructor().getInstructorId());

        Tecnologia tecnologiaDb=tecnologiaService.findById(
                instructor_tecnologia.getTecnologia().getTecnologiaId());

        if(instructorDb!=null && tecnologiaDb!=null)
        {
//            Tecnologia tecnologiaDb=tecnologiaService.findById(
//                    instructor_tecnologia.getTecnologia().getTecnologiaId());

//            instructorDb.addTecnologia(tecnologiaDb);

            instructorService.insert(instructorDb);
            return new ResponseEntity<Void>(HttpStatus.CREATED);
        }

        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

}
