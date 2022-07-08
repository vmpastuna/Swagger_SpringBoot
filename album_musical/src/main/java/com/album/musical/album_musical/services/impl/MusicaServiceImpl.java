package com.album.musical.album_musical.services.impl;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.album.musical.album_musical.dto.MusicaAlbumDTO;
import com.album.musical.album_musical.dto.MusicaDTO;
import com.album.musical.album_musical.dto.NewMusicaDTO;
import com.album.musical.album_musical.exceptions.NoContentException;
import com.album.musical.album_musical.exceptions.ResourceNotFoundException;
import com.album.musical.album_musical.models.Album;
import com.album.musical.album_musical.models.Musica;
import com.album.musical.album_musical.repositories.AlbumRepository;
import com.album.musical.album_musical.repositories.MusicaRepository;
import com.album.musical.album_musical.services.MusicaService;
 

@Service
public class MusicaServiceImpl implements MusicaService {
    
   final ModelMapper modelMapper;
    final MusicaRepository musicaRepository;
    final AlbumRepository albumRepository;

    public MusicaServiceImpl(MusicaRepository repository,AlbumRepository al, ModelMapper mapper){
        this.musicaRepository = repository;
        this.modelMapper = mapper;
        this.albumRepository=al;
    }

    @Override
    @Transactional
    public MusicaDTO create(Long idAlbum , NewMusicaDTO musicaDTO)
     {
        Album album = albumRepository.findById(idAlbum)
            .orElseThrow(()-> new ResourceNotFoundException("Album no Encontrado"));
        Musica musica = modelMapper.map(musicaDTO, Musica.class);    
        musica.setAlbum(album);
        musicaRepository.save(musica);
        return modelMapper.map(musica, MusicaDTO.class); 
    }

    @Override
    @Transactional(readOnly=true)
    public MusicaAlbumDTO retrieve(Long idAlbum, Long id) {
        Album album = albumRepository.findById(idAlbum)
            .orElseThrow(()-> new ResourceNotFoundException("Album no Encontrado"));
        Musica musica = musicaRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Question not found"));
        musica.setAlbum(album);
        return modelMapper.map(musica, MusicaAlbumDTO.class);
    }

    @Override
    @Transactional
    public  MusicaAlbumDTO update(MusicaDTO musicaDTO, Long idAlbum, Long id) {
    Album album = albumRepository.findById(idAlbum)
        .orElseThrow(()-> new ResourceNotFoundException("Album no Encontrado"));
        Musica musica = musicaRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Question not found"));
        musica.setAlbum(album);
        return modelMapper.map(musica, MusicaAlbumDTO.class);
    }


    @Override
    @Transactional
    public void delete(Long idAlbum, Long id) {
        Album album = albumRepository.findById(idAlbum)
        .orElseThrow(()-> new ResourceNotFoundException("Album no Encontrado"));
        Musica musica = musicaRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Question not found"));
        musica.setAlbum(album);
        musicaRepository.deleteById(musica.getId());  
    }

    @Override
    @Transactional(readOnly=true)
    public List<MusicaDTO> list(Long idAlbum) {
        Album album = albumRepository.findById(idAlbum)
            .orElseThrow(()-> new ResourceNotFoundException("Album no Encontrado"));
        List<Musica> musicas = musicaRepository.findByAlbum(album);
        if(musicas.isEmpty()) throw new NoContentException("Musica Vacia");
        //Lambda ->
        return musicas.stream().map(mus -> modelMapper.map(mus, MusicaDTO.class) )
            .collect(Collectors.toList());
    }


    
}
