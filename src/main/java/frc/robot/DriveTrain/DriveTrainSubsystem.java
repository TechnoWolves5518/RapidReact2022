package frc.robot.DriveTrain;

//import libraries
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class DriveTrainSubsystem extends Subsystem {

    // Define the motors
    // Left side
    public static TalonSRX leftMotorLeader = new TalonSRX(RobotMap.leftMotorLeader);
    public static TalonSRX leftMotorFollower = new TalonSRX(RobotMap.leftMotorFollower);
    // Right Side
    public static TalonSRX rightMotorLeader = new TalonSRX(RobotMap.rightMotorLeader);
    public static TalonSRX rightMotorFollower = new TalonSRX(RobotMap.rightMotorFollower);

    // setting up motor speeds
    // contains several nested if statements, with checks for safety activations and
    // for side activated
    // debug code located at the end.
    public static int setMotors(final double speed, final String side, final boolean speedMod,
            final boolean cubicSafety, final boolean slowMode) {

        if (side == "left") {
            System.out.println("left side activated");
            leftMotorFollower.set(ControlMode.PercentOutput,
                    configSpeed(-speed, speedMod, cubicSafety, slowMode, "left"));
            leftMotorLeader.set(ControlMode.PercentOutput,
                    configSpeed(-speed, speedMod, cubicSafety, slowMode, "left"));
        }
        if (side == "right") {
            System.out.println("right side activated");
            rightMotorFollower.set(ControlMode.PercentOutput,
                    configSpeed(speed, speedMod, cubicSafety, slowMode, "right"));
            rightMotorLeader.set(ControlMode.PercentOutput,
                    configSpeed(speed, speedMod, cubicSafety, slowMode, "right"));
        }

        // debug
        if (RobotMap.driveDebug) {
            System.out.println("Side : " + side + " \t\t Speed : " + speed);
        }
        return 0;
    }

    // returns a double based on speed after both modifiers have been applied
    public static double configSpeed(final double speed, final boolean speedMod, final boolean cubicSafety,
            final boolean slowMode, final String side) {
        final double returnVar;
        if (slowMode == true) {
            returnVar = speed * .2;
            System.out.println("slow mode activate for " + side);
        } else {
            // if both modifiers are enabled
            if ((cubicSafety) && (speedMod)) {
                // return speed to the third multiplied by speed modifier ((speed**3)*speedMod)
                returnVar = ((Math.pow(speed, 3)) * RobotMap.driveSafetySpeedMod);
            }
            // if cubic safety is on but not speedmod
            else if ((cubicSafety) && (!speedMod)) {
                // return speed cubed
                returnVar = Math.pow(speed, 3);
            }
            // if speedmod is on but not speedmod
            else if ((!cubicSafety) && (speedMod)) {
                // return speed * speedMod
                returnVar = speed * (RobotMap.driveSafetySpeedMod);
            }
            // if neither are enabled
            else if ((!cubicSafety) && (!speedMod)) {
                // return raw speed value
                returnVar = speed;
                System.out.println(side + " " + speed);
            }
            // Debug Code if none of the above are applicable
            else {
                if (RobotMap.driveDebug) {
                    System.out.println("Error in configSpeed in drivetrainsubsystem.java");
                }
                // return a value of 0
                return 0;
            }
        }
        return returnVar;
    }

    @Override
    protected void initDefaultCommand() {
        // TODO Auto-generated method stub

    }
}