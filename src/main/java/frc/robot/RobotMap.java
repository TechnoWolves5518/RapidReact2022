package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;

public class RobotMap {
    // speed modifiers

    // ublic static boolean driveTrainSafety = true;
    public static double speedMod = .9;
    public static boolean driveSlowMod = false;
    public static double safetyMod = 0.5;
    public static double intakeMod = 0.5;
    public static double conveyorMod = 0.5;
    public static double topPort = 0.9;
    public static double bottomPort = 0.5;
    public static double intakeControlMod = 0.2;

    /// Debug Toggles ///
    public static final boolean debug = false;
    public static final boolean driveDebug = true;

    /// Drive Train Deadzone Value ///
    public static double deadzone = 0.15;

    /// Control Mode (Required for VICTORSPX.set() functions) ///
    public static ControlMode controlMode = ControlMode.PercentOutput;

    /// Motor Ports (CAN BUS) ///
    public static final int leftMotorLeader = 4;
    public static final int leftMotorFollower = 2;
    public static final int rightMotorLeader = 1;
    public static final int rightMotorFollower = 3;
    public static final int intakeMotor = 5;
    public static final int conveyorMotor = 6;
    public static final int shooterMotorTop = 7;
    public static final int shooterMotorBottom = 8;
    public static final int intakeControlMotor = 9;
}