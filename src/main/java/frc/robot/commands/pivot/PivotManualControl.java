/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.pivot;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class PivotManualControl extends Command {
  public PivotManualControl() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.pivot);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    RobotMap.groundIntakeMotor.set(0);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if(Robot.oi.operatorController.getPOV() == 0)
    {
        RobotMap.groundIntakeMotor.set(0.3);
    }
    else if (Robot.oi.operatorController.getPOV() == 180)
    {
      RobotMap.groundIntakeMotor.set(-0.3);
    }
    else{
        RobotMap.groundIntakeMotor.set(0.15);
    }
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
