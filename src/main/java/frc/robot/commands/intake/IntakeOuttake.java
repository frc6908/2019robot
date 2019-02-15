/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.intake;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class IntakeOuttake extends Command {
  public IntakeOuttake() {
    requires(Robot.intake);
  }

  @Override
  protected void initialize() {
    System.out.println("Entering IntakeOuttake default command");
  }

  @Override
  protected void execute() {
    // Outtake
    Robot.intake.setLeftIntakeMotor(Robot.oi.operatorController.getTriggerAxis(Hand.kLeft));
    Robot.intake.setRightIntakeMotor(-(Robot.oi.operatorController.getTriggerAxis(Hand.kLeft)));
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
