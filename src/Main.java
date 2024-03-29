import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.util.stream.Stream;
/**
 * this project aspire to compress very redundant texts using POO to manage the text processing and output.
 * @author vladimir a.k.a Yogimura
 * */
public class Main {

    /**
     * {@link Scanner} instance to read user Input.
     * */
    static Scanner lector = new Scanner(System.in);

    /**
     * main menu
     * */
    public static void main(String[] args) {
        System.out.println("Bienvenido al sistema de compresion de archivos");
        System.out.println("Todos los archivos que se encuentren dentro de esta carpeta se comprimiran o de descomprimiran segun los archivos esten compresos o no.");
        System.out.print("Quiere usted proceder?\n1. Si\n2. No\nEleccion: ");
        int sl = -1;
        sl = verifyInput(sl, 1, 2);
        switch (sl){
            case 1 -> {

                System.out.print("Ingrese la ruta donde estan los archivos: ");
                String Inpath = lector.next();
                System.out.print("Ingrese la ruta donde estaran los nuevos archivos: ");
                String outpath = lector.next();
                FileManagement.InDir = Inpath;
                FileManagement.OutDir = outpath;
                SortedFiles Files = SortedFiles.getAorderfiles(getFoldersFiles(Paths.get(FileManagement.InDir)));
                ZippedThread decompress = new ZippedThread(new ArrayList<>(Files.a()));
                UnzippedThread compress = new UnzippedThread(new ArrayList<>(Files.b()));
                decompress.start();
                compress.start();
            }
            case 2 -> System.exit(0);
        }
    }


    /**
     * Get all the files from a directory.
     * @param path is the where the files are.
     * @return a {@code ArrayList<String>} that contains the path of all the files in the directory.
     * */
    public static ArrayList<String> getFoldersFiles(Path path){
        ArrayList<String> files = new ArrayList<>();

        try(Stream<Path> filepath = Files.walk(path)){
            filepath.forEach(Path -> files.add(Path.toString()));
        }catch (IOException ex){
            System.out.println("No existe");
        }
        files.remove(0);
        return files;
    }

    /**
     * This function verify if a user input is in the range of options.
     * @param set is the user input.
     * @param rangeA is the min value.
     * @param rangeB is the max value.
     * @return the user options if the input fits the options, otherwise it will loop until the input fit.
     * */
    public static int verifyInput(int set, int rangeA, int rangeB){
        int i = 0;
        do {
            if(i > 0){
                System.out.println("Ingrese una opcion valida");
            }
            try {
                set = lector.nextInt();
            } catch (InputMismatchException _) {
                lector.nextLine();
            }
            i++;
        } while (set < rangeA || set > rangeB);
        return set;
    }
}