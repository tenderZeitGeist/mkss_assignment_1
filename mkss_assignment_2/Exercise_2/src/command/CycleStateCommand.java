package command;

import remotecontrol.IRemoteControl;

public class CycleStateCommand extends Command {

    public CycleStateCommand(IRemoteControl remoteControl) {
        super(remoteControl);
    }

    public void execute() {
        remoteControl.actionButtonPressed(1);
        // remoteControl.handle
    }
}