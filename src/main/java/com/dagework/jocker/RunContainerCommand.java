package com.dagework.jocker;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class RunContainerCommand implements Command {
    private final String imageName;
    private final String tag;
    private final Map<String, String> envVars;
    private final String portsBinding;
    private final CommandExecutor commandExecutor;

    RunContainerCommand(String imageName, String tag, Map<String, String> envVars, String portsBinding,
            CommandExecutor commandExecutor) {
        this.imageName = imageName;
        this.tag = tag;
        this.envVars = new HashMap<>(envVars);
        this.portsBinding = portsBinding;
        this.commandExecutor = commandExecutor;
    }

    @Override
    public void execute() {
        StringBuilder stringBuilder = new StringBuilder("docker run");
        for (Map.Entry<String, String> envVar : envVars.entrySet()) {
            stringBuilder.append(" --env ")
                    .append(envVar.getKey()).append("=").append(envVar.getValue());
        }
        Optional.ofNullable(portsBinding).ifPresent(pb -> stringBuilder.append(" -p ").append(pb));
        String command = stringBuilder.append(" ").append(imageName).append(":").append(tag).toString();
        
        this.commandExecutor.execute(command);
    }
}
