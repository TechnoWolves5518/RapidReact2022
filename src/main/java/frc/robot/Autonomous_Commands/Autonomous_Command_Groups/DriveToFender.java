// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Autonomous_Commands.Autonomous_Command_Groups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Autonomous_Commands.AutoDriveForward;
import frc.robot.Autonomous_Commands.AutoDriveForward2;
//import frc.robot.Autonomous_Commands.AutoTurnRight;
import frc.robot.Autonomous_Commands.AutoTurnRight2;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class DriveToFender extends SequentialCommandGroup {
  /** Creates a new DriveToFender. */
  public DriveToFender() {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(new AutoDriveForward2(), new AutoTurnRight2(), new AutoDriveForward());
  }
}
