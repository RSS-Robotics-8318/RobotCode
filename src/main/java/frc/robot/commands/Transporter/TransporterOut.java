/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Transporter;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class TransporterOut extends CommandBase {
  final double INTAKE_POWER = 1.0;

  public TransporterOut() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    addRequirements(Robot.transporter);
  }

  // Called just before this Command runs the first time
  @Override
  public void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
    Robot.transporter.transporterOuttake(INTAKE_POWER);
  }
  
  // Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  //@Override
  public void end() {
    Robot.transporter.stopMotorIn();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  //@Override
  public void interrupted() {
    Robot.transporter.stopMotorIn();
  }
}
