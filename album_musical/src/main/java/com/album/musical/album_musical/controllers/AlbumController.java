package com.album.musical.album_musical.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.album.musical.album_musical.dto.AlbumDTO;
import com.album.musical.album_musical.dto.AlbumListDTO;
import com.album.musical.album_musical.dto.NewAlbumDTO;
import com.album.musical.album_musical.services.AlbumService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/albumes")
public class AlbumController {
    
    private final AlbumService service;
  
    public AlbumController(AlbumService srv){
        this.service =srv;
    }
    
    /* ================ CREATE ================ */
    @PostMapping()
    public ResponseEntity<AlbumDTO> create(@Valid @RequestBody NewAlbumDTO albumDTO){
        AlbumDTO result = service.create(albumDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);        
    }

    /* ================ RETRIEVE ================ */
    @GetMapping("/{id}")
    public ResponseEntity<AlbumDTO> retrive(@PathVariable("id") Long id){
        AlbumDTO result = service.retrieve(id);
        return ResponseEntity.ok().body(result);        
    }

    /* ================ UPDATE ================ */
    @PutMapping("/{id}")
    public ResponseEntity<AlbumDTO> update(@RequestBody AlbumDTO albumDTO, @PathVariable("id") Long id){
        AlbumDTO result = service.update(albumDTO, id);
        return ResponseEntity.ok().body(result);
    }

    /* ================ DELETE ================ */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    /* ================ LIST ================ */
    @GetMapping()
    public ResponseEntity<List<AlbumListDTO>> list(){
        List<AlbumListDTO> result  = service.list();
        return ResponseEntity.ok().body(result);        
    }

}
