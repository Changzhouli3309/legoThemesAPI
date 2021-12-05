package com.example.legoThemesAPI.service;

import com.example.legoThemesAPI.entity.LegoTheme;
import com.example.legoThemesAPI.repository.LegoThemeRepo;
import com.example.legoThemesAPI.util.Checker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LegoThemeServiceImp implements LegoThemeService {

    @Autowired
    private LegoThemeRepo legoThemeRepo;

    @Override
    public List<LegoTheme> findAll(){
        return (List<LegoTheme>) legoThemeRepo.findAll();
    }

    @Override
    public List<LegoTheme> findBySearchWord(String word){
        List<LegoTheme> returnList = new ArrayList<>();

        if(Checker.isAllowedNumber(word)){
            int n = Integer.parseInt(word);
            LegoTheme legoTheme = findById(n);

            if (legoTheme != null){
                returnList.add(legoTheme);

                returnList.addAll(findByParentId(n));

            }

            return returnList;
        }

        returnList.addAll(findByNameStartingWith(word));

        return returnList;
    }

    @Override
    public LegoTheme findById(int id){
        return legoThemeRepo.findById(id).orElse(null);
    }

    @Override
    public List<LegoTheme> findByParentId(int parentId){
        return legoThemeRepo.findByParentId(parentId);
    }

    @Override
    public List<LegoTheme> findByNameStartingWith(String name){
        return legoThemeRepo.findByNameStartingWith(name);
    }
}
