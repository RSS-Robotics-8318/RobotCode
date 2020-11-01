/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

    // gamepad ports

    public static final int DRIVER_GAMEPAD_PORT = 0;
 
    //spark
    
    public static final int INTAKE_PORT = 4;
    public static final int TRANSPORTER_PORT = 1;
    public static final int ARM = 2; 
	public static final int ARM_LIFT = 3; 

    //VictorSPX

    public static final int RTFRNT = 1;
    public static final int RTBCK = 2;
    public static final int LTFRNT = 3;
    public static final int LTBCK = 4;
}
