import java.io.File;
import java.io.FileNotFoundException;

abstract class AFile {

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

    AFile(File_Info ID, String content) throws FileNotFoundException{
        setPath(ID.path());
        setFile(ID.file());
        setName(ID.name());
        setContent(content);
        setSize(file.length());
        carry = new File_Info(file, name, path);
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

