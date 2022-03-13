// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.RobotMap;

public class TurnLeft extends CommandBase {
  /** Creates a new TurnLeft. */
  // set time count variable
  int count = 0;
  // set force stop variable
  boolean stopCheck;

  public TurnLeft() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.m_exampleSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    RobotContainer.m_exampleSubsystem.setMotors(1 * RobotMap.speedMod, 1 * RobotMap.speedMod);
    if (count < 25) {
      count++;
    } else {
      count = 0;
      stopCheck = true;
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.m_exampleSubsystem.setMotors(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return stopCheck;
  }
}