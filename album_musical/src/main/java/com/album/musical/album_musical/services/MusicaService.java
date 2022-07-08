package com.album.musical.album_musical.services;

import java.util.List;

import com.album.musical.album_musical.dto.MusicaAlbumDTO;
import com.album.musical.album_musical.dto.MusicaDTO;
import com.album.musical.album_musical.dto.NewMusicaDTO;
 
public interface MusicaService {
  
    public MusicaDTO create(Long idAlbum , NewMusicaDTO musicaDTO);
    public MusicaAlbumDTO retrieve(Long idAlbum, Long id);
    public  MusicaAlbumDTO update(MusicaDTO musicaDTO, Long idAlbum, Long id);
    public void delete(Long idAlbum, Long id);
    public List<MusicaDTO> list(Long idAlbum);
}
