package com.exercise.repository;

import com.exercise.model.Song;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


@Service
public class SongRepositoryImpl implements ISongRepository {

    private static List<Song> songList = new ArrayList<>();

    static {
        songList.add(new Song("Chỉ là", "Khoa", "Nhạc vàng"));
        songList.add(new Song("Con cò bé bé", "Khoa", "Nhạc đỏ"));
        songList.add(new Song("Suýt nữa thì", "Khoa", "Nhạc tím"));
        songList.add(new Song("Năm anh em", "Khoa", "Nhạc xanh"));
    }

    @Override
    public List<Song> songList() {
        return songList;
    }

    @Override
    public void save(Song song) {
        songList.add(song);
    }
}
