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

public class RRTFollowing extends Command {
  private double prev, offset, turn, size, throttle;

  public RRTFollowing() {
    requires(Robot.vision);
  }
  NetworkTableEntry xEntry1;
  NetworkTableEntry yEntry1;
  NetworkTableEntry xEntry2;
  NetworkTableEntry yEntry2;
  NetworkTableEntry size1;
  NetworkTableEntry size2;

  @Override
  protected void initialize() {
    System.out.println("Entered single vision command");
    prev = 0;
    offset = 0;
    turn = 0;
    size = 0;
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
    double centerX = xEntry1.getDouble(-1000);
    System.out.println("centerX" + centerX);
    if(centerX == 0) offset = 0;
    else offset = 160-centerX;
    // double tapeSize = Vision.getTapeSize();
    double size = size1.getDouble(0);
    // System.out.println("Offset: " + offset);
    // System.out.println("Size: " + size);
    if(size == 0) throttle = 0;
    else throttle = Constants.kThrottleP/size;
    if(throttle > 1) {System.out.println("going over 1");}
    if(throttle > 1) throttle = 1;
    // System.out.println("Throttle: " + throttle);
    turn = (offset * Constants.kTurnP) + (Constants.kTurnD * ((offset - prev) / Constants.kDT));
    prev = offset;
    // System.out.println("Turn: " + turn);
    Robot.drivetrain.infuzedDrive(throttle-turn, throttle+turn);
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
  }

  @Override
  protected void interrupted() {
  }
}
