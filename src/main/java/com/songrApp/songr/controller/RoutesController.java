package com.songrApp.songr.controller;

import com.songrApp.songr.model.Album;
import com.songrApp.songr.model.Song;
import com.songrApp.songr.repository.AlbumRepository;
import com.songrApp.songr.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.transaction.Transactional;


@Controller
public class RoutesController {

    @Autowired
    private AlbumRepository albumRepository;

    private final SongRepository songRepository;
    public RoutesController(SongRepository songRepository) {
        this.songRepository = songRepository;
    }


    @GetMapping("/hello")
    public String greetings(@RequestParam(name = "name", required = false, defaultValue = "world") String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }

    @GetMapping("/capitalize/{name}")
    public String capitalize(@PathVariable String name, Model model) {
        model.addAttribute("name", name.toUpperCase());
        return "capitalize";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("message", "This Is Our Albums App");
        return "index";
    }


//    @GetMapping("/albums")
//    public String getClassInformation(Model model) {
//        ArrayList<Album> albums = new ArrayList<>();
//        Album album1 = new Album("Tamally Maak", "Amr Diab", 10, 1500,"https://img.discogs.com/mrVhxSpktswpKo82TcPqv0vK80U=/fit-in/300x300/filters:strip_icc():format(webp):mode_rgb():quality(40)/discogs-images/R-6944106-1500743368-8340.jpeg.jpg");
//        albums.add(album1);
//        Album album2 = new Album("Aktar Wahed", "Amr Diab", 9, 2000,"https://img.discogs.com/60vmnABbNLDfwLMosvcyjPsa-cE=/fit-in/600x605/filters:strip_icc():format(jpeg):mode_rgb():quality(90)/discogs-images/R-10333312-1495486487-7127.jpeg.jpg");
//        albums.add(album2);
//        Album album3 = new Album("Allem Alby", "Amr Diab", 8, 3500,"data:image/jpeg;base64,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");
//        albums.add(album3);
//        model.addAttribute("album", albums);
//        return "albums";
//    }

     /**
     * lab 12
     */

    @GetMapping("/albums")
    public String getAlbumsInformation(Model model) {
    model.addAttribute("albums", albumRepository.findAll());
    return "albums";
}

    @PostMapping("/albums")
    public RedirectView createNewAlbum(@ModelAttribute Album album) {
        albumRepository.save(album);
        return new RedirectView("albums");
    }

     /**
     * lab 13
     */


    @GetMapping("/songs")
    public String getSongs(Model model) {
        model.addAttribute("songs", songRepository.findAll());
        return "songs";

    }

    @GetMapping("/albums/{title}")
    public String getOneAlbum(@PathVariable String title, Model model) {
        model.addAttribute("albums", albumRepository.findAlbumByTitle(title));
        return "oneAlbum";

    }

    @GetMapping("/albums/add/{title}")
    public String viewAdd(@PathVariable String title, Model model) {
        model.addAttribute("album", albumRepository.findAlbumByTitle(title));
        return "addSong";

    }


    @Transactional
    @PostMapping("/albums/add/{title}")
    public RedirectView createNewSongs(@PathVariable String title, @ModelAttribute Song song) {
        Album album = albumRepository.findAlbumByTitle(title);
        song.setAlbum(album);
        album.getSongsList().add(song);
        songRepository.save(song);
        albumRepository.save(album);
        return new RedirectView("/albums");
    }

}
