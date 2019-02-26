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

public class VisionAlign extends Command {
  private double prev, offset, turn, cameraWidth;

  public VisionAlign() {
    requires(Robot.vision);
  }

  @Override
  protected void initialize() {
    prev = 0;
    offset = 0;
    turn = 0;
    cameraWidth = Constants.kCameraWidth;
    // initialize network tables
  }

  // Move the robot according to the values recieved from the vision coprocessor
  @Override
  protected void execute() {
    // Retrieve values regarding RRT attributes
    double centerX = Robot.vision.getRightTapeX();
    if (centerX == 0) offset = 0;
    else offset = (cameraWidth/2)-centerX;

    turn = (offset * Constants.kTurnP) + (Constants.kTurnD * ((offset - prev) / Constants.kDT));
    prev = offset;

    Robot.drivetrain.infuzedDrive(-turn, turn);
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
