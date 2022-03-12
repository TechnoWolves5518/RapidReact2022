// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.AutoHighShoot;
//import frc.robot.commands.ConveyorCommand;
import frc.robot.commands.ConveyorIn;
import frc.robot.commands.ConveyorOut;
import frc.robot.commands.DriveBackward;
import frc.robot.subsystems.ConveyorSubsystem;
import frc.robot.commands.DriveTrainCommand;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.commands.IntakeCommand;
import frc.robot.commands.ShooterHigh;
import frc.robot.commands.ShooterLow;
import frc.robot.subsystems.IntakeSubsystem;
//import frc.robot.commands.ShooterCommand;
import frc.robot.subsystems.ShooterSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
// import frc.robot.Constants;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  public final static DriveTrainSubsystem m_exampleSubsystem = new DriveTrainSubsystem();
  public final IntakeSubsystem m_intakeSubsystem = new IntakeSubsystem();
  public final static ConveyorSubsystem m_conveyorSubsystem = new ConveyorSubsystem();
  public final static ShooterSubsystem m_shooterSubsystem = new ShooterSubsystem();

  private final DriveTrainCommand m_autoCommand = new DriveTrainCommand(m_exampleSubsystem);
  private final IntakeCommand m_intakeCommand = new IntakeCommand(m_intakeSubsystem);
  // private final ConveyorCommand m_conveyorCommand = new
  // ConveyorCommand(m_conveyorSubsystem);
  // private final ShooterCommand m_shooterCommand = new
  // ShooterCommand(m_shooterSubsystem);

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  // controller imports
  public static XboxController driverController = new XboxController(0);
  public static XboxController specialController = new XboxController(1);
  // button bindings for driver controller
  JoystickButton driveryButton = new JoystickButton(driverController, Constants.yButton);
  JoystickButton driverxButton = new JoystickButton(driverController, Constants.xButton);
  JoystickButton driverStartButton = new JoystickButton(driverController, Constants.startButton);
  // Constants.startButton);
  // button bindings for special functions controller
  JoystickButton specialyButton = new JoystickButton(specialController, Constants.yButton);
  JoystickButton specialxButton = new JoystickButton(specialController, Constants.xButton);
  JoystickButton specialLStickButton = new JoystickButton(specialController, Constants.leftStickButton);

  public RobotContainer() {
    configureButtonBindings();
    m_exampleSubsystem.setDefaultCommand(m_autoCommand);
    m_intakeSubsystem.setDefaultCommand(m_intakeCommand);
    // m_conveyorSubsystem.setDefaultCommand(m_conveyorCommand);
    // m_shooterSubsystem.setDefaultCommand(m_shooterCommand);
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing
   * it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    driveryButton.whileHeld(new ShooterHigh());
    driverxButton.whileHeld(new ShooterLow());
    driverStartButton.whenPressed(new DriveBackward());
    specialyButton.whileHeld(new ConveyorIn());
    specialxButton.whileHeld(new ConveyorOut());
    specialLStickButton.whenPressed(new AutoHighShoot());
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
