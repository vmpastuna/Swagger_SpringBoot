package com.album.musical.album_musical.dto;
import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
 
public class NewMusicaDTO {
    private String nombre;
    private Date fecha_publicacion;
    private String genero;
    private String formato;

}
