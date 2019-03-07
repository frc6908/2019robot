/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.pneumatics.CompressorManager;

/**
 * Subsystem that controls the pneumatic hatch plate system
 */
public class Pneumatics extends Subsystem {
  public DoubleSolenoid
    solenoidOuttake = RobotMap.solenoidOuttake;

  public void turnOn() {
    RobotMap.compressor.setClosedLoopControl(true);
  }

  public void turnOff() {
    RobotMap.compressor.setClosedLoopControl(false);
  }

  public boolean getEnabled() {
      boolean enabled = RobotMap.compressor.enabled();
      return enabled;
  }

  public boolean getPressureLow() {
    return !RobotMap.compressor.getPressureSwitchValue();
  }

  public double getCurrent() {
    double current = RobotMap.compressor.getCompressorCurrent();
    return current;
  }
  
  // forwards is true, backwards is false
  public void setSolenoidPosition(boolean forwardBack) {
    if(forwardBack)
      solenoidOuttake.set(DoubleSolenoid.Value.kForward);
    else
      solenoidOuttake.set(DoubleSolenoid.Value.kReverse);

    // long storeTime = System.currentTimeMillis();
    // while(System.currentTimeMillis() - storeTime <= 0.3) {
    //   // Wait for some time
    // }
    // solenoidOuttake.set(DoubleSolenoid.Value.kOff);
  }


  @Override
  public void initDefaultCommand() {
    // setDefaultCommand(new CompressorManager());
  }
}
