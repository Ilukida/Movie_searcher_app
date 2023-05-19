package ru.kpfu.itis.vaskina.moviesearcherapp.controller.pages;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kpfu.itis.vaskina.moviesearcherapp.dto.response.GenreResponse;
import ru.kpfu.itis.vaskina.moviesearcherapp.service.GenreService;

import java.util.UUID;

@RequiredArgsConstructor
@Controller
@RequestMapping("/genres")
public class GenrePageController {

    private final GenreService genreService;

    @GetMapping
    public String getGenresPage(Model model){
        model.addAttribute("genres", genreService.getAll(Pageable.unpaged()).getContent());
        return "genres";
    }

    @GetMapping("/{id}")
    public String getGenre(@PathVariable UUID id, Model model){
        GenreResponse genre = genreService.getById(id);
        model.addAttribute("genre", genre);
        return "mgenre";
    }
}
