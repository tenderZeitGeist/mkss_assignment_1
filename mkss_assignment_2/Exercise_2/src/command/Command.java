package command;

import remotecontrol.IRemoteControl;

public abstract class Command {
    protected IRemoteControl remoteControl;

    public Command(IRemoteControl remoteControl) {
        this.remoteControl = remoteControl;
    }

    abstract public void execute();
}
