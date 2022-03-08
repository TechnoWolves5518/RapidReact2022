/*
 * package frc.robot.commands;
 * 
 * import edu.wpi.first.wpilibj.XboxController;
 * import edu.wpi.first.wpilibj2.command.CommandBase;
 * import frc.robot.subsystems.ShooterSubsystem;
 * import frc.robot.Constants;
 * import frc.robot.RobotMap;
 * 
 * public class ShooterCommand extends CommandBase {
 * 
 * @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
 * private final ShooterSubsystem shooterSubsystem;
 * 
 * public ShooterCommand(ShooterSubsystem subsystem) {
 * // debug to ensure command initializes
 * // System.out.println("ShooterCommand init");
 * shooterSubsystem = subsystem;
 * // require shootersubsystem in order to run
 * addRequirements(shooterSubsystem);
 * }
 * 
 * // create a local controller for special functions
 * private static XboxController shooter = Constants.driverController;
 * // check for speed value for the shooter
 * public double topShooterSpeed, bottomShooterSpeed, port;
 * // set a check variable
 * public boolean highPortCheck = false;
 * public boolean lowPortCheck = false;
 * 
 * // run code when input is detected
 * 
 * @Override
 * public void execute() {
 * // obtain button inputs
 * highPortCheck = shooter.getYButton();
 * lowPortCheck = shooter.getXButton();
 * // check for which speed to set the speed to
 * if (highPortCheck && lowPortCheck == true) {
 * topShooterSpeed = 0;
 * bottomShooterSpeed = 0;
 * port = 0;
 * } else if (highPortCheck == true) {
 * topShooterSpeed = -1;
 * bottomShooterSpeed = 1;
 * port = RobotMap.topPort;
 * } else if (lowPortCheck == true) {
 * topShooterSpeed = -1;
 * bottomShooterSpeed = 1;
 * port = RobotMap.bottomPort;
 * } else {
 * topShooterSpeed = -0;
 * bottomShooterSpeed = 0;
 * port = 0;
 * // System.out.println("COMMAND HAPPENING");
 * }
 * // set the motor speed based on the input
 * shooterSubsystem.setMotors(
 * topShooterSpeed * port,
 * -bottomShooterSpeed * port);
 * }
 * }
 */