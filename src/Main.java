import java.util.*;

public class Main {
    //static Scanner lector = new Scanner(System.in);

    public static ArrayList<String> getRepsWords(String[] base){
        String card;
        ArrayList<String> repwords = new ArrayList<>();

        for(int i = 0; i < base.length; i++){
            card = base[i];
            for(int o = i+1; o < base.length; o++){
                if(base[o].equals(card) && !repwords.contains(card)){
                    repwords.add(card);
                    break;
                }
            }
        }

        return repwords;
    }

    public static String[] wordsreplacement(String[] words, ArrayList<String> reps){

        String[] chars = new String[] {"!", "@", "#", "$", "%", "^", "&", "*", "(", ")"};
        String card = "";
        LinkedList<String> repspile = new LinkedList<>(reps);

        for(int i = 0; i < reps.size(); i++){
            card = reps.get(i);
            for(int o = 0; o < words.length; o++){
                if(words[o].equals(card)){
                    if(repspile.contains(card)){
                        repspile.poll();
                    }else{
                        words[o] = chars[i];
                    }
                }
            }
        }

        return words;
    }

    public static void main(String[] args) {
        String text;
        String result;
        String[] words;
        ArrayList<String> repswords;


        text = "Pedro Almanzar del orbe porta un orbe cuyo propietario era el abuelo de su abuelo Almanzar del orbe";

        System.out.println(text);

        result = text;
        words = text.split(" ");

        repswords = new ArrayList<>(getRepsWords(words));
        words = wordsreplacement(words, repswords);


        result = String.join(" ", words);



        System.out.println(result);
    }
}