/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Transporter;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class TransporterIn extends CommandBase {
  final double INTAKE_POWER = 1.0;

  public TransporterIn() {
    addRequirements(Robot.transporter);
  }

  @Override
  public void execute() {
    Robot.transporter.transporterIntake(INTAKE_POWER);
  }

  @Override
  public boolean isFinished() {
    return false;
  }

  //@Override
  public void end() {
    Robot.transporter.stopMotorIn();
  }

  //@Override
  public void interrupted() {
    Robot.transporter.stopMotorIn();
  }
}
