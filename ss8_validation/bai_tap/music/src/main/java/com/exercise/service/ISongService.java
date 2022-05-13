package com.exercise.service;

import com.exercise.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ISongService {
//    List<Song> findAll();
    void save(Song song);
    void remove(Song song);
    Song findById(int id);
    Page<Song> findAll(Pageable pageable);
}
