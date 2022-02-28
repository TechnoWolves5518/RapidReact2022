package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class IntakeSubsystem extends SubsystemBase {
    // define motor
    TalonSRX intakeMotor;
    TalonSRX intakeControlMotor;

    public IntakeSubsystem() {
        // System.out.println("Intake Subsystem init");
        // assign can id
        intakeMotor = new TalonSRX(RobotMap.intakeMotor);
        intakeControlMotor = new TalonSRX(RobotMap.intakeControlMotor);
    }

    public void setMotors(double middle) {
        intakeMotor.set(RobotMap.controlMode, middle);
        // System.out.println("Intake Speed: " + middle);
    }

    public void setMotor(double controlSpeed) {
        intakeControlMotor.set(RobotMap.controlMode, controlSpeed);
        // System.out.println("Intake Control Speed: " + controlSpeed);
    }

}
