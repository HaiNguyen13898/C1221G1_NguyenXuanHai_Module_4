package com.exercise.repository;

import com.exercise.model.Song;

import java.util.List;

public interface ISongRepository {
    List<Song> findAll();
    void save(Song song);
    Song findById(int id);
    void update( Song song);
    void remove(Song song);
    List<Song> searchByName(String nameSong);
}
