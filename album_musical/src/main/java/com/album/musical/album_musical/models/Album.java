package com.album.musical.album_musical.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="TBL_ALBUMES")
@Getter
@Setter
public class Album {
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="NOMBRE")
    private String nombre;
    @Column(name="FECHA_LANZAMIENTO")
    private Date fecha_lanzamiento;
    @Column(name="DESCRIPCION")
    private String descripcion;
    @Column(name="AUTOR")
    private String autor;
    
    @OneToMany(mappedBy="album")
    private List<Musica> musicas;

}
 
 
