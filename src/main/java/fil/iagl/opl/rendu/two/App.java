package fil.iagl.opl.rendu.two;

import java.io.File;

import org.apache.commons.io.FileUtils;

import spoon.Launcher;

/**
 * Hello world!
 *
 */
public class App {
  private static final String INSTRUMENT_SOURCE_FOLDER = "src/main/java/instrumenting";

  public static final String INPUT_SOURCE_FOLDER = "C:/Users/wokei/Documents/workspace-sts-3.7.1.RELEASE/commons-lang";

  public static void main(String[] args) throws Exception {
    String inputDirectory = INPUT_SOURCE_FOLDER;
    String outputDirectory = INPUT_SOURCE_FOLDER + "_instrumented";

    File inputFile = new File(inputDirectory);
    File outputFile = new File(outputDirectory);

    if (outputFile.exists()) {
      FileUtils.forceDelete(outputFile);
    }

    FileUtils.copyDirectory(inputFile, outputFile);

    String[] spoonArgs = {
      "-i", inputDirectory + "\\src\\main\\java" + ";" + INSTRUMENT_SOURCE_FOLDER,
      "-o", outputDirectory + "\\src\\main\\java",
      "-p", "fil.iagl.opl.rendu.two.processors.AddWatcherProcessor",
      "--with-imports"
    };

    Launcher.main(spoonArgs);

  }

}
