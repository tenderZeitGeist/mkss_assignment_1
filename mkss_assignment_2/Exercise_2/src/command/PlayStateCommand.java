package command;

import remotecontrol.IRemoteControl;

public class PlayStateCommand extends Command {
    public PlayStateCommand(IRemoteControl remoteControl) {
        super(remoteControl);
    }

    public void execute() {
        remoteControl.actionButtonPressed(2);
    }
}
