// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.RobotMap;

public class ClimberDown extends CommandBase {
    public ClimberDown() {
        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(RobotContainer.m_climberSubsystem);
    }

    // Called when the command is initially scheduled.

    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.

    @Override
    public void execute() {
        // run the climber as long as there is an input on dpad up
        RobotContainer.m_climberSubsystem.setMotors(-1 * RobotMap.climberSpeedMod);
    }

    // Called once the command ends or is interrupted.

    @Override
    public void end(boolean interrupted) {
        RobotContainer.m_climberSubsystem.setMotors(0);
    }

    // Returns true when the command should end.

    @Override
    public boolean isFinished() {
        return false;
    }
}
