package be.ucll.crafsmanship.command.gamecontroller;

public class SquareButtonCommand implements Command {
    private final Receiver receiver;

    public SquareButtonCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.actionSquare();
    }

    @Override
    public void undo() {
        System.out.println("Undo: Square button action (Use weapon)");
    }
}
