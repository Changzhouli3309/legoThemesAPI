package com.example.legoThemesAPI.service;

import com.example.legoThemesAPI.entity.LegoTheme;

import java.util.List;

public interface LegoThemeService {
    List<LegoTheme> findAll();

    List<LegoTheme> findBySearchWord(String word);

    LegoTheme findById(int id);

    List<LegoTheme> findByParentId(int parentId);

    List<LegoTheme> findByNameStartingWith(String name);
}
