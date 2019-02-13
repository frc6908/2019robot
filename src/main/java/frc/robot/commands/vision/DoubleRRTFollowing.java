/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.vision;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Constants;
import frc.robot.Robot;

public class DoubleRRTFollowing extends Command {
  private double prev, offset, turn, area1, area2, throttleRight, throttleLeft, cameraWidth;

  public DoubleRRTFollowing() {
    requires(Robot.vision);
  }

  @Override
  protected void initialize() {
    System.out.println("Entered Vision Command");
    prev = 0;
    offset = 0;
    turn = 0;
    area1 = 0;
    area2 = 0;
    throttleRight = 0;
    throttleLeft = 0;
    cameraWidth = Constants.kCameraWidth;
    // initialize network tables
  }

  // Move the robot according to the values recieved from the vision coprocessor
  @Override
  protected void execute() {
    // Retrieve values regarding RRT attributes
    // double tapeCenter = Vision.getTapeCenter();
    double centerX = Robot.vision.getCenterX();
    area1 = Robot.vision.getLeftTapeSize();
    area2 = Robot.vision.getRightTapeSize();
    if (centerX == 0) offset = 0;
    else offset = (cameraWidth/2)-centerX;

    double averageSize = (area1 + area2)/2;

    // System.out.println((area1+area2)/2);
    
    // double tapeSize = Vision.getTapeSize();

    throttleRight = (Constants.kThrottleP/area1);
    throttleLeft = (Constants.kThrottleP/area2);
    if(throttleRight > 1) throttleRight = 1;
    if (throttleLeft > 1) throttleLeft = 1;

    System.out.println("throttleLeft : " + throttleLeft);
    System.out.println("throttle right: " + throttleRight);

    turn = (offset * Constants.kTurnP) + (Constants.kTurnD * ((offset - prev) / Constants.kDT));
    prev = offset;

    Robot.drivetrain.infuzedDrive(throttleLeft-turn, throttleRight + turn);
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
    Robot.drivetrain.infuzedDrive(0, 0);
  }

  @Override
  protected void interrupted() {
  }
}
