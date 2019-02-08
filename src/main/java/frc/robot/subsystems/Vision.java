/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.vision.RRTFollowing;

/**
 * Subsystem that controls all robot vision processing capabilities
 */
public class Vision extends Subsystem {
  
  // Add NetworkTables stuff here
  
  @Override
  public void initDefaultCommand() {
    // setDefaultCommand(new RRTFollowing());
  }
}
