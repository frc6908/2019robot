/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class ArcadeDrive extends Command {
  public ArcadeDrive() {
    requires(Robot.drivetrain);
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    double turn = Robot.oi.driveStick.getX() * 0.5;
    double speed = -Robot.oi.driveStick.getY() * 0.5;
    Robot.drivetrain.infuzedDrive(speed + turn, speed - turn);
    // System.out.println("Left ticks: " + Robot.drivetrain.getLeftEncoderTicks());
    // System.out.println("Right ticks: " + Robot.drivetrain.getRightEncoderTicks());
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
