// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Autonomous_Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class AutoConveyorIn1 extends CommandBase {
  // set a time count variable
  int count = 0;
  // set a force stop variable
  boolean stopCheck = false;

  /** Creates a new AutoConveyorIn. */
  public AutoConveyorIn1() {
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

    // run the autonomous conveyor loop for about 1.5 seconds, run until stopped by
    // command group
    if (count < 75) {
      count++;
    } else if (count < 400) {
      // set the conveyor to run
      RobotContainer.m_conveyorSubsystem.setMotors(1);
      count++;
    } else {
      count = 0;
      stopCheck = true;
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.m_conveyorSubsystem.setMotors(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return stopCheck;
  }
}
