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

public class NavXMonitor {

    private AHRS ahrs;

    public NavXMonitor () {
        try {
            ahrs = new AHRS(SPI.Port.kMXP); 
        } catch (RuntimeException ex) {
            DriverStation.reportError("Error instantiating navX-MXP:  " + ex.getMessage(), true);
        }
    }

    public void monitor() {
        boolean zero_yaw_pressed = _joystick.getTrigger();

        if (zero_yaw_pressed) ahrs.zeroYaw();

        SmartDashboard.putBoolean("IMU_Connected",     ahrs.isConnected());
        SmartDashboard.putBoolean("IMU_IsCalibrating", ahrs.isCalibrating());
        SmartDashboard.putNumber("IMU_Yaw",            ahrs.getYaw());
        SmartDashboard.putNumber("IMU_Pitch",          ahrs.getPitch());
        SmartDashboard.putNumber("IMU_Roll",           ahrs.getRoll());

        SmartDashboard.putNumber("IMU_CompassHeading", ahrs.getCompassHeading());
        SmartDashboard.putNumber("IMU_FusedHeading",   ahrs.getCompassHeading());

        SmartDashboard.putNumber("IMU_TotalYaw",       ahrs.getAngle());
        SmartDashboard.putNumber("IMU_YawRateDPS",     ahrs.getRate());

        SmartDashboard.putNumber("IMU_Accel_X",        ahrs.getWorldLinearAccelX());
        SmartDashboard.putNumber("IMU_Accel_Y",        ahrs.getWorldLinearAccelY());
        SmartDashboard.putBoolean("IMU_IsMoving",      ahrs.isMoving());
        SmartDashboard.putBoolean("IMU_IsRotating",    ahrs.isRotating());

        SmartDashboard.putNumber("Velocity_X",         ahrs.getVelocityX());
        SmartDashboard.putNumber("Velocity_Y",         ahrs.getVelocityY());
        SmartDashboard.putNumber("Displacement_X",     ahrs.getDisplacementX());
        SmartDashboard.putNumber("Displacement_Y",     ahrs.getDisplacementY());

        SmartDashboard.putNumber("RawGyro_X",          ahrs.getRawGyroX());
        SmartDashboard.putNumber("RawGyro_Y",          ahrs.getRawGyroY());
        SmartDashboard.putNumber("RawGyro_Z",          ahrs.getRawGyroZ());
        SmartDashboard.putNumber("RawAccel_X",         ahrs.getRawAccelX());
        SmartDashboard.putNumber("RawAccel_Y",         ahrs.getRawAccelY());
        SmartDashboard.putNumber("RawAccel_Z",         ahrs.getRawAccelZ());
        SmartDashboard.putNumber("RawMag_X",           ahrs.getRawMagX());
        SmartDashboard.putNumber("RawMag_Y",           ahrs.getRawMagY());
        SmartDashboard.putNumber("RawMag_Z",           ahrs.getRawMagZ());
        SmartDashboard.putNumber("IMU_Temp_C",         ahrs.getTempC());

        AHRS.BoardYawAxis yaw_axis = ahrs.getboardYawAxis();

        SmartDashboard.putString("YawAxisDirection",   yaw_axis.up ? "Up" : "Down");
        SmartDashboard.putNumber("YawAxis",            yaw_axis.board_axis.getValue());

        SmartDashboard.putString("FirmwareVersion",    ahrs.getFirmwareVersion());

        SmartDashboard.putNumber("QuaternionW",        ahrs.getQuaternionW());
        SmartDashboard.putNumber("QuaternionX",        ahrs.getQuaternionX());
        SmartDashboard.putNumber("QuaternionY",        ahrs.getQuaternionY());
        SmartDashboard.putNumber("QuaternionZ",        ahrs.getQuaternionZ());

        SmartDashboard.putNumber("IMU_Byte_Count",     ahrs.getByteCount());
        SmartDashboard.putNumber("IMU_Update_Count",   ahrs.getUpdateCount());
    }
}