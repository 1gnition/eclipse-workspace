package orip.orip;

import java.io.IOException;

import com.coremedia.iso.IsoFile;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws IOException {
		String path = "C:\\Users\\orips_000\\Downloads\\Hadoop Fundamentals LiveLessons\\02_00_Objectives.Learning objectives.mp4";
		IsoFile isoFile = new IsoFile(path);
		double lengthInSeconds = (double) isoFile.getMovieBox().getMovieHeaderBox().getDuration()
				/ isoFile.getMovieBox().getMovieHeaderBox().getTimescale();
		System.err.println(lengthInSeconds);
		isoFile.close();

	}
}
