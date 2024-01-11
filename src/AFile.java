import java.io.File;
abstract class AFile {

    File file;
    String content;
    long size;
    String name;
    String path;

    AFile(String Path){
        this.path = Path;
        this.file = new File(this.path);
        this.name = file.getName();
        this.size = file.length();
        this.content = FileManagement.Read_Content(this.file);
    }
}
