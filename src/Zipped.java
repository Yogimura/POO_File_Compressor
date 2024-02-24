import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Zipped extends AFile implements Izipper<Unzipped, HashMap<String, Character>>{
    HashMap<String, Character> PositionMap;
    public Zipped(String path) throws FileNotFoundException {
        super(path);
        PositionMap = FileManagement.getWordmap(content);
    }

    public Zipped(File_Info ID, String content, HashMap<String, Character> signmap) throws IOException {
        super(ID, content);
        PositionMap = new HashMap<>(signmap);
    }
    @Override
    public Unzipped IOzip(File_Info ID, HashMap<String, Character> wordmap) throws IOException {
        String content = this.content;

        ArrayList<String> palabras = new ArrayList<>(wordmap.keySet());

        for(int i = 0; i < wordmap.size(); i++){
            content = content.replaceAll(wordmap.get(palabras.get(i)).toString(), palabras.get(i));
        }
        String path = "Fileresult\\"+ID.name();
        File_Info resultdata = new File_Info(new File(path), ID.name(), path);
        return new Unzipped(resultdata, content);
    }
}