import java.util.ArrayList;
import java.util.HashMap;

abstract class File implements iPairs {
    String content;
    //HashMap<Integer, String>
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public File(String content){
        this.content = content;
    }

    public abstract String[] getWords(String content);

    public abstract ArrayList<String> getReps(String[] words);

}
