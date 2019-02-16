/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.superstructure;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.drivetrain.auto.CenterStartLeftCargoShip;
import frc.robot.commands.pneumatics.OuttakeHatch;

public class CenterStartLeftCargoShipSingleHatch extends CommandGroup {
  /**
   * Add your docs here.
   */
  public CenterStartLeftCargoShipSingleHatch() {
    addSequential(new CenterStartLeftCargoShip(false));
    addSequential(new OuttakeHatch(0.3));
  }
}
