// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Autonomous_Commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.AutoConveyorIn;
import frc.robot.commands.DriveBackward;
import frc.robot.commands.DriveForward;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class FullAuto extends SequentialCommandGroup {
  /** Creates a new FullAuto. */
  public FullAuto() {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
        // shoot the ball, drive to the ball outside the tarmac, pick it upk, drive back
        // to the fender and shoot
        new shootHub(), new DriveBackward(), new AutoConveyorIn(), new DriveForward(), new shootHub());
  }
}
