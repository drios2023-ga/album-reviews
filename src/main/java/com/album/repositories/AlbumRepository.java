package com.album.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.album.entities.Album;

// Our Repository, the two types in <> are the Entity and type of the ID
public interface AlbumRepository extends JpaRepository<Album, Integer>{

}
