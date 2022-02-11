package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import frc.robot.RobotMap;

public class ShooterSubsystem extends SubsystemBase {
    // define the motors
    TalonSRX shooterMotorTop;
    TalonSRX shooterMotorBottom;

    public ShooterSubsystem() {
        // assign can ids
        shooterMotorTop = new TalonSRX(RobotMap.shooterMotorTop);
        shooterMotorBottom = new TalonSRX(RobotMap.shooterMotorBottom);
    }

    public void setMotors(double topShooterSpeed, double bottomShooterSpeed) {
        shooterMotorBottom.set(RobotMap.controlMode, bottomShooterSpeed);
        shooterMotorTop.set(RobotMap.controlMode, topShooterSpeed);
        // System.out.println("Top shooter speed: " + topShooterSpeed + " Bottom shooter
        // speed: " + bottomShooterSpeed);
    }
}
