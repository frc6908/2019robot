/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.superstructure;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.Wait;
import frc.robot.commands.drivetrain.auto.CloseRocketToHatchPickup;
import frc.robot.commands.drivetrain.auto.HatchPickupToFarRocket;
import frc.robot.commands.drivetrain.auto.LeftStartCloseRocket;
import frc.robot.commands.pneumatics.OuttakeHatch;

public class LeftStartRocketMultiHatch extends CommandGroup {
  /**
   * Add your docs here.
   */
  public LeftStartRocketMultiHatch() {
    addSequential(new LeftStartCloseRocket(false));
    addSequential(new Wait(2));
    addSequential(new CloseRocketToHatchPickup(true));
    addSequential(new Wait(2));
    addSequential(new HatchPickupToFarRocket(false));
    addSequential(new OuttakeHatch(0.3));
  }
}
