package com.almasb.fxhub;

// Adapted from https://mkyong.com/java/java-how-to-run-windows-bat-file/

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Almas Baimagambetov (almaslvl@gmail.com)
 */
public class AppRunner {

    /**
     *
     * @param exeFile on Windows, smth.bat
     */
    public static void run(File exeFile) {
        ProcessBuilder processBuilder = new ProcessBuilder("C:\\Users\\mkyong\\hello.bat");

        //Process process = Runtime.getRuntime().exec(
        //            "cmd /c hello.bat", null, new File("C:\\Users\\mkyong\\"));

        try {
            Process process = processBuilder.start();

            StringBuilder output = new StringBuilder();

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line + "\n");
            }

            int exitVal = process.waitFor();
            if (exitVal == 0) {
                System.out.println(output);

                System.out.println("Normal exit");

            } else {
                System.out.println("Not Normal exit");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}