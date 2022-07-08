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

import com.album.musical.album_musical.dto.MusicaAlbumDTO;
import com.album.musical.album_musical.dto.MusicaDTO;
import com.album.musical.album_musical.dto.NewMusicaDTO;
import com.album.musical.album_musical.services.MusicaService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/albumes")

public class MusicaController {

    final MusicaService service;

    public MusicaController(MusicaService srv){
        this.service = srv;
    }

    /* ================ CREATE ================ */
    @PostMapping("/{id}/musicas")
    public ResponseEntity<MusicaDTO> create(@PathVariable("id") Long id, @Valid @RequestBody NewMusicaDTO musicaDTO){
        MusicaDTO musicDTO = service.create(id, musicaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(musicDTO);        
    }

    /* ================ RETRIEVE ================ */
    @GetMapping("/{idAlbum}/musicas/{id}")
    public ResponseEntity<MusicaAlbumDTO> retrive(@PathVariable("idAlbum") Long idAlbum, @PathVariable("id") Long id){
        MusicaAlbumDTO result = service.retrieve(idAlbum, id);
        return ResponseEntity.ok().body(result);        
    }

    /* ================ UPDATE ================ */
    @PutMapping("/{idAlbum}/musicas/{id}")
    public ResponseEntity<MusicaAlbumDTO> update(@RequestBody MusicaDTO musicaDTO, @PathVariable("idAlbum") Long idAlbum, @PathVariable("id") Long id){
        MusicaAlbumDTO result = service.update(musicaDTO, idAlbum, id);
        return ResponseEntity.ok().body(result);
    }

    /* ================ DELETE ================ */
    @DeleteMapping("/{idAlbum}/musicas/{id}")
    public ResponseEntity<Void> delete(@PathVariable("idAlbum") Long idAlbum, @PathVariable("id") Long id){
        service.delete(idAlbum, id);
        return ResponseEntity.noContent().build();
    }

    /* ================ LIST ================ */
    @GetMapping("/{id}/musicas")
    public ResponseEntity<List<MusicaDTO>> list(@PathVariable("id") Long id){
        List<MusicaDTO> musicas = service.list(id);
        return ResponseEntity.ok().body(musicas);        
    }
}
