package com.exercise.model;


import javax.persistence.*;

@Entity
@Table(name ="song")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nameSong;
    private String nameSinger;
    private String kindOfMusic;
    private String filePathMusic;

    public Song() {
    }

    public Song(String nameSong, String nameSinger, String kindOfMusic, String filePathMusic) {
        this.nameSong = nameSong;
        this.nameSinger = nameSinger;
        this.kindOfMusic = kindOfMusic;
        this.filePathMusic = filePathMusic;
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

    public String getFilePathMusic() {
        return filePathMusic;
    }

    public void setFilePathMusic(String filePathMusic) {
        this.filePathMusic = filePathMusic;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", nameSong='" + nameSong + '\'' +
                ", nameSinger='" + nameSinger + '\'' +
                ", kindOfMusic='" + kindOfMusic + '\'' +
                ", filePathMusic='" + filePathMusic + '\'' +
                '}';
    }
}
