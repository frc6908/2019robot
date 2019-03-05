/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.climber.ClimberWheel;

/**
 * Add your docs here.
 */
public class Climber extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  // public VictorSP
  //   frontClimbers = RobotMap.frontClimber,
  //   backClimber = RobotMap.backClimber;

  // public Spark 
  //   climberWheel = RobotMap.climberWheel;

  public DigitalInput
    frontClimberTopLimit = RobotMap.frontClimberTopLimit,
    frontClimberBottomLimit = RobotMap.frontClimberBottomLimit,
    backClimberTopLimit = RobotMap.backClimberTopLimit,
    backClimberBottomLimit = RobotMap.backClimberBottomLimit;

  public void setClimberWheelSpeed(double speed) {
    // climberWheel.set(speed);
  }

  // public void deployClimbers() {
  //   frontClimbers.set(1);
  //   backClimber.set(1);
  // }

  // public void retractFrontClimber() {
  //   frontClimbers.set(-1);
  // }

  // public void retractBackClimber() {
  //   backClimber.set(-1);
  // }

  // public void deployFrontClimbers() {
  //   frontClimbers.set(1);
  // }

  // public void deployBackClimbers() {
  //   backClimber.set(1);
  // }

  public boolean getFrontClimberDeployed() {
    return frontClimberTopLimit.get();
  }

  public boolean getFrontClimberRetracted() {
    return frontClimberBottomLimit.get();
  }

  public boolean getBackClimberDeployed() {
    return backClimberTopLimit.get();
  }

  public boolean getBackClimberRetracted() {
    return backClimberBottomLimit.get();
  }

  // public void stop() {
  //   frontClimbers.set(0);
  //   backClimber.set(0);
  // }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new ClimberWheel());
  }
}
