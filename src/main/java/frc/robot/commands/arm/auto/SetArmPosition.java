/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.arm.auto;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class SetArmPosition extends Command {
  private double
    position;

  public SetArmPosition(double position) {
    this.position = position;
    requires(Robot.arm);
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    Robot.arm.setPosition(position);
  }

  @Override
  protected boolean isFinished() {
    return (Math.abs(Robot.arm.armMasterMotor.getSelectedSensorPosition() - position) < 10);
  }

  @Override
  protected void end() {
    Robot.arm.setVoltage(0);
  }

  @Override
  protected void interrupted() {
  }
}
