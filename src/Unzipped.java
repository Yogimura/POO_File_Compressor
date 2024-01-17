import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

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

        return wordrepsmap;
    }

    public void printMap(HashMap<String, Integer> set){
        for(String key: set.keySet()){
            System.out.println(key + " = " + set.get(key));
        }
    }

    public void countReps(HashMap<String, Integer> set, String[] wset){
        for (String word : wset) {
            if (set.containsKey(word)) {
                set.replace(word, set.get(word) + 1);
            } else {
                set.put(word, 1);
            }
        }
    }

    public void deleteNonrepsWords(HashMap<String, Integer> set){
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
    public Zipped IOzip(File_Info ID) {
        return null;
    }
}
