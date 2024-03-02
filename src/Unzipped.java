import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
//TODO in scope documentation

/**
 * This class represents an Unzipped file. it implements the {@link Izipper} interface to zip files.
 * */
public class Unzipped extends AFile implements Izipper<Zipped, HashMap<String, Integer>> {
    /**
     * Each word of the file´s content represents a position in this array.
     * */
    String[] words;

    /**
     * This constructor create an {@link Unzipped} file from a path, and split the content into the array {@link Unzipped#words}
     * @param path the path of the file.
     * */
    public Unzipped(String path) throws FileNotFoundException {
        super(path);
        words = content.split(" ");
    }

    /**
     * This constructor create an {@link Unzipped} file from a {@link Zipped} file using {@link Izipper#IOzip}.
     * @param ID this is an instance of {@link File_Info} that contains the necessary data to create an Unzipped file from scratch.
     * @param content this is the new content of the new {@link Unzipped} file.
     * */
    public Unzipped(File_Info ID, String content) throws IOException{
        super(ID, content);
        words = content.split(" ");
    }

    /**
     * This Override the {@link Izipper#IOzip} to Zip Unzipped files.
     * */
    @Override
    public Zipped IOzip(File_Info ID, HashMap<String, Integer> wordmap) throws IOException {
        int chars = 175;
        char set = (char) chars;
        ArrayList<String> firstIterationWord = new ArrayList<>(wordmap.keySet());
        HashMap<String, Character> signmaps = new HashMap<>();

        for(int i = 0; i < words.length; i++){
            if(wordmap.containsKey(words[i]) && firstIterationWord.contains(words[i])){
                firstIterationWord.remove(words[i]);
                signmaps.put(words[i], set);
                words[i] = words[i] + set;
                chars++;
                set = (char) chars;
            }else if(wordmap.containsKey(words[i])){
                words[i] = signmaps.get(words[i]).toString();
            }
        }
        this.content = String.join(" ", words);
        String path = FileManagement.OutDir + ID.name();
        File_Info returndata = new File_Info(new File(path), ID.name(), path);
        System.out.println(returndata);
        return new Zipped(returndata, content, signmaps);
    }
}