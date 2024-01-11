import java.io.File;
abstract class AFile {

    protected File file;
    protected String content;
    protected long size;
    protected String name;
    protected String path;
    AFile(String Path){
        this.setPath(Path);
        this.setFile(new File(this.getPath()));
        this.setName(getFile().getName());
        this.setSize(getFile().length());
        this.setContent(FileManagement.Read_Content(this.getFile()));
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
