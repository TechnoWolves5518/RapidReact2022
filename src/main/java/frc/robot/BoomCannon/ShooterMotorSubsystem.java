package frc.robot.BoomCannon;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class ShooterMotorSubsystem {
    // declare new motors
    public TalonSRX shooterMotorTop = new TalonSRX(RobotMap.shooterMotorTop);
    public TalonSRX shooterMotorBottom = new TalonSRX(RobotMap.shooterMotorBottom);
    public double speedOfTop;
    public double speedOfBottom;

    // set the motor's speed
    public void setMotors(final double speed, double placeholderShooterSpeedMod) {

        shooterMotorTop.set(ControlMode.PercentOutput, speed);
        shooterMotorBottom.set(ControlMode.PercentOutput, speed);
        // debug

        if (RobotMap.driveDebug) {
            System.out.println("Shooter speed :" + speed);
        }
    }

    public static double configSpeed(final double speed, final double speedMod) {
        final double returnVar;

        returnVar = speed * speedMod;

        // debug
        if (RobotMap.driveDebug) {
            System.out.println("Error in configSpeed");
            // return 0
            return 0;
        }
        return returnVar;
    }
}