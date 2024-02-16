import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Zipped extends AFile implements Izipper<Unzipped>{
    HashMap<String, Character> PositionMap;
    public Zipped(String path) throws FileNotFoundException {
        super(path);
        PositionMap = FileManagement.getWordmap(content);
    }

    public Zipped(File_Info ID, String content, HashMap<String, Character> signmap) throws IOException {
        super(ID, content);
        PositionMap = new HashMap<>(signmap);
    }
    @Override
    public Unzipped IOzip(File_Info ID, HashMap<String, Integer> wordmap) throws FileNotFoundException {

        return new Unzipped(null);
    }
}