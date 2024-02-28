import java.io.FileNotFoundException;
import java.util.ArrayList;
/**
 * This record process raw lists and return a tuple of two classified lists.
 * @param a is a list of {@link Zipped}.
 * @param b is a list of {@link Unzipped}.
 * */
public record SortedFiles(ArrayList<Zipped> a, ArrayList<Unzipped> b){
    /**
     * create the instances of the files and classified then in base of his extension in {@link Zipped} or {@link Unzipped}.
     * @param Files is the raw list of files.
     * @return a {@link SortedFiles} record, which contains both lists of files.
     * */
    public static SortedFiles getAorderfiles(ArrayList<String> Files) {
        ArrayList<Zipped> ZFiles = new ArrayList<>();
        ArrayList<Unzipped> UFiles = new ArrayList<>();
        Files.forEach(File -> {
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
}
