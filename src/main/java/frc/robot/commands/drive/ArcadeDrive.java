/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.drive;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

/**
 * ArcadeDrive - forward/backward controlled by the left stick, rotation controlled by the right
 */
public class ArcadeDrive extends CommandBase{
  public ArcadeDrive() {
    addRequirements(Robot.drivetrain);
  }

  // Called just before this Command runs the first time
  @Override
  public void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
    Robot.drivetrain.arcadeDrive(
      -Robot.m_oi.getDriverGamepadLeftY(), 
      Robot.m_oi.getDriverGamepadRightX() * 0.6);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  //removed @override, may cause errors later since the internet may be trolling me
  public void end() {
    Robot.drivetrain.stopDrive();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  //removed @override, may cause errors later since the internet may be trolling me
  public void interrupted() {
    Robot.drivetrain.stopDrive();
  }
}
