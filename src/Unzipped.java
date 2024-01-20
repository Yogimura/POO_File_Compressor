import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Unzipped extends AFile implements Izipper<Zipped> {
    String[] words;

    public Unzipped(String path) throws FileNotFoundException {
        super(path);
    }

    //Necesito tres datos: La palabra, las veces que se repite y en que ubicaciones lo hace;
    public HashMap<String, Integer> getReps(){
        HashMap<String, Integer> wordrepsmap = new HashMap<>();
        String cont = content;

        words = cont.split(" ");

        countReps(wordrepsmap, words);

        deleteNonrepsWords(wordrepsmap);

        printMap(wordrepsmap);

        return wordrepsmap;
    }

    public void printMap(HashMap<String, Integer> set){
        for(String key: set.keySet()){
            System.out.println(key + " = " + set.get(key));
        }
    }

    public void countReps(HashMap<String, Integer> set, String[] wordset){
        for (String word : wordset) {
            if (set.containsKey(word)) {
                set.replace(word, set.get(word) + 1);
            } else {
                set.put(word, 1);
            }
        }
    }

    public void deleteNonrepsWords(HashMap<String, Integer> set){
        set.remove("\n");
        ArrayList<String> wordco = new ArrayList<>(set.keySet());
        for(int i = 0; i < wordco.size(); i++){
            if(set.get(wordco.get(i)) <= 1){
                set.remove(wordco.get(i));
                wordco.remove(i);
                i--;
            }
        }
    }

    @Override
    public Zipped IOzip(File_Info ID, HashMap<String, Integer> wordmap) throws IOException {
        int chars = 175;
        char set = (char) chars;
        ArrayList<String> golang = new ArrayList<>(wordmap.keySet());
        HashMap<String, Character> signmaps = new HashMap<>();

        for(int i = 0; i < words.length; i++){
            if(wordmap.containsKey(words[i]) && golang.contains(words[i])){
                golang.remove(words[i]);
                signmaps.put(words[i], set);
                words[i] = words[i] + set;
                chars++;
                set = (char) chars;
            }else if(wordmap.containsKey(words[i])){
                words[i] = signmaps.get(words[i]).toString();
            }
        }

        this.content = String.join(" ", words);
        return new Zipped(ID, content);
    }
}
