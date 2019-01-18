/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.commands.lineFollowingRPI;
import frc.robot.*;

/**
 * Add your docs here.
 */
public class Vision extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public SpeedControllerGroup
        leftMotors = new SpeedControllerGroup(RobotMap.frontLeftDrive, RobotMap.backleftDrive),
        rightMotors = new SpeedControllerGroup(RobotMap.frontRightDrive, RobotMap.backRightDrive);
  
  public DifferentialDrive drive; 
  public Vision() {
    rightMotors.setInverted(true);
    drive = new DifferentialDrive(leftMotors, rightMotors);
  }

  /**
 * Distance to a surface using an Analog Rangefinder
 * @param inORcm 0 for inches, 1 for centimeters 
 */
  public double getDistance(int inORcm)
  {
    double distanceInMM;
    double scaleIn = 0.03937007874, scaleCm = .1;
    distanceInMM = ((RobotMap.ultrasonicRangefinder.getVoltage()) / 4.88) * 5.0;
    if (inORcm == 0)
    {
      return distanceInMM * scaleIn;
    }
    else if (inORcm == 1)
    {
      return distanceInMM * scaleCm;
    }
    else
    {
      return -1.0;
    }
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new lineFollowingRPI());
  }
}
