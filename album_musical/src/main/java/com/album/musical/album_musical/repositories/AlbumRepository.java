package com.album.musical.album_musical.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.album.musical.album_musical.models.Album;

@Repository 
public interface AlbumRepository  extends JpaRepository <Album,Long>{
    
}
