import java.io.IOException;
import java.util.ArrayList;
//TODO in scope documentation
//TODO general documentation
public class UnzippedThread extends Thread{
    ArrayList<Unzipped> files;
    static ArrayList<Zipped> IOfiles = new ArrayList<>();
    public UnzippedThread(ArrayList<Unzipped> set){
        this.files = new ArrayList<>(set);
    }
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
