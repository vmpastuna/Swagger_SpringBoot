package com.album.musical.album_musical.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.album.musical.album_musical.dto.AlbumDTO;
import com.album.musical.album_musical.dto.AlbumListDTO;
import com.album.musical.album_musical.dto.NewAlbumDTO;
import com.album.musical.album_musical.exceptions.NoContentException;
import com.album.musical.album_musical.exceptions.ResourceNotFoundException;
import com.album.musical.album_musical.models.Album;
import com.album.musical.album_musical.repositories.AlbumRepository;
import com.album.musical.album_musical.services.AlbumService;

@Service
public class AlbumServiceImpl implements AlbumService {
    
    final ModelMapper modelMapper;
    final AlbumRepository albumRepository;

    public AlbumServiceImpl(AlbumRepository repository, ModelMapper mapper){
        this.albumRepository = repository;
        this.modelMapper = mapper;
    }

    @Override
    @Transactional
    public AlbumDTO create(NewAlbumDTO albumDTO) {
        Album album = modelMapper.map(albumDTO, Album.class);
        albumRepository.save(album);        
        return modelMapper.map(album, AlbumDTO.class); 
    }

    @Override
    @Transactional(readOnly = true)
    public AlbumDTO retrieve(Long id) {
        Album album = albumRepository.findById(id)
            .orElseThrow(()-> new ResourceNotFoundException("Album no Encontrado"));
        return modelMapper.map(album, AlbumDTO.class);
    }

    @Override
    @Transactional
    public AlbumDTO update(AlbumDTO albumDTO, Long id) {
        Album album = albumRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Album no Encontrado"));
        
        album.setId(id);
        album = modelMapper.map(albumDTO, Album.class);
        albumRepository.save(album);       

        return modelMapper.map(album, AlbumDTO.class);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Album album = albumRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Album Eliminado"));        
        albumRepository.deleteById(album.getId());        
    }

    @Override
    @Transactional(readOnly = true)
    public List<AlbumListDTO> list() {
        List<Album> albumes = albumRepository.findAll();
        if(albumes.isEmpty()) throw new NoContentException("Album Vacio");
        return albumes.stream().map(album -> modelMapper.map(album, AlbumListDTO.class))
            .collect(Collectors.toList());        
    }
}
