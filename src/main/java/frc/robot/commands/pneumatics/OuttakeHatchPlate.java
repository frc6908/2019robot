/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.pneumatics;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class OuttakeHatchPlate extends Command {
  private final boolean
    in = false,
    out = true;

  private final long
    delay = 500;

  public OuttakeHatchPlate() {
    requires(Robot.pneumatics);
  }

  @Override
  protected void initialize() {
    Robot.pneumatics.setSolenoidPosition(in);
  }

  @Override
  protected void execute() {
    if(Robot.oi.operatorController.getBumper(Hand.kLeft)) {
      long actuationTime = System.currentTimeMillis();
      Robot.pneumatics.setSolenoidPosition(out);
      while(System.currentTimeMillis() - actuationTime < delay) {
        // Wait for 0.5s to pass before resetting the piston
      }
      Robot.pneumatics.setSolenoidPosition(in);
    }
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