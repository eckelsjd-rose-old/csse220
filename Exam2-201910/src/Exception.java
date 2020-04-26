
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Exception {

	/**
	 * TODO (in general): Modify findFile (below) so that it repeatedly tries to
	 * open files beginning with V0. It then tries V1, V2, etc., until it
	 * successfully finds a file to open, or has tried all the files up to and
	 * including V99.
	 * 
	 * findFile will need to be implemented with a try-catch block to handle
	 * FileNotFoundException for all the filenames that do not exists.
	 * 
	 * Specific Details: findFile looks in the current directory for files that
	 * have the following form: dataV0.txt, dataV1.txt, dataV2.txt, ...
	 * 
	 * But the part of the filename before the character 'V' might vary, so
	 * findFile is passed a String parameter named 'filename' which contains the
	 * name of the file without the version number and without the 3 character
	 * extension. For the examples above, filename.equals("data") is true
	 * 
	 */

	public static FileReader findFile(String filename) throws FileNotFoundException {
		FileReader file = null;

		int k = 0;
		while (k < 100) {
			try {
				file = new FileReader(filename + "V" + Integer.toString(k) + ".txt");
				return file;
			} catch (FileNotFoundException e) {
				System.out.println("File: " + filename + "V" + Integer.toString(k) + ".txt" + " not found.");
				k++;
			}
		}
		return file;
	}

	// Finished implementation. All I needed to do was put the try-catch block
	// in a while loop to iterate through
	// k = 0-99. Returns the correct file if it is found, otherwise returns
	// null, which is handled in main by in
	// if statement.
	/**
	 * 
	 * NOTHING TODO HERE: The main operation below is a driver program that
	 * calls findFile This Eclipse project contains a file named 'inputV4.txt'
	 * So the call to findFile below should successfully find that file to open
	 * after trying inputV0.txt, inputV1.txt, etc., and if inputV4.txt wasn't
	 * there then findFile would try all versions from V0 up to V99
	 * 
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws IOException {
		String dataFile = "input";
		FileReader file = null;
		file = findFile(dataFile);
		if (file == null) {
			System.out.println("No files found. Sorry.");
		} else {
			System.out.println("Found file: " + file.toString());
			file.close();
		}

		// I added an if statement in case of no file being found when k = 0-99.
	}

}
