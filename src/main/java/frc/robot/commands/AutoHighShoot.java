// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.RobotMap;

public class AutoHighShoot extends CommandBase {
  /** Creates a new AutoHighShoot. */
  int count = 0;
  boolean stopCheck = false;

  public AutoHighShoot() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.m_shooterSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    RobotContainer.m_shooterSubsystem.setMotors(-1, -1);
    if (count < 250) {
      count++;
    } else {
      count = 0;
      stopCheck = true;
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.m_shooterSubsystem.setMotors(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return stopCheck;
  }
}
