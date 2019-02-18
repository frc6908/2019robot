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

public class RampToLeftCargoShip extends CommandGroup {
  /**
   * Add your docs here.
   */
  public RampToLeftCargoShip() {
    System.out.println("Running RampToCargoShip");
    Trajectory l = Pathfinder.readFromCSV(new File("/home/lvuser/deploy/RampToLeftCargoShip_left.csv"));
    Trajectory r = Pathfinder.readFromCSV(new File("/home/lvuser/deploy/RampToLeftCargoShip_right.csv"));

    addSequential(new DrivePath(l, r, false));
  }
}
