/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package createcdnaproteinfiles;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * creates a hashmap from a file that contains protein id's and conversion factors.
 * @author Rutger
 */
public class CreateProteinList {
    
    private HashMap proteinMap = new HashMap();
    public CreateProteinList(){
        readFile();
    }
    /**
     * reads the file and creates a hashmap based on it.
     */
    private void readFile(){
        //path to the file with the protein id's and the conversion factors.
        Path file =  Paths.get("C:\\Users\\Rutger\\Desktop\\conversionfactors.txt");
        Charset charset = Charset.forName("US-ASCII");
        try(BufferedReader reader = Files.newBufferedReader(file, charset)){
            String line;
            while((line = reader.readLine()) != null){
                String[] splittedLine = line.split("\t");
                proteinMap.put(splittedLine[0], splittedLine[1]);
            }
        }catch (IOException x){
            System.err.format("IOException: %s%n",x);
        }
    }
    /**
     * returns the proteinMap.
     * @return proteinMap.
     */
    public HashMap getProteinList() {
        return proteinMap;
    }
}
