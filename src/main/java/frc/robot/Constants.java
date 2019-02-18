/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * Holds all constants for robot ports and control constants
 */
public class Constants {
    // Universal Constants
    public static final double
        kDT = 0.02;

    // Drivetrain Subsystem Ports
    public static final int
        kfrontLeftMotor = 2,
        kbackleftMotor = 4,
        kfrontRightMotor = 5,
        kbackRightMotor = 3,
        kLeftDriveEncoderChannelA = 2,
        kLeftDriveEncoderChannelB = 3,
        kRightDriveEncoderChannelA = 0,
        kRightDriveEncoderChannelB = 1,
        kDriveEncoderTicksPerRev = 255;
    
    // Drivetrain Control Constants
    public static double
        kDriveP = 0.022,
        kDriveI = 0,
        kDriveD = 0.1,
        kDriveVMax = 8.62,
        kDriveA = 0,
        kDriveWheelDiameter = 0.5;

    // Arm Subsystem Ports
    public static final int
        kArmMasterMotor = 6,
        kArmSlaveMotor = 7;

    // Arm Control Constants
    public static final double
        kArmF = 0,
        kArmP = 0,
        kArmI = 0,
        kArmD = 0;
        
    public static final int
        kArmCruiseVelocity = 0,
        kArmAcceleration = 0;

    // Wrist Subsystem Ports
    public static final int
        kWristMotor = 8;

    // Wrist Control Constants
    public static final int
        kWristF = 0,
        kWristP = 0,
        kWristI = 0,
        kWristD = 0;

    public static final int
        kWristCruiseVelocity = 0,
        kWristAcceleration = 0;
    
    public static final int
        kLeftIntakeMotor = 0,
        kRightIntakeMotor = 1;

    // Vision Control Constants
    public static final double
        kThrottleP = 65,
        kTurnP = 0.002, //0.0015
        kTurnD = 0.0003,
        kCameraWidth = 320; //0.00025

    // Joystick Constants
    public static final int
        kDriveStickPort = 1,
        kAlignWithTargetButton = 8,
        kOperatorController = 3,
        kHatchButton = 5;
    
    // Pneumatic Constants
    public static final int
        kForwardChannel = 0,
        kReverseChannel = 1,
        kCompressorPort = 0;
}
