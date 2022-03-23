package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;

public class RobotMap {
    // speed modifiers

    // ublic static boolean driveTrainSafety = true;
    public static double speedMod = 0.5;
    public static boolean driveSlowMod = false;
    public static boolean driveFastMod = false;
    public static double fastMod = 0.7;
    public static double slowmod = 0.4;
    public static double intakeMod = 0.5;
    public static double conveyorMod = 1;
    public static double topPort = 1;
    public static double bottomPort = 0.6;
    public static double intakeControlMod = 0.3;
    public static double climberSpeedMod = 0.4;

    /// Debug Toggles ///
    public static final boolean debug = false;
    public static final boolean driveDebug = true;

    /// Drive Train Deadzone Value ///
    public static double deadzone = 0.15;

    /// Control Mode (Required for VICTORSPX.set() functions) ///
    public static ControlMode controlMode = ControlMode.PercentOutput;

    /// Motor Ports (CAN BUS) ///
    // drive train
    public static final int leftMotorLeader = 3;
    public static final int leftMotorFollower = 4;
    public static final int rightMotorLeader = 2;
    public static final int rightMotorFollower = 1;
    // special functions
    public static final int intakeMotor = 50; // not used
    public static final int conveyorMotor = 5;
    public static final int shooterMotorTop = 6;
    public static final int shooterMotorBottom = 7;
    public static final int wenchMotor = 9;
    public static final int climberMotor = 10;
}