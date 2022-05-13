package com.exercise.controller;

import com.exercise.model.Song;
import com.exercise.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SongController {
    @Autowired
    private ISongService songService;

    @GetMapping("")
    public String listSong (Model model) {
        model.addAttribute("song", this.songService.songList());
        return "list";
    }

    @GetMapping(value = "/create")
    public String goCreate(Model model) {
        model.addAttribute("song", new Song());
        model.addAttribute("kindOfMusic", new String[] {"Nhạc vàng","Nhạc đỏ","Nhạc tím","Nhạc xanh"});
        return "new-song";
    }
    @PostMapping(value = "/create")
    public String createSong(@ModelAttribute Song song){
        this.songService.save(song);
        return "redirect:/";
    }
}
