package com.album.musical.album_musical.services;

import java.util.List;

import com.album.musical.album_musical.dto.AlbumDTO;
import com.album.musical.album_musical.dto.AlbumListDTO;
import com.album.musical.album_musical.dto.NewAlbumDTO;

public interface AlbumService {
    public AlbumDTO create (NewAlbumDTO albumDTO);
    public AlbumDTO retrieve (Long id);
    public AlbumDTO update(AlbumDTO albumDTO, Long id);
    public void delete(Long id);
    public List<AlbumListDTO> list();
}
