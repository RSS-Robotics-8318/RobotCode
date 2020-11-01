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

public class NavXBalancing {

    private AHRS ahrs;
    private RobotDrive myRobot;

    private final static double kToleranceDegrees = 2.0f;
    private final static double rotateToAngleRate;

    private final static double kOffBalanceThresholdDegrees = 10;
    private final static double kOnBalanceThresholdDegrees = 5;

    private Joystick _joystick;

    public NavXBalancing(Joystick _joystick) {
        this._joystick = _joystick;
        myRobot = new RobotDrive(0, 1);
        myRobot.setExpiration(0.1);

        try {
            ahrs = new AHRS(SPI.Port.kMXP);
        } catch (RuntimeException ex) {
            DriverStation.reportError("Error instantiating navX-MXP:  " + ex.getMessage(), true);
        } 
    }

    public void balancing() {
        double xAxisRate = _joystick.GetX();
        double yAxisRate = _joystick.GetY();
        double pitchAngleDegrees = ahrs->GetPitch();
        double rollAngleDegrees = ahrs->GetRoll();

        if (!autoBalanceXMode && (fabs(pitchAngleDegrees) >= fabs(kOffBalanceThresholdDegrees))) {
            autoBalanceXMode = true;
        } else if (autoBalanceXMode && (fabs(pitchAngleDegrees) >= fabs(kOnBalanceThresholdDegrees))) {
            autoBalanceXMode = false;
        }

        if (!autoBalanceYMode && (fabs(pitchAngleDegrees) >= fabs(kOffBalanceThresholdDegrees))) {
            autoBalanceYMode = true;
        } else if (autoBalanceYMode && (fabs(pitchAngleDegrees) >= fabs(kOnBalanceThresholdDegrees))) {
            autoBalanceXMode = false;
        }


        if (autoBalanceXMode) {
            double pitchAngleRadians = pitchAngleDegrees * (Math.PI / 180.0);
            xAxisRate = Math.sin(pitchAngleRadians) * -1;
        }
        if (autoBalanceYMode) {
            double rollAngleRadians = rollAngleDegrees * (Math.PI / 180.0);
            yAxisRate = Math.sin(rollAngleRadians) * -1;
        }

        /*myRobot.mecanumDrive_Cartesian(xAxisRate, yAxisRate, _joystick.getTwist(),0);*/
        
        
        
        
        
        
        
        //malware
    }
}
