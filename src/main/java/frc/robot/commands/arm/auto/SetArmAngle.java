/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.arm.auto;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Constants;
import frc.robot.Robot;

public class SetArmAngle extends Command {
  private double angle;
  private double kP = 1.0, kD = 0.5;
  private double error;

  public SetArmAngle(double angle) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    this.angle = angle;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    error = angle - (90 - Robot.arm.getAngle()); // 90 - is angle over the horizontal
    double speed = kP * error + kD * error / Constants.kDT;
    Robot.arm.setSpeed(speed);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return (Math.abs(error-Robot.arm.getAngle()) <= 10);
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    System.out.println("Finished setting arm angle");
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
