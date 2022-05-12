package com.exercise.dto;


import javax.validation.constraints.NotBlank;

public class SongDto  {
    private int id;

    @NotBlank(message = "Không được để trống")
    private String nameSong;

    @NotBlank(message = "Không được để trống")
    private String nameSinger;


    private String kindOfMusic;

    public SongDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public String getNameSinger() {
        return nameSinger;
    }

    public void setNameSinger(String nameSinger) {
        this.nameSinger = nameSinger;
    }

    public String getKindOfMusic() {
        return kindOfMusic;
    }

    public void setKindOfMusic(String kindOfMusic) {
        this.kindOfMusic = kindOfMusic;
    }
}
