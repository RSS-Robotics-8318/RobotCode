/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import frc.robot.commands.Transporter.TransporterIn;
import frc.robot.commands.Transporter.TransporterOut;
import frc.robot.commands.intake.intakeIn;
import frc.robot.commands.intake.intakeOut;
import frc.robot.commands.roboarm.RoboArmUp;
import frc.robot.commands.roboarm.RoboArmDown;
import frc.robot.commands.roboarm.RoboLift;
import frc.robot.commands.roboarm.RoboLower;
/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  Gamepad driverGamepad = new Gamepad(RobotMap.DRIVER_GAMEPAD_PORT);

  public OI() {
    bindControls();
  }

  public void bindControls() {
    driverGamepad.getButtonA().toggleWhenPressed(new TransporterIn());
    driverGamepad.getButtonB().toggleWhenPressed(new TransporterOut());
    driverGamepad.getButtonA().toggleWhenPressed(new intakeIn());
    driverGamepad.getButtonB().toggleWhenPressed(new intakeOut());
    driverGamepad.getRightShoulder().whileHeld(new RoboArmUp());
    driverGamepad.getLeftShoulder().whileHeld(new RoboArmDown());
    driverGamepad.getStartButton().whileHeld(new RoboLift());
    driverGamepad.getBackButton().whileHeld(new RoboLower());
  }

  public double getDriverGamepadLeftY() {
    double y = driverGamepad.getLeftY();
    return y;
  }

  public double getDriverGamepadRightX() {
    double x = driverGamepad.getRightX();
    return x;
  }
}
