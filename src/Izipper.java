import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

public interface Izipper<T> {
    T IOzip(File_Info ID, HashMap<String, Integer> wordmap) throws IOException;
}
