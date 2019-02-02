/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.arm.ManualArmControl;

/**
 * Subsystem that controls the arm mechanism
 */
public class Arm extends Subsystem {

  private WPI_TalonSRX
    armMotor = RobotMap.armMotor;

  public void setAngle(double angle) {
    armMotor.set(angle);
  }

  public void setMotorSpeed(double speed) {
    armMotor.set(speed);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
   setDefaultCommand(new ManualArmControl());
  }
}
