/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;

public class RoboArm extends Subsystem {
  
  //Declare Victor
  Spark _arm = new Spark(RobotMap.ARM);
  Spark _lift = new Spark(RobotMap.ARM_LIFT);

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(null);
  }

  
  public void RoboArmUp(double power) {

    _arm.set(power);

  }

  public void RoboArmDown(double power) {

    _arm.set(-power);

  }

  public void RoboLift(double power) {

    _lift.set(power);

  }

  public void RoboLower(double power) {

    _lift.set(-power);

  }

  public void stopRoboArm(){

    _arm.stopMotor();
    _lift.stopMotor();

  }
}
