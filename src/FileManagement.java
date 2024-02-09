import jdk.jshell.spi.ExecutionControl;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class FileManagement implements iprint{

    private File file;
    private AFile afile;

    public FileManagement(File set){
        file = set;
    }

    public FileManagement(AFile set){
        afile = set;
    }

    public String Read_Content() throws FileNotFoundException {
        StringBuilder file_content = new StringBuilder();
        Scanner reader;
        try(Scanner _ = reader = new Scanner(file)){
                while(reader.hasNextLine()){
                    file_content.append(reader.nextLine()).append("\n");
                }
        }
        return file_content.toString();
    }

    public void Write_Content(String content) {
        FileWriter replacer;
        try(FileWriter _ = replacer = new FileWriter(file.getPath())){
            replacer.write(content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static public void deleteNonrepsWords(HashMap<String, Integer> set){
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

    static public void countReps(HashMap<String, Integer> set, String[] wordset){
        for (String word : wordset) {
            if (set.containsKey(word)) {
                set.replace(word, set.get(word) + 1);
            } else {
                set.put(word, 1);
            }
        }
    }

    public HashMap<String, Integer> getReps(String[] words){
        HashMap<String, Integer> wordrepsmap = new HashMap<>();
        String cont = afile.getContent();

        String[] lines = cont.split("\n");

        ArrayList<String> wordlist = new ArrayList<>();

        for(String line: lines){
            String[] lineseparator = line.split(" ");
            wordlist.addAll(Arrays.asList(lineseparator));
        }

        words = wordlist.toArray(new String[0]);

        countReps(wordrepsmap, words);

        deleteNonrepsWords(wordrepsmap);

        printMap(wordrepsmap);

        return wordrepsmap;
    }

    public static HashMap<String, Character> getWordmap(String content){

        HashMap<String, Character> Wordmap = new HashMap<>();
        String[] words = content.split(" ");
        char cchar = 'a';
        for(String word: words){
            if(word.length() > 1){
                char pchar = word.charAt(word.length()-1);
                String pword = word.substring(0, word.length() - 1);

                if(Wordmap.isEmpty()){
                    Wordmap.put(pword, pchar);
                    cchar = pchar;
                }else if(!Wordmap.containsKey(pchar)){
                    if(pchar == cchar + 1){
                        Wordmap.put(pword, pchar);
                        cchar = pchar;
                    }
                }
            }
        }
        return Wordmap;
    }

    public static String replaceWordmap(){
        return null;
    }

    public void printMap(HashMap set) {
        for(Object key: set.keySet()){
            System.out.println(key + " = " + set.get(key));
        }
    }
}