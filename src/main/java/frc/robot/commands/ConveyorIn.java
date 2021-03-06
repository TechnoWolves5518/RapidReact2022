// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class ConveyorIn extends CommandBase {
  /** Creates a new Conveyor2point0. */
  double stallStop = RobotContainer.m_conveyorSubsystem.stallCheck;
  static XboxController special = RobotContainer.specialController;

  public ConveyorIn() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.m_conveyorSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // run the conveyor in as long as the y button is pressed on the special
    // functions controller
    RobotContainer.m_conveyorSubsystem.setMotors(1);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.m_conveyorSubsystem.setMotors(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
