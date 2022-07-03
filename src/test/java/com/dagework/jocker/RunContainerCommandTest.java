package com.dagework.jocker;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class RunContainerCommandTest {

    @Test
    public void execute() {
        Map<String, String> envVars = new HashMap<>() {{
            put("MYSQL_DATABASE", "dev_db");
            put("MYSQL_ROOT_PASSWORD", "root");
        }};
        RunContainerCommand runContainerCommand = new RunContainerCommandBuilder()
                .withImageName("mysql")
                .withPortsBinding("3306:3306")
                .withEnvironmentVariables(envVars)
                .build();
        runContainerCommand.execute();
    }
}
