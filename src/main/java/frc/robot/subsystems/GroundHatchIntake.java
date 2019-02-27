/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.groundintake.PivotGroundHatch;

/**
 * Add your docs here.
 */
public class GroundHatchIntake extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public Spark
    wheels = RobotMap.groundIntakeWheels;

  public WPI_TalonSRX
    pivoter = RobotMap.groundIntakeMotor;

  public void intake() {
    wheels.set(.5);
  }

  public void outtake() {
    wheels.set(-1);
  }

  public void pivot(double speed) {
    RobotMap.groundIntakeMotor.set(speed);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new PivotGroundHatch());
  }
}
