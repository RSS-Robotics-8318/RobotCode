/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.roboarm;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class RoboLower extends CommandBase {
  
  final double LIFT_POWER = 0.3;

  public RoboLower() {
    addRequirements(Robot.roboArm);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    Robot.roboArm.RoboLift(LIFT_POWER);

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  //@Override
  public void end() {
    Robot.roboArm.stopRoboArm();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  //@Override
  public void interrupted() {

    Robot.roboArm.stopRoboArm();

  }
}
