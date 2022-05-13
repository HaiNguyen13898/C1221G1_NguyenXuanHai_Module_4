package com.exercise.service.impl;

import com.exercise.model.Song;
import com.exercise.repository.ISongRepository;
import com.exercise.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SongService implements ISongService {

    @Autowired
    private ISongRepository songRepository;


    //    @Override
//    public List<Song> findAll() {
//        return songRepository.findAll();
//    }
    @Override
    public Page<Song> findAll(Pageable pageable) {
        return songRepository.findAll(pageable);
    }


    @Override
    public void save(Song song) {
        songRepository.save(song);
    }

    @Override
    public void remove(Song song) {
        songRepository.delete(song);
    }

    @Override
    public Song findById(int id) {
        return songRepository.findById(id).orElse(null);
    }


}
