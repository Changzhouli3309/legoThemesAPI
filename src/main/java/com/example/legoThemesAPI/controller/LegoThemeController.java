package com.example.legoThemesAPI.controller;

import com.example.legoThemesAPI.entity.LegoTheme;
import com.example.legoThemesAPI.service.LegoThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class LegoThemeController {

    @Autowired
    private LegoThemeService legoThemeService;

    @GetMapping("/leogotheme")
    public ResponseEntity<List<LegoTheme>> getAll() {
        return ResponseEntity.ok(legoThemeService.findAll());
    }

    @GetMapping("/leogotheme/{id}")
    public ResponseEntity<LegoTheme> getLegoThemeById(@PathVariable("id") int id) {
        LegoTheme legoTheme = legoThemeService.findById(id);
        if (legoTheme == null) {
            ResponseEntity.notFound();
        }
        return ResponseEntity.ok(legoTheme);
    }

    @GetMapping("/leogotheme/search/{word}")
    public ResponseEntity<List<LegoTheme>> getResult(@PathVariable("word") String word) {
        return ResponseEntity.ok(legoThemeService.findBySearchWord(word));
    }
}
