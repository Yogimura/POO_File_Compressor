import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
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
                ArrayList<AFile> Files = getAorderfiles("Fileproves");
            }
            case 2 -> {

            }
            default -> {}
        }


    }

    public static ArrayList<AFile> getAorderfiles(String path) {
        ArrayList<AFile> Files = new ArrayList<>();
        getFoldersFiles(Paths.get(path)).forEach(File -> {
            if(File.endsWith(".ziped")){
                try{
                    Files.add(new Zipped(File));
                }catch (FileNotFoundException ex){
                    System.out.println("Archivo no se encuentra");
                }
            }else{
                try{
                    Files.add(new Unzipped(File));
                }catch (FileNotFoundException ex){
                    System.out.println("Archivo no se encuentra");
                }
            }
        });
        Files.sort(Comparator.comparing(FileA -> FileA.getClass().getSimpleName()));
        Files.forEach(f -> System.out.println(f.carry + ":" + f.getClass()));
        return Files;
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