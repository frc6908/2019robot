/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.superstructure;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.arm.auto.SetArmPosition;
import frc.robot.commands.wrist.auto.SetWristPosition;

public class SuperstructurePose extends CommandGroup {
  /**
   * @param wristPos Wrist position to set in ticks
   * @param armPos Arm position to set in ticks
   */
  public SuperstructurePose(int wristPos, int armPos) {
    addSequential(new SetWristPosition(wristPos));
    addParallel(new SetArmPosition(armPos));
  }
}
