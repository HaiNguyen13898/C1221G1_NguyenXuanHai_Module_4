package com.exercise.repository.impl;

import com.exercise.model.Song;
import com.exercise.repository.BaseRepository;
import com.exercise.repository.ISongRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;


@Repository
public class SongRepository implements ISongRepository {

    @Override
    public List<Song> findAll() {
        TypedQuery<Song> typedQuery = BaseRepository.entityManager.createQuery("select s from Song s", Song.class);
        return typedQuery.getResultList();
    }

    @Override
    public void save(Song song) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(song);
        entityTransaction.commit();
    }

    @Override
    public Song findById(int id) {
        return BaseRepository.entityManager.find(Song.class, id);
    }

    @Override
    public void update(Song song) {
//        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
//        entityTransaction.begin();
//        TypedQuery<Song> typedQuery = BaseRepository.entityManager.createQuery("update Song s " +
//                "set s.nameSong = :nameSong, " +
//                "s.nameSinger = :singerSong," +
//                " s.kindOfMusic = :typeSong " +
//                "where s.id = :idSong", Song.class);
//        typedQuery.setParameter("idSong", song.getId());
//        typedQuery.setParameter("nameSong", song.getNameSong());
//        typedQuery.setParameter("singerSong", song.getNameSinger());
//        typedQuery.setParameter("typeSong", song.getKindOfMusic());
//
//        typedQuery.executeUpdate();
//        entityTransaction.commit();
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(song);
        entityTransaction.commit();

    }


    @Override
    public void remove(Song song) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.remove(song);
        entityTransaction.commit();
    }

    @Override
    public List<Song> searchByName(String nameSong) {
        return null;
    }
}
