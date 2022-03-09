package frc.robot.commands.Autonomous_Commands;

// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
import com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Basic;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.commands.ConveyorIn;
import frc.robot.commands.ShooterHigh;
import frc.robot.subsystems.ConveyorSubsystem;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class BasicAuto extends ParallelCommandGroup {
  /**
   * Creates a new BasicAuto.
   * 
   * @return
   */
  public BasicAuto() {
    addCommands(
        new ShooterHigh(),
        new ConveyorIn());
  }
}
