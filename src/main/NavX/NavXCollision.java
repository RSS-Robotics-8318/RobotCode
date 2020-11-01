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

public class NavXCollison {

    private AHRS ahrs;

    private double last_world_linear_accel_x;
    private double last_world_linear_accel_y;

    private final static double kCollisionThreshold_DeltaG = 0.5f;

    public NavXCollision() {
        myRobot = new RobotDrive(0, 1);
        myRobot.setExpiration(0.1);
        try {
            ahrs = new AHRS(SPI.Port.kMXP); 
        } catch (RuntimeException ex) {
            DriverStation.reportError("Error instantiating navX-MXP:  " + ex.getMessage(), true);
        }
    }

    public void collision() {
        boolean collisionDetected = false;

        double curr_world_linear_accel_x = ahrs.getWorldLinearAccelX();
        double currentJerkX = curr_world_linear_accel_x - last_world_linear_accel_x;
        last_world_linear_accel_x = curr_world_linear_accel_x;
        double curr_world_linear_accel_y = ahrs.getWorldLinearAccelY();
        double curretJerkY = curr_world_linear_accel_y - last_world_linear_accel_y;
        last_world_linear_accel_y = curr_world_linear_accel_y;

        if ((Math.abs(currentJerkX) > kCollisionThreshold_DeltaG) || (Math.abs(currentJerkY) > kCollisionThreshold_DeltaG)) {
            collisionDetected = true;
        }

        /*try {
            myRobot.mecanumDrive_Cartesian(_joystick.getX(), _joystick.getY(), _joystick.getTwist(), 0);
        } catch (RuntimeException ex) {
            String err_string = "Drive System ERROR: " + ex.getMessage();
            DriverStation.reportError(err_string, true);
        }*/
    }
}