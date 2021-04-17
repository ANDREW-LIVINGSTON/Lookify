package com.AL.lookify.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.AL.lookify.models.Song;

@Repository
public interface SongRepository extends CrudRepository<Song, Long>{
	// this method retrieves all the books from the database
    List<Song> findAll();
    
    Optional<Song> findById(Long x);
    // this method finds books with descriptions containing the search string
    List<Song> findByArtistContaining(String search);
    // this method counts how many titles contain a certain string
    
    void deleteById(Long id);
    
    Song save(Song song);
}
