/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Transporter;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class TransporterIn extends Command {
  final double INTAKE_POWER = 1.0;

  public TransporterIn() {
    requires(Robot.transporter);
  }

  @Override
  protected void execute() {
    Robot.transporter.transporterIntake(INTAKE_POWER);
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
    Robot.transporter.stopMotorIn();
  }

  @Override
  protected void interrupted() {
    Robot.transporter.stopMotorIn();
  }
}
