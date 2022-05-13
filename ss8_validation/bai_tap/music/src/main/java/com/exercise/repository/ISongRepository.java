package com.exercise.repository;

import com.exercise.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ISongRepository extends JpaRepository<Song, Integer> {
    Page<Song> findAll (Pageable pageable);
}
