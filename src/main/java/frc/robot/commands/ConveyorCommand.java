/*
 * package frc.robot.commands;
 * 
 * import edu.wpi.first.wpilibj.XboxController;
 * import edu.wpi.first.wpilibj2.command.CommandBase;
 * import frc.robot.Constants;
 * import frc.robot.RobotContainer;
 * import frc.robot.subsystems.ConveyorSubsystem;
 * import frc.robot.RobotMap;
 * 
 * public class ConveyorCommand extends CommandBase {
 * 
 * @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
 * private final ConveyorSubsystem conveyorSubsystem;
 * 
 * public ConveyorCommand(ConveyorSubsystem subsystem) {
 * // debug code to ensure command initializes
 * // System.out.println("conveyor command init");
 * conveyorSubsystem = subsystem;
 * // require conveyor subsystem in order to run
 * addRequirements(conveyorSubsystem);
 * }
 * 
 * // create a local controller for special functions
 * private static XboxController specialFunctions =
 * RobotContainer.specialController;
 * // check for direction conveyor goes
 * public boolean conveyorIn = false;
 * public boolean conveyorOut = false;
 * // set up a speed value
 * public double conveyorSpeed = 0;
 * 
 * // run the code when an input is detected
 * 
 * @Override
 * public void execute() {
 * // obtain button inputs
 * conveyorIn = specialFunctions.getXButton();
 * conveyorOut = specialFunctions.getYButton();
 * // check for which direction to move the conveyor in teleop
 * if (conveyorIn && conveyorOut == true) {
 * conveyorSpeed = 0;
 * } else if (conveyorIn == true) {
 * conveyorSpeed = -1;
 * } else if (conveyorOut == true) {
 * conveyorSpeed = 1;
 * } else {
 * conveyorSpeed = 0;
 * }
 * // set the motor speed
 * conveyorSubsystem.setMotors(conveyorSpeed * RobotMap.conveyorMod);
 * }
 * 
 * }
 */