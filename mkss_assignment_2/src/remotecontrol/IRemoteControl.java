package remotecontrol;

/**
 * Interface for a generic remote control.
 */
public interface IRemoteControl {

    // TODO: Method for configuration of action buttons

    /**
     * The action button was pressed.
     * Depending on its status, it will execute an activate or deactivate action.
     *
     * @param no The number of the button.
     */
    public void actionButtonPressed(int no);

    /**
     * The undo button was pressed.
     * It will undo the previous action.
     */
    public void undoButtonPressed();
}
