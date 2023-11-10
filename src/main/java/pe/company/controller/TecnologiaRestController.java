package pe.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.company.model.Conyuge;
import pe.company.model.Tecnologia;
import pe.company.service.TecnologiaService;

import java.util.Collection;

@RestController
@RequestMapping("/tecnologia")
public class TecnologiaRestController {
    @Autowired
    private TecnologiaService tecnologiaService;

    @GetMapping("/listar")
    public ResponseEntity<?> listar(){
        Collection<Tecnologia> itemsTecnologia = tecnologiaService.findAll();
        return new ResponseEntity<>(itemsTecnologia, HttpStatus.OK);
    }

    @PostMapping("/agregar")
    public ResponseEntity<?> agregar(@RequestBody Tecnologia tecnologia){
        tecnologiaService.insert(tecnologia);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
}
