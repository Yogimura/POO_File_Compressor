import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileManagement {

    private final File file;

    public FileManagement(File set){
        file = set;
    }

    public String Read_Content() throws FileNotFoundException {
        StringBuilder file_content = new StringBuilder();
        Scanner reader;
        try(Scanner _ = reader = new Scanner(file)){
                while(reader.hasNextLine()){
                    file_content.append(reader.nextLine()).append(" \n ");
                }
        }
        return file_content.toString();
    }

    public void Write_Content(String content) {
        FileWriter replacer;
        try(FileWriter _ = replacer = new FileWriter(file.getPath())){
            replacer.write(content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void Zip(){

    }

    public void Unzip(){

    }
}
