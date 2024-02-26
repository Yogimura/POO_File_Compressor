import java.io.IOException;
/**
 * this interface compress or decompress a file dependant of which object is.
 * @param <T> is the return type of the function, it would be {@link Zipped} or {@link Unzipped}.
 * @param <U> is the type of the HashMap that receive the function. It will change to a {@code HashMap<String, Integer>} if {@code <T>} is {@link Zipped} or
 * {@code HashMap<String, Character>} if {@code <T>} is {@link Unzipped}
 * */
public interface Izipper<T, U> {
    /**
     * This compress or decompress a file dependant of which object is.
     * @param ID is the info that will pass to the new instance.
     * @param wordmap is the map of word and the info of words, this info would be the number or reps or a related character.
     * */
    T IOzip(File_Info ID, U wordmap) throws IOException;
}
