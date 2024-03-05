import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
/**
 * This class extends {@link Thread}, This Zip all the {@link Unzipped} Files.
 * */
public class UnzippedThread extends Thread{
    /**
     * The {@link ArrayList} of {@link Unzipped} files.
     * */
    ArrayList<Unzipped> files;

    /**
     * The {@link ArrayList} where the new {@link Zipped} files will be.
     * */
    static ArrayList<Zipped> IOfiles = new ArrayList<>();

    /**
     * This constructor initialize {@link UnzippedThread#files}
     * @param set the {@link ArrayList} of {@link Unzipped} files.
     * */
    public UnzippedThread(ArrayList<Unzipped> set){
        this.files = new ArrayList<>(set);
    }

    /**
     * This override of {@link Thread#run()} use {@link Unzipped#IOzip(File_Info, HashMap)} to Zip all the files.
     * */
    @Override
    public void run() {
        for(Unzipped go: files){
            try {
                IOfiles.add(go.IOzip(go.carry, new FileManagement(go).getReps()));
            } catch (IOException e) {
                System.out.println("Hubo un problema");
            }
        }
    }
}