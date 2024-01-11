import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class FileManagement {

    static FileWriter replacer;
    static Scanner reader;

    public static String Read_Content(File rfile) {
        String file_content = "";
        try(Scanner scanner = reader = new Scanner(rfile)){
                while(reader.hasNextLine()){
                    file_content += reader.nextLine() + "\n";
                }
        }catch (FileNotFoundException ex){
            System.out.println(ex.toString());
        }

        return file_content;
    }

}
