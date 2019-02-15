/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.intake.IntakeOuttake;

/**
 * Subsystem that controls cargo ball intake functionality
 */
public class Intake extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private Spark
    leftIntakeMotor = RobotMap.leftIntakeMotor,
    rightIntakeMotor = RobotMap.rightIntakeMotor;
    
  public void setLeftIntakeMotor(double speed) {
    leftIntakeMotor.set(speed);
  }

  public void setRightIntakeMotor(double speed) {
    rightIntakeMotor.set(speed);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new IntakeOuttake());
  }
}
