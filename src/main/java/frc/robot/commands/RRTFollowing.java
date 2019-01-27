/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.networktables.*;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class RRTFollowing extends Command {
  public RRTFollowing() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.vision);
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
    // initaialize network tables
    NetworkTableInstance inst = NetworkTableInstance.getDefault();
    NetworkTable table = inst.getTable("RRTFollowing");
    xEntry1 = table.getEntry("centerX1");
    yEntry1 = table .getEntry("centerY1");
    size1 = table.getEntry("size1");
    xEntry2 = table.getEntry("centerX2");
    yEntry2 = table .getEntry("centerY2");
    size2 = table.getEntry("size2");
  }

  // Move the robot according to the values recieved from the vision coprocesor
  @Override
  protected void execute() {
    //double centerX = xEntry1.getDouble(-1000) + (xEntry2.getDouble(-1000) - xEntry1.getDouble(-1000))/2;
    double centerX = xEntry1.getDouble(-1000);
    double size = size1.getDouble(-1000);
    //double blob1 = size1.getDouble(-1000); 
    //double blob2 = size2.getDouble(-1000);
    double offset = 160-centerX;
    System.out.println("centerX: " + centerX);
    double turn = (offset * 0.002);
    double throttle = 250/size;
    System.out.println("Turn: " + turn);
    System.out.println("Throttle: " + throttle);
    Robot.drivetrain.infuzedDrive(throttle-turn, throttle+turn);
    // if (Math.abs(offset) > 30 && centerX != -1000) {
      // if statements to compare size - get throttle from this
      // if(size>7000) throttle = -0.3;
      //else if(size < 1000) throttle = 0.3;
      //else throttle = 0.2;
      // else throttle = 0.3;
      // Robot.drivetrain.infuzedDrive(-turn, turn);
      // Robot.drivetrain.infuzedDrive(throttle-turn, throttle+turn);
    }
    
   // Robot.drivetrain.drive(0, 0);

    

  //}

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
