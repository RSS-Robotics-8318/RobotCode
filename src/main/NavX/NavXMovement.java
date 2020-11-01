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

public class NavXMovement {

    private RobotDrive myRobot;
    private AHRS ahrs;

    public NavXMovement() {
        myRobot = new RobotDrive(0, 1);
        myRobot.setExpiration(0.1);
    }

    public void movement() {
        boolean motionDetected = ahrs.isMoving();
        SmartDashboard.putBoolean("Motion Detected", motionDetected);

        /*try {
            myRobot.mecanumDrive_Cartesian(_joystick.getX(), _joystick.getY(), _joystick.getTwist(), 0);
        } catch (RuntimeException ex) {
            String err_string = "Drive System ERROR: " + ex.getMessage();
            DriverStation.reportError(err_string, true);
        }*/
    }
}