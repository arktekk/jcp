package solution.filehandling.persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public interface PersistableToTextFile<T> {
	public T    readFromTextFile(BufferedReader reader) throws IOException;
	public void writeToTextFile(BufferedWriter writer, T object) throws IOException;
}
