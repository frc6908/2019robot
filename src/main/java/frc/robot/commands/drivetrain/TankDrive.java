/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.drivetrain;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class TankDrive extends Command {
  public TankDrive() {
    // requires(Robot.drivetrain);
  }

  @Override
  protected void initialize() {
      RobotMap.gyro.reset();
      // Robot.drivetrain.stop();
  }

  @Override
  protected void execute() {
      // double leftSpeed = Robot.oi.controller.getY(Hand.kLeft);
      // double rightSpeed = Robot.oi.controller.getY(Hand.kRight);
      // double accel = (1-(Robot.oi.controller.getTriggerAxis(Hand.kLeft)*0.7));
      // Robot.drivetrain.drive(-leftSpeed*accel, -rightSpeed*accel);
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
  }

  @Override
  protected void interrupted() {
  }
}
