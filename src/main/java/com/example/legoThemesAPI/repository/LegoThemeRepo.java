package com.example.legoThemesAPI.repository;

import com.example.legoThemesAPI.entity.LegoTheme;
import org.springframework.data.repository.CrudRepository;

public interface LegoThemeRepo extends CrudRepository<LegoTheme, Integer> {
}
