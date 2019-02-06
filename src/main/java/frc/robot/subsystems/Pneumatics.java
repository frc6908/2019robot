/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.pneumatics.Compressor;

/**
 * Add your docs here.
 */
public class Pneumatics extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public void turnOn ()
  {
    RobotMap.compressor.setClosedLoopControl(true);
  }

  public boolean getEnabled()
  {
      boolean enabled = RobotMap.compressor.enabled();
      return enabled;
      
  }

  public boolean getPressureSwitch()
  {
    boolean pressureSwitch = RobotMap.compressor.getPressureSwitchValue();
    return pressureSwitch;
  }

  public double getCurrent()
  {
    double current = RobotMap.compressor.getCompressorCurrent();
    return current;
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new Compressor());
  }
}
