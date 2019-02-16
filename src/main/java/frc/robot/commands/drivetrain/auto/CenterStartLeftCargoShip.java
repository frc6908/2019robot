/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.drivetrain.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;

import java.io.File;

public class CenterStartLeftCargoShip extends CommandGroup {
  /**
   * Add your docs here.
   */
  public CenterStartLeftCargoShip(boolean reversed) {
    System.out.println("Running CenterStartLeftCargoShip");
    Trajectory l = Pathfinder.readFromCSV(new File("/home/lvuser/deploy/CenterStartLeftCargoShip_left.csv"));
    Trajectory r = Pathfinder.readFromCSV(new File("/home/lvuser/deploy/CenterStartLeftCargoShip_right.csv"));

    addSequential(new DrivePath(l, r, reversed));
  }
}
