package frc.robot.DriveTrain;

//import file connections.
import frc.robot.oi;
import frc.robot.RobotMap;
//import libraries
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.CommandBase;
import frc.robot.Robot;
//testline
public class DriveTrainCommand extends CommandBase {
    public DriveTrainCommand() {
        // Makes sure this file requires driveSubsystem
        requires(driveSubsystem);
        // debug
        if (RobotMap.debug) {
            System.out.println("Drive Train Command Init");
        }
    }

    // creates the driver controller that is equal to the controller defined in
    // OI.java
    private static XboxController driver = oi.driverController;
    // Speed mod variables
    public double forwardSpeedLeft, forwardSpeedRight;
    public boolean speedModeToggle = true;
    public boolean slowModeToggle = false;

    // other variables
    public boolean autoMode;
    public boolean slowMode;
    public boolean cubicSafety;
    public boolean safetyMode;

    @Override
    protected void execute() {

        // set speed values equal to stick values
        forwardSpeedLeft = driver.getRawAxis(oi.leftStickY);
        forwardSpeedRight = driver.getRawAxis(oi.rightStickY);
        slowMode = driver.getRawButton(oi.rightBumper);
        safetyMode = driver.getRawButton(oi.leftBumper);
        cubicSafety = driver.getRawButton(oi.leftTrigger);

        System.out.println(slowMode);
        checkBumpers();

        motorDriveCode();

    }

    // check bumpers in order to disable or enable safties manually
    public void checkBumpers() {
        // if both bumpers are pressed, don't disable eiteher safety
        if ((cubicSafety == true) && (safetyMode == true)) {
            System.out.println("Both Bumpers Pressed, Safeties enabled");
        } else {
            // if left bumper is pressed, disable speed mods
            if (safetyMode == true) {
                speedModeToggle = false;
            }
            // if left trigger is pressed, disable cubic safety
            if (cubicSafety == true) {
                RobotMap.driveTrainSafety = !RobotMap.driveTrainSafety;
            }
        }
    }

    // main driver code for motors
    public void motorDriveCode() {
        if (autoMode == true) {
            DriveTrainSubsystem.setMotors(forwardSpeedLeft, "left", speedModeToggle, false, false);
            DriveTrainSubsystem.setMotors(forwardSpeedRight, "right", speedModeToggle, false, false);
            if (RobotMap.driveDebug) {
                DriveTrainSubsystem.setMotors(0, "left", speedModeToggle, false, false);
                DriveTrainSubsystem.setMotors(0, "right", speedModeToggle, false, false);
                System.out.println("Autonomous code not working");
            }
        }
        // checks if stick is beyond deadzone, activates motors if yes
        // prints debug if no.
        if (Math.abs(forwardSpeedLeft) > RobotMap.deadzone) {
            DriveTrainSubsystem.setMotors(forwardSpeedLeft, "left", speedModeToggle, cubicSafety, slowMode);
        } else {
            // debug
            if (RobotMap.driveDebug) {
                DriveTrainSubsystem.setMotors(0, "left", speedModeToggle, cubicSafety, slowMode);
                System.out.print("left stick not beyond deadzone");
            }
        }
        // right side equibalent of above
        if (Math.abs(forwardSpeedRight) > RobotMap.deadzone) {
            DriveTrainSubsystem.setMotors(forwardSpeedRight, "right", speedModeToggle, cubicSafety, slowMode);
        } else {
            // debug
            if (RobotMap.driveDebug) {
                DriveTrainSubsystem.setMotors(0, "right", speedModeToggle, cubicSafety, slowMode);
                System.out.println("Right stick not beyond deadzone");
            }
        }
        // debug
        if (RobotMap.debug) {
            System.out.println("drivetraincommand driver code");
        }
    }

    @Override
    protected boolean isFinished() {
        // TODO Auto-generated method stub
        return false;
    }

}
