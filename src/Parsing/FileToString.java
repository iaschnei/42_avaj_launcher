package Parsing;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;


public class FileToString {

  public static String ReadFileToString(String path) throws IOException {

    String data = "";
    data = new String(Files.readAllBytes(Paths.get(path)));
    return data;
  }

  public static ArrayList<String> StringToList(String content) {
   
    return (new ArrayList<>(Arrays.asList(content.split("\n"))));
  }
}
