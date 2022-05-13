package com.exercise.service;

import com.exercise.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();
    void save(Song song);
    void remove(Song song);
    Song findById(int id);
}
