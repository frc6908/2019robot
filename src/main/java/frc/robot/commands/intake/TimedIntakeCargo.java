/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.intake;

import edu.wpi.first.wpilibj.command.TimedCommand;
import frc.robot.Robot;

public class TimedIntakeCargo extends TimedCommand {
  public TimedIntakeCargo(double timeout) {
    super(timeout);
    // requires(Robot.intake);
  }

  @Override
  protected void initialize() {
    // Robot.intake.setLeftIntakeMotor(1);
    // Robot.intake.setRightIntakeMotor(-1);
  }

  @Override
  protected void execute() {
  }

  @Override
  protected void end() {
  }

  @Override
  protected void interrupted() {
  }
}
