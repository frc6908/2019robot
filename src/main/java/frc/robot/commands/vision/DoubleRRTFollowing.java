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
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Constants;
import frc.robot.Robot;

public class DoubleRRTFollowing extends Command {
  private double prev, offset, turn, area1, area2, throttle;

  public DoubleRRTFollowing() {
    // Use requires() here to declare subsystem dependencies
    // requires(Robot.vision);
  }
  NetworkTableEntry xEntry1;
  NetworkTableEntry yEntry1;
  NetworkTableEntry xEntry2;
  NetworkTableEntry yEntry2;
  NetworkTableEntry size1;
  NetworkTableEntry size2;


  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    prev = 0;
    offset = 0;
    turn = 0;
    area1 = 0;
    area2 = 0;
    throttle = 0;
    // initaialize network tables
    NetworkTableInstance inst = NetworkTableInstance.getDefault();
    NetworkTable table = inst.getTable("RRTFollowing");
    xEntry1 = table.getEntry("centerX1");
    yEntry1 = table .getEntry("centerY1");
    size1 = table.getEntry("size1");
    xEntry2 = table.getEntry("centerX2");
    yEntry2 = table.getEntry("centerY2");
    size2 = table.getEntry("size2");
  }

  // Move the robot according to the values recieved from the vision coprocessor
  @Override
  protected void execute() {
    // Retrieve values regarding RRT attributes
    // double tapeCenter = Vision.getTapeCenter();
    double centerX = xEntry1.getDouble(-1000) + ((xEntry2.getDouble(-1000) - xEntry1.getDouble(-1000))/ 2);
    area1 = size1.getDouble(0);
    area2 = size2.getDouble(0);
    if(centerX == 0) offset = 0;
    else offset = 160-centerX;
    // double tapeSize = Vision.getTapeSize();

    throttle = Constants.kThrottleP/area1;
    if(throttle > 1) throttle = 1;
    turn = (offset * Constants.kTurnP) + (Constants.kTurnD * ((offset - prev) / Constants.kDT));
    prev = offset;
    // if (Math.abs(throttle - turn) >= 0.05)
      // Robot.drivetrain.infuzedDrive(throttle-turn, throttle+turn);
    // else if (area1 != 0 && area2 != 0) {
      double difference = (area1 - area2) * 0.002;
      // Robot.drivetrain.infuzedDrive(-difference, difference);
    }
      
  // }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
