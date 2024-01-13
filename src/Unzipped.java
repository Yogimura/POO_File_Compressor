import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

public class Unzipped extends AFile {
    String[] words;

    public Unzipped(String path) throws FileNotFoundException {
        super(path);
    }

    //Necesito tres datos: La palabra, las veces que se repite y en que ubicaciones lo hace;
    public /*HashMap<String, Integer>*/ void getReps(){
        HashMap<String, Integer> wordrepsmap = new HashMap<>();
        String cont = content;
        words = cont.split(" ");

        for (String word : words) {
            if (wordrepsmap.containsKey(word)) {
                wordrepsmap.replace(word, wordrepsmap.get(word) + 1);
            } else {
                wordrepsmap.put(word, 1);
            }
        }

        System.out.println(String.join(" | ", words));
        for(String key: wordrepsmap.keySet()){
            System.out.println(key + " = " + wordrepsmap.get(key));
        }

        ArrayList<String> wordco = new ArrayList<>(wordrepsmap.keySet());

        int i = 0;
        while(i < wordco.size()){
            if(wordrepsmap.get(wordco.get(i)) <= 1){
                wordrepsmap.remove(wordco.get(i));
                wordco.remove(i);
                i = -1;
            }
            i++;
        }
        System.out.println("-------------");
        for(String key: wordrepsmap.keySet()){
            System.out.println(key + " = " + wordrepsmap.get(key));
        }

        //return wordrepsmap;
    }
}
