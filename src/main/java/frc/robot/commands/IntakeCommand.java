package frc.robot.commands;

//import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.RobotMap;
import frc.robot.subsystems.IntakeSubsystem;
//import edu.wpi.first.wpilibj.SynchronousInterrupt;
//import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class IntakeCommand extends CommandBase {
    @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
    private final IntakeSubsystem intakeSubsystem;

    public IntakeCommand(IntakeSubsystem subsystem) {
        // debug code to ensure the subsystem works
        // System.out.println("Intake Command init");
        intakeSubsystem = subsystem;
        // require intake subsystem in order to run
        addRequirements(intakeSubsystem);
    }

    // create a new controller for the special functions
    private static XboxController specialFunctions = RobotContainer.specialController;
    // check for whether or not intake is active
    public boolean intakeStatus, outakeStatus;
    public boolean intakeControl, outakeControl;
    // set up a speed variable
    public double intakeSpeed = 1.0;
    public double intakeControlSpeed;

    @Override
    public void execute() {
        // obtain button imputs
        intakeStatus = specialFunctions.getAButton();
        outakeStatus = specialFunctions.getBButton();
        intakeControl = specialFunctions.getRightBumper();
        outakeControl = specialFunctions.getLeftBumper();
        /*
         * System.out.println("intake: " + intakeStatus);
         * System.out.println("outake: " + outakeStatus);c
         */
        // check for which direction to move the intake system
        /*
         * if (intakeStatus && outakeStatus == true) {
         * intakeSpeed = 0;
         * } else if (intakeStatus == true) {
         * intakeSpeed = 1;
         * } else if (outakeStatus == true) {
         * intakeSpeed = -1;
         * } else {
         * intakeSpeed = 0;
         * }
         */
        // set direction to take wench system
        if (intakeControl && outakeControl == true) {
            intakeControlSpeed = 0;
            // System.out.println("both wench buttons pressed, override initiated.");
        } else if (intakeControl == true) {
            intakeControlSpeed = 1;
            // System.out.println("wench moving up");
        } else if (outakeControl == true) {
            intakeControlSpeed = -1;
            // System.out.println("wench moving down");
        } else {
            intakeControlSpeed = 0;
            // System.out.println("wench not moving");
        }
        // setup the motors
        intakeSubsystem.setMotors(intakeSpeed * RobotMap.intakeMod);
        intakeSubsystem.setMotor(intakeControlSpeed * RobotMap.intakeControlMod);
    }

}
