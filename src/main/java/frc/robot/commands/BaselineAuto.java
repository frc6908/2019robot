/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.io.File;

import edu.wpi.first.wpilibj.command.CommandGroup;
import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;

public class BaselineAuto extends CommandGroup {
  /**
   * Add your docs here.
   */
  public BaselineAuto() {
    Trajectory l = Pathfinder.readFromCSV(new File("/home/lvuser/deploy/FiveFootAuto_left.csv"));
    Trajectory r = Pathfinder.readFromCSV(new File("/home/lvuser/deploy/FiveFootAuto_left.csv"));
    
    addSequential(new AutoDrive(l, r));
  }
}
