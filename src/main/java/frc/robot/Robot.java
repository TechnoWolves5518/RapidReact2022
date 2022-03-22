// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
//import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.Autonomous_Commands.Autonomous_Command_Groups.FullAuto;
//import frc.robot.commands.ConveyorCommand;
//import frc.robot.commands.DriveTrainCommand;
//import frc.robot.commands.IntakeCommand;
//import frc.robot.commands.ShooterHigh;
//import frc.robot.commands.ShooterCommand;
//import frc.robot.subsystems.ConveyorSubsystem;
//import frc.robot.subsystems.DriveTrainSubsystem;
//import frc.robot.subsystems.ShooterSubsystem;
import edu.wpi.first.wpilibj.DigitalOutput;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the
 * name of this class or
 * the package after creating this project, you must also update the
 * build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  public Command m_autonomousCommand;
  private RobotContainer m_robotContainer;
  // setup autonomous

  // test autonomous
  private static final String kDefaultAuto = "test Auto";
  // actual auto, from the fender
  private static final String kCustomAuto = "Fender Auto";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();
  Command autonomousCommand;
  // set autonomous variables
  double autoTop = 1;
  double autoBottom = -1;
  // auto start time
  // private double startTime;
  // subsystem imports
  // private ShooterSubsystem shooterAuto = RobotContainer.m_shooterSubsystem;

  /**
   * This function is run when the robot is first started up and should be used
   * for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    // Instantiate our RobotContainer. This will perform all our button bindings,
    // and put our
    // autonomous chooser on the dashboard.
    m_robotContainer = new RobotContainer();
    m_chooser.setDefaultOption("Test Auto", kDefaultAuto);
    m_chooser.addOption("Fender Auto", kCustomAuto);
    SmartDashboard.putData("Auto choices", m_chooser);
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for
   * items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and
   * test.
   *
   * <p>
   * This runs after the mode specific periodic functions, but before LiveWindow
   * and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler. This is responsible for polling buttons, adding
    // newly-scheduled
    // commands, running already-scheduled commands, removing finished or
    // interrupted commands,
    // and running subsystem periodic() methods. This must be called from the
    // robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();
  }

  /** This function is called once each time the robot enters Disabled mode. */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
  }

  /*
   * This autonomous runs the autonomous command selected by your
   * {@link RobotContainer} class.
   */
  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();
    try (DigitalOutput Output = new DigitalOutput(0)) {
      Output.set(false);
    }
    m_autonomousCommand = new FullAuto();
    System.out.println("autonomous initiated");
    // schedule the autonomous command (example)
    m_autonomousCommand.schedule();
    m_autoSelected = m_chooser.getSelected();
    System.out.println("Auto Selected " + m_autoSelected);

    // set auto start time
    // startTime = Timer.getFPGATimestamp();
    // set run the autonomous code when autonomous is enabled
    if (m_autoSelected == kDefaultAuto) {
      CommandScheduler.getInstance().schedule(m_autonomousCommand);
      // RobotContainer.m_shooterSubsystem.setMotors(-1, 1);
    }
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {

  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    // System.out.println("running");
    CommandScheduler.getInstance().run();
  }

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {
  }
}
