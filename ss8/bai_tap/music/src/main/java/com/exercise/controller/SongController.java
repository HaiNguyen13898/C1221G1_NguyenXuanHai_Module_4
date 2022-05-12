package com.exercise.controller;

import com.exercise.dto.SongDto;
import com.exercise.model.Song;
import com.exercise.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/song")
public class SongController {
    @Autowired
    private ISongService songService;

    @GetMapping("")
    public String listSong(Model model) {
        model.addAttribute("song", this.songService.findAll());
        return "list";
    }

    @GetMapping(value = "/create")
    public String goCreate(Model model) {
        model.addAttribute("songDto", new SongDto());
        return "/create";
    }

    @PostMapping(value = "/save")
    public String createSong(@ModelAttribute @Validated SongDto songDto, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return "/create";
        } else {
            Song song = new Song();
            BeanUtils.copyProperties(songDto, song);
            this.songService.save(song);
            return "redirect:/song";
        }
    }

        @GetMapping("/delete")
        public String deleteForm(@RequestParam int id) {
            Song song = songService.findById(id);
            songService.remove(song);
            return "redirect:/song";
        }


}
