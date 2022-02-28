package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.RobotMap;
import frc.robot.subsystems.IntakeSubsystem;
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
    private static XboxController specialFunctions = Constants.specialController;
    // check for whether or not intake is active
    public boolean intakeStatus, outakeStatus;
    public boolean intakeControl, outakeControl;
    // set up a speed variable
    public double intakeSpeed = 1.0;
    public double intakeControlSpeed;
    // set up variables for toggle control
    boolean toggleMode = false;
    boolean toggleSwitch = false;
    // set up a tick counting variable
    public int count = 0;

    // run the code every time the command is scheduled(called)
    public void updateToggle() {
        if (specialFunctions.getRightBumper()) {
            if (!toggleSwitch) {
                toggleMode = !toggleMode;
                toggleSwitch = true;
            }
        } else {
            toggleSwitch = false;
        }
    }

    @Override
    public void execute() {
        // activate updateToggle
        updateToggle();
        // obtain button imputs
        intakeStatus = specialFunctions.getAButton();
        outakeStatus = specialFunctions.getBButton();
        intakeControl = toggleMode;
        outakeControl = specialFunctions.getLeftBumper();
        /*
         * System.out.println("intake: " + intakeStatus);
         * System.out.println("outake: " + outakeStatus);
         */
        // check for which direction to move the intake system
        if (intakeStatus && outakeStatus == true) {
            intakeSpeed = 0;
        } else if (intakeStatus == true) {
            intakeSpeed = 1;
        } else if (outakeStatus == true) {
            intakeSpeed = -1;
        } else {
            intakeSpeed = 0;
        }
        // check for which direction to spin the intake angler thing
        if (intakeControl && outakeControl == true) {
            intakeControlSpeed = 0;
        } else if (intakeControl == true) {
            if (count < 100) {
                intakeControlSpeed = 1;
                count++;
                System.out.println(count);
            } else {
                intakeControlSpeed = 0;
                count = 0;
                intakeControl = false;
                toggleMode = false;
                System.out.println("tick number " + count);
                System.out.println("intake control status " + intakeControl);
            }
        } else if (outakeControl == true) {
            if (count < 100) {
                intakeControlSpeed = -1;
                count++;
                System.out.println(count);
            } else {
                intakeControlSpeed = 0;
                count = 0;
                outakeControl = false;
                toggleMode = false;
                System.out.println("tick number " + count);
                System.out.println("intake control status " + intakeControl);
            }
        } else {
            intakeControlSpeed = 0;
        }
        // setup the motors
        intakeSubsystem.setMotors(intakeSpeed * RobotMap.intakeMod);
        intakeSubsystem.setMotor(intakeControlSpeed * RobotMap.intakeControlMod);
    }

}
