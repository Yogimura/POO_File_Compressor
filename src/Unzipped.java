import java.util.ArrayList;

public class Unzipped extends File{

    public Unzipped(String content) {
        super(content);
    }

    @Override
    public String[] getWords(String content) {
        return new String[0];
    }

    @Override
    public ArrayList<String> getReps(String[] words) {
        return null;
    }
}
