package com.album.musical.album_musical.dto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MusicaAlbumDTO  extends MusicaDTO{
    private AlbumDTO album;
}
