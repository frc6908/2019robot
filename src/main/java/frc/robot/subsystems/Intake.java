/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Intake extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private Spark
    leftIntakeMotor = RobotMap.leftIntakeMotor,
    rightIntakeMotor = RobotMap.rightIntakeMotor;
  
  private DoubleSolenoid
    solenoidOuttake = RobotMap.solenoidOuttake;

  public void setLeftIntakeMotor(double speed) {
    leftIntakeMotor.set(speed);
  }

  public void setRightIntakeMotor(double speed) {
    rightIntakeMotor.set(speed);
  }
  
  // forwards is true, backwards is false
  public void setSolenoidPosition(boolean forwardBack) {
    if(forwardBack)
      solenoidOuttake.set(Value.kForward);
    else
      solenoidOuttake.set(Value.kReverse);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
