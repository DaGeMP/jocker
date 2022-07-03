package com.dagework.jocker;

public class GetImagesCommand implements Command {
    private final CommandExecutor commandExecutor = new CommandExecutor();

    @Override
    public void execute() {
        this.commandExecutor.execute("docker images");
    }
}
