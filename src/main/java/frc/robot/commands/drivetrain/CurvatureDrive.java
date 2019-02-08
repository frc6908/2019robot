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

public class CurvatureDrive extends Command {
  public CurvatureDrive() {
    requires(Robot.drivetrain);
  }

  @Override
  protected void initialize() {
      RobotMap.gyro.reset();
      Robot.drivetrain.stop();
  }

  @Override
  protected void execute() {
      double speed = 0.5*-Robot.oi.operatorController.getY(Hand.kRight);
      double turn = 0.5*Robot.oi.operatorController.getX(Hand.kRight);
      boolean quick = Robot.oi.operatorController.getBumper(Hand.kLeft);
      Robot.drivetrain.curve(speed, turn, quick);
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
