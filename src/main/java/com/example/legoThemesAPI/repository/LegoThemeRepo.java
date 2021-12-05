package com.example.legoThemesAPI.repository;

import com.example.legoThemesAPI.entity.LegoTheme;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LegoThemeRepo extends CrudRepository<LegoTheme, Integer> {

    List<LegoTheme> findByNameStartingWith(String name);

    List<LegoTheme> findByParentId(int parentId);
}
