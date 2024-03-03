import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
//TODO in scope documentation
/**
 * This class extends {@link Thread}, This unzips all the {@link Zipped} Files.
 * */
public class ZippedThread extends Thread{
    /**
     * The {@link ArrayList} of {@link Zipped} files.
     * */
    ArrayList<Zipped> files;
    /**
     * The {@link ArrayList} where the new {@link Unzipped} files will be.
     * */
    static ArrayList<Unzipped> IOfiles = new ArrayList<>();
    /**
     * This constructor initialize {@link ZippedThread#files}
     * @param set the {@link ArrayList} of {@link Zipped} files.
     * */
    public ZippedThread(ArrayList<Zipped> set){
        this.files = new ArrayList<>(set);
    }
    /**
     * This override of {@link Thread#run()} use {@link Zipped#IOzip(File_Info, HashMap)} to unzip all the files.
     * */
    @Override
    public void run() {
        for(Zipped go: files){
            try {
                IOfiles.add(go.IOzip(go.carry, FileManagement.getWordmap(go.content)));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}