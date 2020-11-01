/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.Spark;

public class Transporter extends Subsystem {

  Spark transporterMotor = new Spark(RobotMap.TRANSPORTER_PORT);

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(null);
  }

  public void transporterIntake(double power) {
    transporterMotor.set(power);
  }

  public void transporterOuttake(double power) {
    transporterMotor.set(-power);
  }

  public void stopMotorIn() { 
   transporterMotor.stopMotor();
  }
}
