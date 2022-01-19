package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;

public class RobotMap {
    // Drivetrain safety toggles
    public static boolean driveTrainSafety = true;
    public static double driveSafetySpeedMod = 0.3;
    public static boolean driveSlowMod = false;

    // conveyor safety
    // arbitrary values
    public static double conveyorSafetyMod = 0.1;

    // shooter safety
    // note: arbitrary values
    public static final double lowPortShooterSpeedMod = 0.3;
    public static final double highPortShooterSpeedMod = 0.6;

    // debug toggles
    public static final boolean debug = false;
    public static final boolean driveDebug = true;

    // drivetrain deadzone value
    public static double deadzone = 0.25;

    // control mode (required for VICTORSPX.set() functions)
    public ControlMode controlMode = ControlMode.PercentOutput;

    // Motor Ports (CAN IDs)
    // note arbitrary values
    public static int leftMotorLeader = 1; // left side
    public static int leftMotorFollower = 2;
    public static int rightMotorLeader = 3; // right side
    public static int rightMotorFollower = 4;
}
