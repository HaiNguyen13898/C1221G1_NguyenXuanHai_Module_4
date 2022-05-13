package com.exercise.service;

import com.exercise.model.Song;
import com.exercise.repository.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SongServiceImpl implements ISongService {

    @Autowired
    private ISongRepository songRepository;

    @Override
    public List<Song> songList() {
        return this.songRepository.songList();
    }

    @Override
    public void save(Song song) {
        this.songRepository.save(song);
    }
}
