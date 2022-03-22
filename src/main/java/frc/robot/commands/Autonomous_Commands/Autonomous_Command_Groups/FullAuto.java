// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Autonomous_Commands.Autonomous_Command_Groups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Autonomous_Commands.AutoConveyorIn2;
import frc.robot.commands.Autonomous_Commands.AutoDriveForward;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class FullAuto extends SequentialCommandGroup {
  /** Creates a new FullAuto. */
  public FullAuto() {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
        // shoot the ball, drive to the ball outside the tarmac, pick it up, drive back
        // to the fender, shoot again, then drive out to guarentee taxi.
        new shootHub(),
        new DriveToBall(),
        new AutoConveyorIn2(),
        new AutoDriveForward(),
        new shootHub2());
  }
}
