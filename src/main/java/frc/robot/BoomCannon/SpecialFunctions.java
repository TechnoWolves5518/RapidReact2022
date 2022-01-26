package frc.robot.BoomCannon;

import frc.robot.oi;
import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.CommandBase;

public class SpecialFunctions extends CommandBase {
    public SpecialFunctions() {
        // requires(ShooterSubsystem);
        // requires(intakeConveyorSubsystem);
        if (RobotMap.debug) {
            System.out.println("Subsystem initialized");
        }
    }

    // creates a new controller equal to the special functions controller in the oi
    // file
    private static XboxController shmo = oi.specialController;

    // declare speed as an on or off condition
    public boolean ShooterSpeed;

    // button commands for all special functions.
    public void motorSpecialFunctions() {
        // work in progress
    }

    @Override
    protected boolean isFinished() {
        // TODO Auto-generated method stub
        return false;
    }

}
