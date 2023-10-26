package remotecontrol;

import command.Command;

public class Button {
    final private Command command;

    public Button(Command command) {
        this.command = command;
    }

    public void invoke() {
        command.execute();
    }
}
