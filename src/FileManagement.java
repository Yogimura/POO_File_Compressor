import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileManagement {

    private File file;
    private FileWriter replacer;
    private Scanner reader;

    public FileManagement(File set){
        file = set;
    }

    public String Read_Content() {
        StringBuilder file_content = new StringBuilder();
        try(Scanner scanner = reader = new Scanner(file)){
                while(reader.hasNextLine()){
                    file_content.append(reader.nextLine()).append("\n");
                }
        }catch (FileNotFoundException ex){
            System.out.println(ex.toString());
        }

        return file_content.toString();
    }

    public void Write_Content(String content){
        try(FileWriter Filewriter = replacer = new FileWriter(file.getPath())){
            replacer.write(content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
