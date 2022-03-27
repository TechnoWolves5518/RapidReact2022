// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Autonomous_Commands.Autonomous_Command_Groups;

import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
//import frc.robot.Autonomous_Commands.AutoConveyorIn1;
import frc.robot.Autonomous_Commands.AutoConveyorIn2;
import frc.robot.commands.ShooterHigh;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class shootHub2 extends ParallelDeadlineGroup {
  /** Creates a new ShootHigh. */
  public shootHub2() {
    // run the shooter for a period of time, force the command group to end when
    // finished.
    super(new AutoConveyorIn2());
    // run the conveyor as long as the shooter is running
    addCommands(new ShooterHigh());
  }
}
