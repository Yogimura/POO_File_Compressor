import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class FileManagement {

    static FileWriter replacer;
    static Scanner reader;

    public static String Read_Content(File rfile) {
        StringBuilder file_content = new StringBuilder();
        try(Scanner scanner = reader = new Scanner(rfile)){
                while(reader.hasNextLine()){
                    file_content.append(reader.nextLine()).append("\n");
                }
        }catch (FileNotFoundException ex){
            System.out.println(ex.toString());
        }

        return file_content.toString();
    }

}
