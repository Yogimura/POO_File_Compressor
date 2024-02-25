import java.io.File;
/**
 * This record class is the ID of each {@link AFile} object.
 * @param file is an instance of the {@link File} class that represents the real file.
 * @param name is the name of the file, including his extension.
 * @param path is the path of the file, the folder where it will be created or already is.
 * */
public record File_Info(File file, String name, String path) {
}
