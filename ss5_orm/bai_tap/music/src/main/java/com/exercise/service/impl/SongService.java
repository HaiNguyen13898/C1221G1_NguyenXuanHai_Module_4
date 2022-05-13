package com.exercise.service.impl;

import com.exercise.model.Song;
import com.exercise.repository.ISongRepository;
import com.exercise.repository.impl.SongRepository;
import com.exercise.service.ISongService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SongService implements ISongService {

    private ISongRepository songRepository = new SongRepository();


    @Override
    public List<Song> findAll() {
        return songRepository.findAll();
    }

    @Override
    public void save(Song song) {
        songRepository.save(song);
    }

    @Override
    public Song findById(int id) {
        return songRepository.findById(id);
    }

    @Override
    public void update( Song song) {
        songRepository.update( song);
    }

    @Override
    public void remove(Song song) {
        songRepository.remove(song);
    }

    @Override
    public List<Song> searchByName(String nameSong) {
        return null;
    }
}
