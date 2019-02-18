/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.superstructure;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.drivetrain.auto.RampDrive;
import frc.robot.commands.drivetrain.auto.RampToLeftCargoShip;

import frc.robot.Constants;

public class CenterStartToLeftCargoShipHatch extends CommandGroup {
  /**
   * Add your docs here.
   */
  public CenterStartToLeftCargoShipHatch() {
    addSequential(new RampDrive());
    Constants.kDriveP = 0.001;
    Constants.kDriveD = 0.1;
    addSequential(new RampToLeftCargoShip());
    // outtake hatch
  }
}
