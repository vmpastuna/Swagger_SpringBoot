package com.album.musical.album_musical.dto;

import java.util.Date;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NewAlbumDTO {
    @NotNull(message = "Nombre no encontrado.")
    private String nombre;
    private Date fecha_lanzamiento;
    private String descripcion;
    @NotNull(message = "Autor no encontrado.")
    private String autor;     
}