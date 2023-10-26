package remotecontrol;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

/**
 *  Base implementation for the remote control.
 */
public class RemoteControl implements IRemoteControl {
    public final static int NO_OF_ACTION_BUTTONS = 3;
    private boolean[] buttonStatus;

    // TODO: Data structures for the actions
    public RemoteControl() {
        buttonStatus = new boolean[NO_OF_ACTION_BUTTONS];

        // TODO: Initialize data structures for the actions
    }

    // TODO: Implement method for configuration of action buttons


    @Override
    public List<Button> configureButtonPresses() {
        // Button powerButton = new Button(new ActiveStateCommand(mediaPlayerRemote));
        // Button playButton = new Button(new PlayStateCommand(mediaPlayerRemote));
        // Button cycleButton = new Button(new CycleStateCommand(mediaPlayerRemote));
        List<Button> _list = new ArrayList<Button>();
        return _list;
    }

    /**
     * The action button was pressed.
     * Depending on its status, it will execute an activate or deactivate action.
     *
     * @param no The number of the button.
     */
    public void actionButtonPressed(int no) {
        switch(no) {
            case 0:
                handlePower();
                break;
            case 1:
                handlePlay();
                break;
            case 2:
                handleCycle();
                break;
            default:
                break;
        }
    }

    private void handlePower() {
        // TODO: check State and call correct method
    }

    private void handlePlay() {
        // TODO: check State and call correct method
    }

    private void handleCycle() {
        // TODO: check State and call correct method
    }

    /**
     * The undo button was pressed.
     * It will undo the previous action.
     */
    public void undoButtonPressed() {
        // Execute undo action
        System.out.println("Undo button pressed");
        // TODO: Execute undo action
    }
}
