package com.dagework.jocker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CommandExecutor {

    void execute(String command) {
        try {
            Process process = Runtime.getRuntime().exec(command);
            logInputStream(process.getErrorStream());
            logInputStream(process.getInputStream());
        } catch (IOException e) {
            throw new CommandExecutionException("Command " + command + " failed.", e);
        }
    }

    private void logInputStream(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
        bufferedReader.close();
    }

}
