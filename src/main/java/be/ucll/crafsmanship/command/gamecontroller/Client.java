package be.ucll.crafsmanship.command.gamecontroller;

public class Client {
    public static void main(String[] args) {
        Receiver receiver = new Receiver();

        Command crossCommand = new CrossButtonCommand(receiver);
        Command triangleCommand = new TriangleButtonCommand(receiver);
        Command squareCommand = new SquareButtonCommand(receiver);
        Command circleCommand = new CircleButtonCommand(receiver);

        PS5Controller controller = new PS5Controller();
        controller.setCrossButton(crossCommand);
        controller.setTriangleButton(triangleCommand);
        controller.setSquareButton(squareCommand);
        controller.setCircleButton(circleCommand);

        System.out.println("Default Button Configuration");
        controller.pressCross();
        controller.pressTriangle();
        controller.pressSquare();
        controller.pressCircle();

        System.out.println("\nUndo Last Action");
        controller.undoLastAction();

        System.out.println("\nRemapping Buttons at Runtime");
        controller.setCrossButton(circleCommand);
        controller.setCircleButton(crossCommand);

        System.out.println("After remapping (Cross <-> Circle):");
        controller.pressCross();   
        controller.pressCircle();  
    }
}
