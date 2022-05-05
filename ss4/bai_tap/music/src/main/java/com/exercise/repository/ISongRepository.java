package com.exercise.repository;

import com.exercise.model.Song;

import java.util.List;

public interface ISongRepository {
    List<Song> songList ();
    void save (Song song);

}
