import remotecontrol.RemoteControl;

/**
 * Main for testing the functionality
 */
public class Main {
	public static void main(String[] args) {
		RemoteControl mediaPlayerRemote = new RemoteControl();

//		Button powerButton = new Button(new ActiveStateCommand(mediaPlayerRemote));
//		Button playButton = new Button(new PlayStateCommand(mediaPlayerRemote));
//		Button cycleButton = new Button(new CycleStateCommand(mediaPlayerRemote));
		mediaPlayerRemote.configureButtonPresses();

		// TODO: configure the remote controls for the media player remote

		// TODO: test the functionality by pressing different buttons similar to below
		mediaPlayerRemote.actionButtonPressed(0);
		mediaPlayerRemote.actionButtonPressed(1);
		mediaPlayerRemote.actionButtonPressed(2);
		mediaPlayerRemote.undoButtonPressed();

		mediaPlayerRemote.actionButtonPressed(1);
		mediaPlayerRemote.undoButtonPressed();

		mediaPlayerRemote.actionButtonPressed(0);
	}
}

