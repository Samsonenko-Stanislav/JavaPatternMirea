package ru.mirea.Task12;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

@Component
public class FileHandler {
    private final String filenameIn = "src/main/resources/in.txt";
    private final String filenameOut = "src/main/resources/out.txt";
    private String hash;

    File input = new File(filenameIn);
    @PostConstruct
    public void readInputFile() {
        try {

            String fileContent = getInputContent(input);
            hash = getHash(fileContent);
            FileWriter output = new FileWriter(filenameOut);
            output.write(hash);
            output.close();

        } catch (Exception exception) {
            //exception.printStackTrace();
            hash = "null";


        }
    }

    private static String getInputContent(File input) throws FileNotFoundException {
        Scanner scanner = new Scanner(input);
        StringBuilder fileContent = new StringBuilder();
        while (scanner.hasNextLine()) {
            fileContent.append(scanner.nextLine());
        }
        return fileContent.toString();
    }


    private static String getHash(String data) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] messageDigest = md.digest(data.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            return no.toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }

    @PreDestroy
    public void deleteInputFile() {
        try {
            if (hash == "null") {
                FileWriter output = new FileWriter(filenameOut);
                output.write(hash);
                output.close();
            }
            input.delete();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}