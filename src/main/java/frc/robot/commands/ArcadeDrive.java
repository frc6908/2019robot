/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class ArcadeDrive extends Command {
  public ArcadeDrive() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.drivetrain);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
      RobotMap.gyro.reset();
      Robot.drivetrain.stop();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
      double speed = 0.8*-Robot.oi.controller.getY(Hand.kRight);
      double turn = 0.8*Robot.oi.controller.getX(Hand.kRight);
      //double accel = (0.5+(Robot.oi.controller.getTriggerAxis(Hand.kLeft)*0.5));
      boolean quick = Robot.oi.controller.getBumper(Hand.kLeft);
      Robot.drivetrain.curve(speed, turn, quick);
      //System.out.println("-------------------------------");
      //System.out.println(RobotMap.leftDriveEncoder.get());
      //System.out.println(RobotMap.rightDriveEncoder.get());
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
