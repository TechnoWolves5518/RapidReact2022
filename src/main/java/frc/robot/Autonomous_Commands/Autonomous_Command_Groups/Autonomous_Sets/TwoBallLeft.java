// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Autonomous_Commands.Autonomous_Command_Groups.Autonomous_Sets;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Autonomous_Commands.AutoConveyorIn2;
import frc.robot.Autonomous_Commands.Autonomous_Command_Groups.Drive2BallLeft;
import frc.robot.Autonomous_Commands.Autonomous_Command_Groups.DriveBack;
import frc.robot.Autonomous_Commands.Autonomous_Command_Groups.DriveToFenderLeft;
import frc.robot.Autonomous_Commands.Autonomous_Command_Groups.shootHub;
import frc.robot.Autonomous_Commands.Autonomous_Command_Groups.shootHub2;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class TwoBallLeft extends SequentialCommandGroup {
  /** Creates a new TwoBallLeft. */
  public TwoBallLeft() {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
        new shootHub(),
        new Drive2BallLeft(),
        new AutoConveyorIn2(),
        new DriveToFenderLeft(),
        new shootHub2(),
        new DriveBack());
  }
}
