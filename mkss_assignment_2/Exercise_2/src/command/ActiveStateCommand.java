package command;

import remotecontrol.IRemoteControl;

public class ActiveStateCommand extends Command {
    public ActiveStateCommand(IRemoteControl remoteControl) {
        super(remoteControl);
    }

    public void execute() {
        remoteControl.actionButtonPressed(0);
    }
}
