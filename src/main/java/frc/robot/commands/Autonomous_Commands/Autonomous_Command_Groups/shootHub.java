// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Autonomous_Commands.Autonomous_Command_Groups;

import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import frc.robot.commands.ConveyorIn;
import frc.robot.commands.Autonomous_Commands.AutoHighShoot;
import frc.robot.commands.Autonomous_Commands.AutoWenchDown;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class shootHub extends ParallelDeadlineGroup {
  /** Creates a new ShootHigh. */
  public shootHub() {
    // run the shooter for a period of time, force the command group to end when
    // finished.
    super(new AutoHighShoot());
    // run the conveyor and wench as long as the shooter is running
    addCommands(new ConveyorIn(), new AutoWenchDown());
  }
}
