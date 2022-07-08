package com.album.musical.album_musical.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.album.musical.album_musical.models.Album;
import com.album.musical.album_musical.models.Musica;

@Repository
public interface MusicaRepository extends JpaRepository<Musica,Long>{
    public List<Musica> findByAlbum(Album album);
}
