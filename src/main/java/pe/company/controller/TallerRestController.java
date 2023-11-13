package pe.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.company.model.Taller;
import pe.company.service.TallerService;

import java.util.Collection;

@RestController
@RequestMapping("/taller")
public class TallerRestController {
    @Autowired
    private TallerService tallerService;

    @GetMapping("/listar")
    public ResponseEntity<?> listar(){
        Collection<Taller> itemsTaller = tallerService.findAll();
        return new ResponseEntity<>(itemsTaller, HttpStatus.OK);
    }

    @PostMapping("/agregar")
    public ResponseEntity<?> agregar(@RequestBody Taller taller){
        tallerService.insert(taller);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
}
