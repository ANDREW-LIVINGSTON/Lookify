package com.AL.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.AL.lookify.models.Song;
import com.AL.lookify.repositories.SongRepository;

@Service
public class SongService {
	// adding the book repository as a dependency
    private final SongRepository songRepository;
    
    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }
    // returns all the books
    public List<Song> allSongs() {
        return songRepository.findAll();
    }
    // creates a book
    public Song createSong(Song s) {
        return songRepository.save(s);
    }
    // retrieves a book
    public Song findSong(Long id) {
        Optional<Song> optionalSong = songRepository.findById(id);
        if(optionalSong.isPresent()) {
            return optionalSong.get();
        } else {
            return null;
        }
    }
    public List<Song> findArtist(String artist) {
    	return songRepository.findByArtistContaining(artist);
    }
    
    public Song updateSong(Song s) {
    	return songRepository.save(s);
    }
    
    public void deleteSong(Long id) {
    	songRepository.deleteById(id);
    }
    
    public Song saveSong(Song s) {
    	return songRepository.save(s);
    }
}
