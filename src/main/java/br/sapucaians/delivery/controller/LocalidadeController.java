package br.sapucaians.delivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.sapucaians.delivery.model.LocalidadeModel;
import br.sapucaians.delivery.services.LocalidadeService;

/**
 * LocalidadeController
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/localidade")
public class LocalidadeController {

    @Autowired
    private LocalidadeService service;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody LocalidadeModel localidade){
        return ResponseEntity.ok(service.create(localidade));
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<?> update(@RequestParam("id") Long id, @RequestBody LocalidadeModel localidade){
        return ResponseEntity.ok(service.create(localidade));
    }
    
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<?> delete(@RequestParam("id") Long id){
        service.delete(id);
        return ResponseEntity.ok().body(null);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@RequestParam("id") Long id){
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping("/")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(service.getAll());
    }
}