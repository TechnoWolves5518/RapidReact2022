package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class ConveyorSubsystem extends SubsystemBase {
    // define the motor
    TalonSRX conveyorMotor;

    public ConveyorSubsystem() {
        // System.out.println("Conveyor Subsystem init");
        // assign can id to the motor
        conveyorMotor = new TalonSRX(RobotMap.conveyorMotor);
    }

    public void setMotors(double conveyor) {
        conveyorMotor.set(RobotMap.controlMode, conveyor);
        // System.out.println("Conveyor Speed: " + conveyor);
    }
}
