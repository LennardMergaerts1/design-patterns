package be.ucll.crafsmanship.command.gamecontroller;

import java.util.Stack;

public class PS5Controller {
    private Command crossButton;
    private Command triangleButton;
    private Command squareButton;
    private Command circleButton;
    private Stack<Command> commandHistory = new Stack<>();

    public void setCrossButton(Command command) {
        this.crossButton = command;
    }

    public void setTriangleButton(Command command) {
        this.triangleButton = command;
    }

    public void setSquareButton(Command command) {
        this.squareButton = command;
    }

    public void setCircleButton(Command command) {
        this.circleButton = command;
    }

    public void pressCross() {
        if (crossButton != null) {
            crossButton.execute();
            commandHistory.push(crossButton);
        }
    }

    public void pressTriangle() {
        if (triangleButton != null) {
            triangleButton.execute();
            commandHistory.push(triangleButton);
        }
    }

    public void pressSquare() {
        if (squareButton != null) {
            squareButton.execute();
            commandHistory.push(squareButton);
        }
    }

    public void pressCircle() {
        if (circleButton != null) {
            circleButton.execute();
            commandHistory.push(circleButton);
        }
    }

    public void undoLastAction() {
        if (!commandHistory.isEmpty()) {
            Command lastCommand = commandHistory.pop();
            lastCommand.undo();
        } else {
            System.out.println("No action to undo");
        }
    }
}
