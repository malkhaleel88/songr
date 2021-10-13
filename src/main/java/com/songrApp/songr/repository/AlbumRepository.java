package com.songrApp.songr.repository;


import com.songrApp.songr.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {

    Album findAlbumByTitle(String title);


}
