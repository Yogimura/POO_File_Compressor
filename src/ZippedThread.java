import java.io.IOException;
import java.util.ArrayList;

public class ZippedThread extends Thread{
    ArrayList<Zipped> files;
    static ArrayList<Unzipped> IOfiles;
    public ZippedThread(ArrayList<Zipped> set){
        this.files = new ArrayList<>(set);
    }
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
