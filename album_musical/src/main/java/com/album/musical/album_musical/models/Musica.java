package com.album.musical.album_musical.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="TBL_MUSICAS")
@Getter
@Setter
public class Musica {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="NOMBRE")
    private String nombre;
    @Column(name="FECHA_PUBLICACION")
    private Date fecha_publicacion;
    @Column(name="Genero")
    private String genero;
    @Column(name="Formato")
    private String formato;

    @ManyToOne
    @JoinColumn(name="ALBUM_ID", nullable=false)
    private Album album;

}