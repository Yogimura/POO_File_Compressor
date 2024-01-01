import java.util.ArrayList;

public class Zipped extends File{

    String[] words;
    ArrayList<String> reps;
    public Zipped(String content) {
        super(content);
        this.words = getWords(content);
        this.reps = new ArrayList<>(getReps(this.words));
    }

    @Override
    public String[] getWords(String content) {
        return content.split(" ");
    }

    @Override
    public ArrayList<String> getReps(String[] words) {
        String card;
        ArrayList<String> repwords = new ArrayList<>();

        for(int i = 0; i < words.length; i++){
            card = words[i];
            for(int o = i+1; o < words.length; o++){
                if(words[o].equals(card) && !repwords.contains(card)){
                    repwords.add(card);
                    break;
                }
            }
        }
        return repwords;
    }
}