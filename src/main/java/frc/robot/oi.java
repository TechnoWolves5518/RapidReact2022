package frc.robot;

import edu.wpi.first.wpilibj.XboxController;

public class oi {
    // define controllers
    public static XboxController driverController = new XboxController(0);
    public static XboxController specialController = new XboxController(1);

    // button ports
    public static int yButton = 0;
    public static int xButton = 1;
    public static int aButton = 2;
    public static int bButton = 3;

    public static int leftStickX = 0;
    public static int leftStickY = 1;
    public static int rightStickX = 4;
    public static int rightStickY = 5;
    public static int leftTrigger = 2;
    public static int rightTrigger = 3;

    public static int rightBumper = 6;
    public static int leftBumper = 5;
    public static int leftStickButton = 9;
    public static int rightStickButton = 10;
    public static int startButton = 8;
    public static int backButton = 7;
}
