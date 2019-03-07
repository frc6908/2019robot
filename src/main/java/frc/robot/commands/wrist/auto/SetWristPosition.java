/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.wrist.auto;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class SetWristPosition extends Command {
  private double
    position;

  public SetWristPosition(double position) {
    
    this.position = position;
    requires(Robot.wrist);
  }

  @Override
  protected void initialize() {
    Robot.wrist.setPosition(position);
  }

  @Override
  protected void execute() {
  }

  @Override
  protected boolean isFinished() {
    return (Math.abs(Robot.wrist.wristMotor.getSelectedSensorPosition() - position) < 75);
  }

  @Override
  protected void end() {
  }

  @Override
  protected void interrupted() {
  }
}
