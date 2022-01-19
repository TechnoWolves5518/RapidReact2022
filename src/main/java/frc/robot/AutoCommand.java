package frc.robot;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.DriveTrain.*;

public abstract class AutoCommand extends CommandGroup {

    /// This is a hub for Subsystem Initializations ///

    public static DriveTrainSubsystem driveSubsystem;

    public static void init() {
        driveSubsystem = new DriveTrainSubsystem();

    }

}