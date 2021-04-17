package com.AL.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.AL.lookify.models.Song;
import com.AL.lookify.services.SongService;




@Controller
public class lookifyController {
	private final SongService songService;
	public lookifyController(SongService songService) {
        this.songService = songService;
    }
	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	@RequestMapping("/dashboard")
    public String index(Model model) {
        List<Song> songs = songService.allSongs();
        model.addAttribute("songs", songs);
        model.addAttribute("artist", new Song());
        return "dashboard.jsp";
    }
	@RequestMapping("/songs/new")
	public String newSong(Model model) {
		model.addAttribute("song", new Song());
        return "new.jsp";
	}
	@RequestMapping(value="/songs", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("song") Song song, BindingResult result) {
        if (result.hasErrors()) {
            return "new.jsp";
        } else {
            songService.createSong(song);
            return "redirect:/dashboard";
        }
	}
	@RequestMapping(value="/search/artist", method=RequestMethod.GET)
	public String search(@RequestParam(name="artist") String artist, Model model) {
		List<Song>  thisArtist = songService.findArtist(artist);
		String myArtist = myArtist(artist);
		model.addAttribute("artist", myArtist);
		model.addAttribute("songs", thisArtist);
		return "artist.jsp";
	}
	public String myArtist(@Valid @ModelAttribute("artist") String artist) {
		String theArtist = artist.toString();
		return theArtist;
	}
	@RequestMapping("/songs/{id}")
    public String showSong(@PathVariable("id") Long id, Model model) {
    	model.addAttribute("song", songService.findSong(id));
    	return "song.jsp";
    }
	@RequestMapping(value="/songs/{id}", method=RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
        songService.deleteSong(id);
        return "redirect:/dashboard";
    }
	
}
	
