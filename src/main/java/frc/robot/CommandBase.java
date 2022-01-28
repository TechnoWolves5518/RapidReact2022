package frc.robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.DriveTrain.*;
import frc.robot.BoomCannon.*;

public abstract class CommandBase extends Command {

    // all subsystem initiallizations belong here

    // initiallize Drivetrain
    public static DriveTrainSubsystem driveSubsystem;
    // iniitiallize intake and shooter subsystems
    public static ShooterMotorSubsystem ShooterSubsystem;
    public static IntakeConveyorSubsystem intakeConveyorSubsystem;

    // declare new subsystems
    public static void init() {
        driveSubsystem = new DriveTrainSubsystem();
        // ShooterSubsystem = new ShooterMotorSubsystem();
        // intakeConveyorSubsystem = new IntakeConveyorSubsystem();

    }

}
