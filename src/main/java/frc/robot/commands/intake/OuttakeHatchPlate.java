/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.intake;

import edu.wpi.first.wpilibj.command.TimedCommand;
import frc.robot.Robot;

public class OuttakeHatchPlate extends TimedCommand {
  public OuttakeHatchPlate() {
    // Use requires() here to declare subsystem dependencies
    super(1);
    requires(Robot.intake);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.intake.setSolenoidPosition(true);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.intake.setSolenoidPosition(false);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
