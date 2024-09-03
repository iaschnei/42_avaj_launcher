package Parsing;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileToString {

  public static String ReadFileToString(String path) throws IOException {

    String data = "";
    data = new String(Files.readAllBytes(Paths.get(path)));
    return data;
  }
}
