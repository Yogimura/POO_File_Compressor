import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Unzipped extends AFile implements Izipper<Zipped> {
    String[] words;

    public Unzipped(String path) throws FileNotFoundException {
        super(path);
        words = content.split(" ");
    }

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
        return new Zipped(ID, content, signmaps);
    }
}
