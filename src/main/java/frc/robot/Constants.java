/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;

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
        kDriveEncoderTicksPerRev = 20;
    
    // Drivetrain Control Constants
    public static final double
        kDriveP = .017,
        kDriveI = 0,
        kDriveD = 0.05,
        kDriveVMax = 8.62,
        kDriveA = 0,
        kDriveWheelDiameter = 0.5,
        kDriveGearRatio = 10.75,
        MIN_AXIS = -1,
        MAX_AXIS = 1,
        LOW_RANGE_TURN = 0.2,
        HIGH_RANGE_TURN = 1; //10.75:1

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
    public static double
        kWristF = 1.2035,
        kWristP = 0.465, //0.465
        kWristI = 0,
        kWristD = 4.65;

    public static final int
        kWristCruiseVelocity = 64,
        kWristAcceleration = 64;
    
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
        kHatchButton = 5,
        kWristGroundIntakeButton = 1,
        kMiniJoystickAxis = 0,
        kDeployClimbersButton = 0,
        kFrontClimbersButton = 0,
        kBackClimberButton = 0;
    
    // Pneumatic Constants
    public static final int
        kForwardChannel = 0,
        kReverseChannel = 1,
        kCompressorPort = 0;
    
    // Limit Switch Ports
    public static final int 
        kZeroSwitchChannel = 4,
        kFrontTopLimit = 5,
        kFrontBottomLimit = 6,
        kBackTopLimit = 7,
        kBackBottomLimit = 8;
    
    // Wrist Position Constants
    public static final int
        kWristIntakeCargoPosition = 0,
        kWristIntakeCargoFromHuman = 0,
        kWristIntakeHatchPosition = 0,
        kWristOuttakeCargoLow = 0,
        kWristOuttakeHatchLow = 0,
        kWristOuttakeCargoMid = 0,
        kWristOuttakeHatchMid = 0;
    
    // Arm Position Constants
    public static final int
        kArmIntakeCargoPosition = 0,
        kArmIntakeHatchPosition = 0,
        kArmOuttakeCargoLow = 0,
        kArmOuttakeHatchLow = 0,
        kArmOuttakeCargoMid = 0,
        kArmOuttakeHatchMid = 0;
    
    // Ground Intake
    public static final int 
        kGroundIntakePivot = 9,
        kGroundIntakeWheels = 2,
        kGroundWheelButton = 6,
        kGroundWheelIntake = 12;
    
    // Climber
    public static final int
        kClimberWheel = 0,
        kBackClimber = 0,
        kFrontClimber = 0;

    // Testing Joystick
    public static final int
        kTestWristMM = 1;
}
