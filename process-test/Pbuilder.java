import java.util.*;
import java.io.*;

class Pbuilder {
	public static void main(String[] args) throws IOException, InterruptedException {
		List<String> list = new ArrayList<String>();
		list.add("/Users/mohit.agarwal/workspace/java-learn/process-test/prop");

		// creating the process
		ProcessBuilder build = new ProcessBuilder(list);

		// setting the directory
		build.directory(new File("/Users/mohit.agarwal/workspace/java-learn/process-test/"));

		// checking the directory, on which currently working on
		System.out.println("directory: " + build.directory());

		// startinf the process
		Process process = build.start();

		System.out.println("Started the process");
		int count = 0;
		while (count < 10) {
			count++;
			System.out.println("Sleeping " + count);
			Thread.sleep(1000);
		}

		System.out.println("Process destruction happening");
		process.destroy();
	}
}