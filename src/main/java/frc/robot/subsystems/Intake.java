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

public class Intake extends Subsystem {

  Spark intakeMotor = new Spark(RobotMap.INTAKE_PORT);

  @Override
  public void initDefaultCommand() {
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(null);
  }

  public void intakeIn(double power) {
    intakeMotor.set(power);
  }

  public void intakeOut(double power) {
    intakeMotor.set(-power);
  }

  public void stopMotor() { 
    intakeMotor.stopMotor();
  }
}
