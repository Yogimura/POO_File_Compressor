import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

public class Zipped extends AFile implements Izipper<Unzipped>{
    HashMap<String, Integer> PositionMap;
    public Zipped(String content) throws FileNotFoundException {
        super(content);
    }

    @Override
    public Unzipped IOzip(File_Info ID) {
        return null;
    }
}