package main.java.frc.robot;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogOutput;
import edu.wpi.first.wpilibj.AnalogTrigger;
import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class NavXRotation implements PIDOutput{

    AHRS ahrs;
    RobotDrive myRobot;
    Joystick stick;
    PIDController turnController;
    double rotateToAngleRate;

    private final static double kP = 0.03f;
    private final static double kI = 0.00f;
    private final static double kD = 0.00f;
    private final static double kF = 0.00f;

    private final static double kToleranceDegrees = 2.0f;

    public NavXRotation() {

        myRobot = new RobotDrive(0, 1);
        myRobot.setExpiration(0.1);

        try {
            ahrs = new AHRS(SPI.Port.kMXP);
        } catch (RuntimeException ex) {
            DriverStation.reportError("Error instantiating navX-MXP:  " + ex.getMessage(), true);
        }


        turnController = new PIDController(kP, kI, kD, kF, ahrs, this);
        turnController.setInputRange(-180.0f,  180.0f);
        turnController.setOutputRange(-1.0, 1.0);
        turnController.setAbsoluteTolerance(kToleranceDegrees);
        turnController.setContinuous(true);

        LiveWindow.addActuator("DriveSystem", "RotateController", turnController);
    }

    public void rotation() {
        boolean rotateToAngle = false;

            if (_joystick.getRawButton(1)) {//button to recalibrate angle / set current angle to 0 degrees
                ahrs.reset();
            }

            if (_joystick.getRawButton(2)) {//button pressed to rotate, "forward"
                turnController.setSetpoint(0.0f);
                rotateToAngle = true;

            } else if (_joystick.getRawButton(3)) {//button pressed to rotate, "right"
                turnController.setSetpoint(90.0f);
                rotateToAngle = true;

            } else if (_joystick.getRawButton(4)) {//button pressed to rotate, "backward"
                turnController.setSetpoint(179.9f);
                rotateToAngle = true;

            } else if (_joystick.getRawButton(5)) {//button pressed to rotate, "left"
                turnController.setSetpoint(-90.0f);
                rotateToAngle = true;
            }

            double currentRotationRate;

            if(rotateToAngle) {
                turnController.enable();
                currentRotationRate = rotateToAngleRate;
            } else {
                turnController.disable();
                currentRotationRate = _joystick.getTwist();
            }

            /*try {
                myRobot.mecanumDrive_Cartesian(_joystick.getX(), _joystick.getY(), currentRotationRate, ahrs.getAngle());
            } catch (RuntimeException ex){
                DriverStation.reportError(" Error commmunicating with drive system: " + ex.getMessage(), true);
            }*/

    }
}