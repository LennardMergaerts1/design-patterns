package be.ucll.crafsmanship.command.gamecontroller;

public class CircleButtonCommand implements Command {
    private final Receiver receiver;

    public CircleButtonCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.actionCircle();
    }

    @Override
    public void undo() {
        System.out.println("Undo: Circle button action (Crouch)");
    }
}
