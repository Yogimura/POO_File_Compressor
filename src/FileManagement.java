import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
//TODO in scope documentation
/**
 * This class have the duty of manipulate refine the files and their contents.
 * */
public class FileManagement {
    /**
     * This static values represents the Directory where the file is, and the Directory where his {@code IOzip} version will be.
     * */
    public static String InDir, OutDir;

    /**
     * This is an instance of {@link File} class. It's used to manage some info of the real file.
     * */
    private File file;

    /**
     * This is an instance of {@link AFile} class. It´s used to manage some info of the abstract file.
     * */
    private AFile afile;

    /**
     * Base constructor, it receives a {@link File} to be used by the instance of the class.
     * */
    public FileManagement(File set){
        file = set;
    }
    /**
     * Base constructor, it receives a {@link AFile} to be used by the instance of the class.
     * */
    public FileManagement(AFile set){
        afile = set;
    }

    /**
     * Read the content of the {@link File} instance of this object.
     * @return the content of a file.
     * */
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

    /**
     * write text to a real file.
     * @param content text to be written.
     * */

    public void Write_Content(String content) {
        try(FileWriter replacer =  new FileWriter(file.getPath())){
            replacer.write(content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * delete the linejumps and the words with no reps in the file's text.
     * @param set A HashMap, the key is the word and the value is the number of times that is repeated in the file's text
     * */
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
    /**
     * This count the number of reps of a word in a String.
     * @param set is the instance of the return object itself.
     * @param wordset this String array contains each word of the file's content.
    * */
    static public void countReps(HashMap<String, Integer> set, String[] wordset){
        for (String word : wordset) {
            if (set.containsKey(word)) {
                set.replace(word, set.get(word) + 1);
            } else {
                set.put(word, 1);
            }
        }
    }

    /**
     * Get the map of reps of a {@link Unzipped} file.
     * @return Hashmap, the key is the word and the value is the number of times that a word appear on the text.
     * */
    public HashMap<String, Integer> getReps(){
        String[] words;
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

        return wordrepsmap;
    }

    /**
     * This get each word and his related character on a {@link Zipped} instance.
     * @param content the text of the {@link Zipped} file.
     * @return HashMap, where the key is the word and the value is the related character.
     * */
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
                }else if(!Wordmap.containsValue(pchar)){
                    if(pchar == cchar + 1){
                        Wordmap.put(pword, pchar);
                        cchar = pchar;
                    }
                }
            }
        }
        return Wordmap;
    }
}