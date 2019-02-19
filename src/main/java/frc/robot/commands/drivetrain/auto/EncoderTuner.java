/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.drivetrain.auto;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.RobotMap;

public class EncoderTuner extends Command {

  double calculated_value, encoder_tick;
  double encoder_tick_count = 215, wheel_circumference = 0.5, last_error = 0;
  double kp = 0.01, 
         kd = 0;

  public EncoderTuner() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    encoder_tick = RobotMap.leftDriveEncoder.get();
    double distance_covered = ((double)(encoder_tick) / encoder_tick_count)
    * wheel_circumference;
    double error = 0 - distance_covered;
    calculated_value =
      kp * error +                                    // Proportional
      kd * ((error - last_error) / 20);          // Derivative
    last_error = error;
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
