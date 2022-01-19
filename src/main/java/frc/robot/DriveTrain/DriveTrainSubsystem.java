package frc.robot.DriveTrain;

//import libraries
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class DriveTrainSubsystem extends Subsystem {

    // Define the motors
    // Left side
    public TalonSRX leftMotorLeader = new Talon(RobotMap.leftMotorLeader);
    public TalonSRX leftMotorFollower = new TalonSRX(RobotMap.leftMotorFollower);
    // Right Side
    public TalonSRX rightMotorLeader = new TalonSRX(RobotMap.rightMotorLeader);
    public TalonSRX rightMotorFollower = new TalonSRX(RobotMap.rightMotorFollower);

    // setting up motor speeds
    // contains several nested if statements, with checks for safety activations and
    // for side activated
    // debug code located at the end.
    public void setMotors(final double speed, final String side, final boolean speedMod, final boolean cubicSafety, final boolean slowMode) {

        if (side == "left") {
            System.out.println("left side activated");
            leftMotorFollower.set(ControlMode.PercentOutput, )
        }

    }

    @Override
    protected void initDefaultCommand() {
        // TODO Auto-generated method stub
        setDefaultCommand(new DriveTrainCommand());
    }

}
