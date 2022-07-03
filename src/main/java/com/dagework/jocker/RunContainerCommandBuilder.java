package com.dagework.jocker;

import java.util.HashMap;
import java.util.Map;

public class RunContainerCommandBuilder {
    private String imageName;
    private String tag;
    private Map<String, String> envVars;
    private String portsBinding;

    public RunContainerCommandBuilder() {
        this.imageName = "";
        this.tag = "latest";
        this.envVars = new HashMap<>();
        this.portsBinding = null;
    }

    public RunContainerCommandBuilder withImageName(String imageName) {
        this.imageName = imageName;
        return this;
    }

    public RunContainerCommandBuilder withTag(String tag) {
        this.tag = tag;
        return this;
    }

    public RunContainerCommandBuilder withEnvironmentVariables(Map<String, String> envVars) {
        this.envVars = envVars;
        return this;
    }

    public RunContainerCommandBuilder withPortsBinding(String portsBinding) {
        this.portsBinding = portsBinding;
        return this;
    }

    public RunContainerCommand build() {
        return new RunContainerCommand(imageName, tag, envVars, portsBinding, new CommandExecutor());
    }
}
