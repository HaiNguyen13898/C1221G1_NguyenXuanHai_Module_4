package com.exercise.controller;


import com.exercise.model.Song;
import com.exercise.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class SongController {
    @Autowired
    private ISongService songService;

    @GetMapping("/songs")
    public String showList(Model model) {
        List<Song> songList = songService.findAll();
        model.addAttribute("songList", songList);
        return "/song/list";
    }

    @GetMapping(value = "/create")
    public String showCreateForm(Model model) {
        model.addAttribute("song", new Song());
        return "/song/create";
    }


    @PostMapping(value = "/save")
    public String save(@ModelAttribute Song song, RedirectAttributes redirectAttributes) {
        songService.save(song);
        redirectAttributes.addFlashAttribute("message", "Successfully added new");
        return "redirect:/songs";
    }


    @GetMapping("/edit")
    public String editForm(@RequestParam int id, Model model) {
        model.addAttribute("song", songService.findById(id));
        return "/song/edit";
    }

    @PostMapping("/update")
    public String editProduct(@ModelAttribute Song song, RedirectAttributes redirectAttributes) {
        songService.update(song);
        redirectAttributes.addFlashAttribute("message", "Successful update ");
        return "redirect:/songs";
    }


    @GetMapping("/delete")
    public String deleteForm(@RequestParam int id, RedirectAttributes redirectAttributes) {
        Song song = songService.findById(id);
        songService.remove(song);
        redirectAttributes.addFlashAttribute("message", "Successful delete ");
        return "redirect:/songs";
    }


}
