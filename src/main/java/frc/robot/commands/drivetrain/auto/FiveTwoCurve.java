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

public class FiveTwoCurve extends CommandGroup {
  /**
   * Add your docs here.
   */
  public FiveTwoCurve() {
    System.out.println("Running FiveTwoCurve");
    Trajectory l = Pathfinder.readFromCSV(new File("/home/lvuser/deploy/FiveTwoCurve_left.csv"));
    Trajectory r = Pathfinder.readFromCSV(new File("/home/lvuser/deploy/FiveTwoCurve_right.csv"));

    addSequential(new DrivePath(l, r, false));
  }
}
