// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class DriveTrainSubsystem extends SubsystemBase {
  // define motors
  // left side
  TalonSRX leftMotorLeader;
  TalonSRX leftMotorFollower;
  // right side
  TalonSRX rightMotorLeader;
  TalonSRX rightMotorFollower;

  public DriveTrainSubsystem() {
    // System.out.println("drive train subsystem init");
    // define left side
    leftMotorFollower = new TalonSRX(RobotMap.leftMotorFollower);
    leftMotorLeader = new TalonSRX(RobotMap.leftMotorLeader);
    // define right side
    rightMotorFollower = new TalonSRX(RobotMap.rightMotorFollower);
    rightMotorLeader = new TalonSRX(RobotMap.rightMotorLeader);
  }

  public void setMotors(double left, double right) {
    // set the motors
    leftMotorFollower.set(RobotMap.controlMode, left);
    leftMotorLeader.set(RobotMap.controlMode, left);

    rightMotorFollower.set(RobotMap.controlMode, right);
    rightMotorLeader.set(RobotMap.controlMode, right);
    // System.out.println("Left: " + left + " Right: " + right);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
