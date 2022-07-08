package com.album.musical.album_musical.dto;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AlbumListDTO {
    
    private Long id;
    private String nombre;
    private Date fecha_lanzamiento;
    private String descripcion;
    private String autor;
    

}
