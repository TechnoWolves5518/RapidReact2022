// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.RobotMap;

public class DriveBackward extends CommandBase {
  /** Creates a new DriveForward. */
  XboxController driver = RobotContainer.driverController;
  double speedModifier;

  public DriveBackward() {
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
    // bumper check for slowmode
    boolean fastModeToggle = driver.getRightBumper();
    boolean slowModeToggle = driver.getLeftBumper();
    if (fastModeToggle && slowModeToggle == true) {
      speedModifier = RobotMap.speedMod;
    } else if (fastModeToggle == true) {
      speedModifier = RobotMap.fastMod;
    } else if (slowModeToggle == true) {
      speedModifier = RobotMap.slowmod;
    } else {
      speedModifier = RobotMap.speedMod;
    }
    RobotContainer.m_exampleSubsystem.setMotors(
        -1 * speedModifier,
        1 * speedModifier);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
