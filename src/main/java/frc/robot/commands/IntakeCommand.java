package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.RobotMap;
import frc.robot.subsystems.IntakeSubsystem;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class IntakeCommand extends CommandBase {
    @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
    private final IntakeSubsystem intakeSubsystem;

    public IntakeCommand(IntakeSubsystem subsystem) {
        // debug code to ensure the subsystem works
        System.out.println("Intake Command init");
        intakeSubsystem = subsystem;
        // require intake subsystem in order to run
        addRequirements(intakeSubsystem);
    }

    // create a new controller for the special functions
    private static XboxController specialFunctions = Constants.specialController;
    // check for whether or not intake is active
    public boolean intakeStatus, outakeStatus;
    // set up a speed variable
    public double intakeSpeed = 1.0;

    // run the code every time the command is scheduled(called)
    @Override
    public void execute() {
        // obtain button imputs
        intakeStatus = specialFunctions.getAButton();
        outakeStatus = specialFunctions.getBButton();
        System.out.println("intake: " + intakeStatus);
        System.out.println("outake: " + outakeStatus);
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
        // setup the motors
        intakeSubsystem.setMotors(intakeSpeed * RobotMap.intakeMod);
    }

}
