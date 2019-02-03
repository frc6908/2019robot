/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Subsystem that controls the wrist mechanism to angle the intake
 */
public class Wrist extends Subsystem {
  
  private WPI_TalonSRX
    wristMotor = RobotMap.wristMotor;

  public void setPosition(int position) {
    wristMotor.set(position);
  }
  
  public void setSpeed(double speed) {
    wristMotor.set(speed);
  }
  
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
