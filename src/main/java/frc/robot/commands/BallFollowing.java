/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import jdk.jshell.execution.StreamingExecutionControl;

public class BallFollowing extends Command {

  NetworkTableEntry xEntry;
  NetworkTableEntry yEntry;
  NetworkTableEntry sizeEntry;
  NetworkTable table;
  NetworkTableInstance inst;

  public BallFollowing() {
    // Use requires() here to declare subsystem dependencies
    // requires(Robot.vision);
    requires(Robot.vision);
    requires(Robot.drivetrain);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    inst = NetworkTableInstance.getDefault();
    table = inst.getTable("BallFollowing");
    xEntry = table.getEntry("centerX");
    yEntry = table.getEntry("centerY");
    sizeEntry = table.getEntry("size");

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double centerX = xEntry.getDouble(-1000);
    double centerY = yEntry.getDouble(-1000);
    double size = sizeEntry.getDouble(-1000);
    System.out.println("X: " + centerX);
    System.out.println("Y: " + centerY);
    System.out.println("Size: " + size);
    System.out.println("-----------------------------------");
    System.out.println();
    System.out.println(Robot.drivetrain.leftMotors.get());
    System.out.println(Robot.drivetrain.rightMotors.get());
    
    if(size <= 20) Robot.drivetrain.infuzedDrive(0.5, 0.5); // speed up if it's far away
    else if(size >= 50) Robot.drivetrain.infuzedDrive(-0.5, -0.5); // reverse if it's too close
    else Robot.drivetrain.infuzedDrive(0.4, 0.4); // normal speed
  }

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
