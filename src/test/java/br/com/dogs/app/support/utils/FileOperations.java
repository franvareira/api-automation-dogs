package br.com.dogs.app.support.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import java.util.Random;

public class FileOperations {

    private static final String DIR_PATH_PROPERTIES =

            System.getProperty("user.dir") + File.separator + "src" +
                    File.separator + "test" + File.separator + "resources" + File.separator + "properties" + File.separator;

    private static final String DIR_PATH_JSON =

            System.getProperty("user.dir") + File.separator + "src" +
                    File.separator + "test" + File.separator + "resources" + File.separator + "schemas" + File.separator + "listraca.json";

    public static Properties getProperties(String fileName){

        InputStream inputStream = null;
        Properties prop = new Properties();

        try {

            File file = new File(DIR_PATH_PROPERTIES+ fileName + ".properties");
            inputStream = new FileInputStream(file);
            prop.load(inputStream);
            return prop;

        } catch (Exception e) {

            System.out.println("Passando Exception " + e.getMessage());
        }
        return prop;
    }

    private static String getRandomRaca() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        // Tipagem correta para evitar warnings
        List<String> racas = mapper.readValue(
                new File(FileOperations.DIR_PATH_JSON),
                new TypeReference<List<String>>() {}
        );

        if (racas == null || racas.isEmpty()) {
            throw new IllegalArgumentException("Lista de raças está vazia ou não foi encontrada.");
        }

        Random ran = new Random();
        String breed = racas.get(ran.nextInt(racas.size()));

        // Preserva exatamente o valor do JSON
        String nameRaca;
        if (breed.contains("-")) {
            // Divide apenas no primeiro hífen, preservando o restante se houver mais
            int idx = breed.indexOf('-');
            String part1 = breed.substring(0, idx);
            String part2 = breed.substring(idx + 1);
            nameRaca = String.format("/%s/%s", part1, part2);
        } else {
            nameRaca = String.format("/%s", breed);
        }

        return nameRaca;
    }


    public static String randomRaca() {
        try {
            return getRandomRaca();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
