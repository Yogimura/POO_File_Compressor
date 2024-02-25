import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
/**
 * the {@code AFile} class is the representation of an abstract File.
 * it contains the fields of a general file, neither it's a {@link Zipped}
 * or a {@link Unzipped} file.
 * */
public abstract class AFile {
    /**
     * the {@code carry} its an instance of {@link File_Info}, a record. it's the ID of the class. it would be used to pass the information
     * of the class between the subclasses.
     * */
    public File_Info carry;
    /**
     * this is the {@link File} instance of {@link AFile}, this contains the real file.
     * */
    protected File file;
    /**
     * this contains the text of the {@code file}.
     * */
    protected String content;
    /**
     * this contains the size in bytes of the {@code file}.
     * */
    protected long size;
    /**
     * this contains the name of the {@code file}.
     * */
    protected String name;
    /**
     * this contains the path of the {@code file}
     * */
    protected String path;
    /**
     * this is the constructor. this receives a file path and create with it a file instance.
     * with that instance it initialize the order fields of the class.
     *
     * @param Path is the path of the {@link File} that would be the base for the {@link AFile}
     * */
    AFile(String Path) throws FileNotFoundException {
        setPath(Path);
        setFile(new File(path));
        setName(file.getName());
        setSize(file.length());
        setContent(new FileManagement(file).Read_Content());
        carry = new File_Info(file, name, path);
    }

    /**
     * This constructor is used in subclasses to switch the instance of each subclass. It means {@link Unzipped} to {@link Zipped} and viceversa.
     * That's cause it modify the extension of the new {@code file} dependently of the subclass's instance, in the process creaating a new {@code file}
     * @param ID this is the ID of the object, it contains the basis information to create the new object.
     * @param content this is the text of the new {@link File}
     * */

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
}

