import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
public abstract class AFile {
    public File_Info carry;
    protected File file;
    protected String content;
    protected long size;
    protected String name;
    protected String path;
    AFile(String Path) throws FileNotFoundException {
        setPath(Path);
        setFile(new File(path));
        setName(file.getName());
        setSize(file.length());
        setContent(new FileManagement(file).Read_Content());
        carry = new File_Info(file, name, path);
    }

    AFile(File_Info ID, String content) throws IOException {
        if(this instanceof Zipped){
            setFile(new File(ID.path()+ ".ziped"));
        }else {
            setFile(new File(ID.path().substring(0, ID.path().length() - 6)));
        }
        setPath(file.getPath());
        setName(file.getName());
        setContent(content);
        if(file.createNewFile()){
            new FileManagement(file).Write_Content(getContent());
        }else{
            System.out.println("El archivo ya existe");
        }
        setSize(file.length());

        carry = new File_Info(ID.file(), ID.name(), ID.path());
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getContent() {
        return content;
    }

    public long getSize() {
        return size;
    }
}

