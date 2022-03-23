// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;
import frc.robot.RobotMap;

public class ClimberSubsystem extends SubsystemBase {
  // define the motor
  TalonSRX climberMotor;
  static XboxController specialController = RobotContainer.specialController;

  public ClimberSubsystem() {
    climberMotor = new TalonSRX(RobotMap.climberMotor);
  }

  public void setMotors(double climber) {
    climberMotor.set(RobotMap.controlMode, climber);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
