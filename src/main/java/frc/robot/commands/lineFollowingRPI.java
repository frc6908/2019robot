/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Robot;
import frc.robot.RobotConstants;
import edu.wpi.first.networktables.*;

public class lineFollowingRPI extends Command {


  NetworkTableEntry xEntry;
  NetworkTableEntry yEntry;

  DifferentialDrive drive;


  int imgWidth = 320;
  int imgHeight = 240;

  public lineFollowingRPI() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.drivetrain);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    NetworkTableInstance inst = NetworkTableInstance.getDefault();
    NetworkTable table = inst.getTable("lineFollowingRPI");
    xEntry = table.getEntry("centerX");
    yEntry = table .getEntry("centerY");

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    int centerX = (int)xEntry.getDouble(-1000);
    int centerY = (int)yEntry.getDouble(-1000);

    if (centerX != -1000 && centerY != -1000)
    {
      System.out.println();
      System.out.println("centerX: " + centerX);
      System.out.println("centerY: " + centerY);
      double turn = centerX - (imgWidth / 2);
      System.out.println("Turn: " + (turn*0.005));
      //drive.arcadeDrive(0.5, turn * 0.005);
      

    }
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
