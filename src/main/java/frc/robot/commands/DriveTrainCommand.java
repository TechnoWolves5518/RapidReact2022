// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.RobotMap;
import frc.robot.subsystems.DriveTrainSubsystem;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class DriveTrainCommand extends CommandBase {
  @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
  private final DriveTrainSubsystem driveTrainSubsystem;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public DriveTrainCommand(DriveTrainSubsystem subsystem) {
    System.out.println("Drive Train Command init");
    driveTrainSubsystem = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(driveTrainSubsystem);

  }

  // create a new controller for the driver
  private static XboxController driver = Constants.driverController;
  // speed values
  public double forwardSpeedLeft, forwardSpeedRight;
  // public boolean slowModeToggle;

  // public boolean slowmode;
  public boolean slowModeToggle = false;
  public double speedModifier = RobotMap.speedMod;

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // get values from controller
    forwardSpeedLeft = driver.getLeftY();
    forwardSpeedRight = driver.getRightY();
    // slowmode = driver.getRightBumper();
    slowModeToggle = driver.getRightBumper();

    if (slowModeToggle == true) {
      speedModifier = RobotMap.safetyMod;
    } else {
      speedModifier = RobotMap.speedMod;
    }

    if (Math.abs(forwardSpeedLeft) < RobotMap.deadzone) {
      forwardSpeedLeft = 0;
    }
    if (Math.abs(forwardSpeedRight) < RobotMap.deadzone) {
      forwardSpeedRight = 0;
    }
    driveTrainSubsystem.setMotors(
        Math.pow(-forwardSpeedLeft * RobotMap.speedMod, 3),
        Math.pow(forwardSpeedRight * RobotMap.speedMod, 3));
  }

  // System.out.println("Left: " + forwardSpeedLeft + " Right: " +
  // forwardSpeedRight);

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
