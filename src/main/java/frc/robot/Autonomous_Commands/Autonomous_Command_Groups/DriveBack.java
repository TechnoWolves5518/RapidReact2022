// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Autonomous_Commands.Autonomous_Command_Groups;

import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import frc.robot.Autonomous_Commands.AutoDriveBackward1;
import frc.robot.Autonomous_Commands.AutoWenchUp;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class DriveBack extends ParallelDeadlineGroup {
  /** Creates a new DriveBack. */
  public DriveBack() {
    // Add the deadline command in the super() call. Add other commands using
    // addCommands().
    super(new AutoDriveBackward1());
    addCommands(new AutoWenchUp());

  }
}
