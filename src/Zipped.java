import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
//TODO in scope documentation
/**
 * This class represents a Zipped file. it implements the {@link Izipper} interface to zip files.
 * */
public class Zipped extends AFile implements Izipper<Unzipped, HashMap<String, Character>>{
    /**
     * Each word of the file´s content has a related sign.
     * */
    HashMap<String, Character> PositionMap;

    /**
     * This constructor create a {@link Zipped} file from a path, and call {@link FileManagement#getWordmap(String)} to initialize {@link Zipped#PositionMap}.
     * @param path the path of the file.
     * */
    public Zipped(String path) throws FileNotFoundException {
        super(path);
        PositionMap = FileManagement.getWordmap(content);
    }

    /**
     * This  constructor create a {@link Zipped} file from an {@link Unzipped} file using {@link Izipper#IOzip}.
     * @param ID this is and instance of {@link File_Info} that contains the necessary data to create a Zipped file from scratch.
     * @param content this is the new content of the new {@link Zipped} file.
     * @param signmap this is the new {@link Zipped#PositionMap} of the class.
     * */
    public Zipped(File_Info ID, String content, HashMap<String, Character> signmap) throws IOException {
        super(ID, content);
        PositionMap = new HashMap<>(signmap);
    }

    /**
     * This Override the {@link Izipper#IOzip} to Unzip Zipped files.
     * */
    @Override
    public Unzipped IOzip(File_Info ID, HashMap<String, Character> wordmap) throws IOException {
        String content = this.content;

        ArrayList<String> palabras = new ArrayList<>(wordmap.keySet());

        for(int i = 0; i < wordmap.size(); i++){
            content = content.replaceAll(wordmap.get(palabras.get(i)).toString(), palabras.get(i));
        }
        String path = FileManagement.OutDir + ID.name();
        File_Info resultdata = new File_Info(new File(path), ID.name(), path);
        System.out.println(resultdata);
        return new Unzipped(resultdata, content);
    }
}