import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.nio.file.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    static Scanner lector = new Scanner(System.in);
    public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException {
        System.out.println("Bienvenido al sistema de compresion de archivos");
        System.out.println("Todos los archivos que se encuentren dentro de esta carpeta se comprimiran o de descomprimiran segun los archivos esten compresos o no.");
        System.out.println("Quiere usted proceder?\n1. Si\n2. No\n0. Salir");
        int sl = -1;
        sl = verifyInput(sl, 0, 2);
        ArrayList<AFile> Files = new ArrayList<>();

        getFoldersFiles(Paths.get("Fileproves")).forEach(File -> {
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
        Files.sort((FileA, FileB) ->FileA.getClass().getSimpleName().toString().compareTo(FileB.getClass().getSimpleName().toString()));
        Files.forEach(f -> System.out.println(f.carry + ":" + f.getClass()));
    }

    public static ArrayList<String> getFoldersFiles(Path path) throws IOException{
        ArrayList<String> files = new ArrayList<>();

        try(Stream<Path> filepath = Files.walk(path)){
            filepath.forEach(Path -> files.add(Path.toString()));
        }catch (IOException ex){
            System.out.println("No existe");
        }
        files.remove(0);
        return files;
    }

    public static void cleanScreen(long milis) throws InterruptedException{
        Thread.sleep(milis);
        System.out.println("\033[H\033[2J");
        System.out.flush();
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