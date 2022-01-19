package frc.robot;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.DriveTrain.*;

public abstract class CommandBase extends Command {

    // all subsystem initiallizations belong here

    // initiallize Drivetrain
    public static DriveTrainSubsystem driveSubsystem;
    // iniitiallize intake and shooter subsystems

    // declare new subsystems
    public static void init() {
        driveSubsystem = new DriveTrainSubsystem();

    }

}
