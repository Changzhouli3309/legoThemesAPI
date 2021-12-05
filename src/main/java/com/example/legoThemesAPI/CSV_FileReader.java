package com.example.legoThemesAPI;

import com.example.legoThemesAPI.entity.LegoTheme;
import com.example.legoThemesAPI.repository.LegoThemeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

@Component
@Transactional
public class CSV_FileReader implements CommandLineRunner {

    private final LegoThemeRepo legoThemeRepo;

    @Autowired
    public CSV_FileReader(LegoThemeRepo legoThemeRepo) {
        this.legoThemeRepo = legoThemeRepo;
    }

    @Override
    public void run(String... args) {

        String csvFilePath = "themes.csv";

        try (Scanner scanner = new Scanner(new File(csvFilePath), StandardCharsets.UTF_8);){

            scanner.nextLine(); // skip header line

            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(",");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                int parent_id = data.length == 3 ? Integer.parseInt(data[2]) : 0;

                legoThemeRepo.save(new LegoTheme(id,name,parent_id));
            }

        }catch (IOException | NumberFormatException e){
            System.err.println(e);
        }
    }
}
