package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class IntakeSubsystem extends SubsystemBase {
    // define motor
    TalonSRX intakeMotor;

    public IntakeSubsystem() {
        System.out.println("Intake Subsystem init");
        // assign can id
        intakeMotor = new TalonSRX(RobotMap.intakeMotor);
    }

    public void setMotors(double middle) {
        intakeMotor.set(RobotMap.controlMode, middle);
        System.out.println("Intake Speed: " + middle);
    }

}
