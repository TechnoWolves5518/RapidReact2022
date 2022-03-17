package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;
import frc.robot.RobotMap;

public class ConveyorSubsystem extends SubsystemBase {
    // define the motor
    TalonSRX conveyorMotor;
    public double stallCheck;
    static XboxController special = RobotContainer.specialController;

    public ConveyorSubsystem() {
        // System.out.println("Conveyor Subsystem init");
        // assign can id to the motor
        conveyorMotor = new TalonSRX(RobotMap.conveyorMotor);

    }

    public void setMotors(double conveyor) {
        conveyorMotor.set(RobotMap.controlMode, conveyor);
        /*
         * stallCheck = conveyorMotor.getSupplyCurrent();
         * if (stallCheck > 50) {
         * special.setRumble(RumbleType.kLeftRumble, 0.5);
         * special.setRumble(RumbleType.kRightRumble, 0.5);
         * } else {
         * System.out.println(stallCheck);
         * }
         */

        // System.out.println("Conveyor Speed: " + conveyor);
    }
}
