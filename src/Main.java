import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.nio.file.*;
import java.util.stream.Stream;

public class Main {
    static Scanner lector = new Scanner(System.in);
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
                SortedFiles Files = getAorderfiles(FileManagement.InDir);
                ZippedThread decompress = new ZippedThread(new ArrayList<>(Files.a()));
                UnzippedThread compress = new UnzippedThread(new ArrayList<>(Files.b()));
                decompress.start();
                compress.start();
            }
            case 2 -> System.exit(0);
        }
    }

    public static SortedFiles getAorderfiles(String path) {
        ArrayList<Zipped> ZFiles = new ArrayList<>();
        ArrayList<Unzipped> UFiles = new ArrayList<>();
        getFoldersFiles(Paths.get(path)).forEach(File -> {
            if(File.endsWith(".ziped")){
                try{
                    ZFiles.add(new Zipped(File));
                }catch (FileNotFoundException ex){
                    System.out.println("Archivo no se encuentra");
                }
            }else{
                try{
                    UFiles.add(new Unzipped(File));
                }catch (FileNotFoundException ex){
                    System.out.println("Archivo no se encuentra");
                }
            }
        });
        return new SortedFiles(ZFiles, UFiles);
    }

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