package com.exercise.service;

import com.exercise.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> songList ();
    void save (Song song);

}
