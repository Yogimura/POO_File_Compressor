import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class FileManagement {
    String name;
    int length;
    File content;
    FileWriter replacer;
    Scanner getter;
    String URL;

    public FileManagement(String nombre){
        this.URL = gURL(nombre);
        this.content = new File(this.URL);
    }

    public FileManagement(){

    }

    public String gURL(String nombre){
        return "\\Fileproves\\" + nombre + ".txt";
    }

}
