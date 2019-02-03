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
        kfrontLeftMotor = 0,
        kbackleftMotor = 0,
        kfrontRightMotor = 0,
        kbackRightMotor = 0,
        kLeftDriveEncoderChannelA = 0,
        kLeftDriveEncoderChannelB = 0,
        kRightDriveEncoderChannelA = 0,
        kRightDriveEncoderChannelB = 0,
        kDriveEncoderTicksPerRev = 255;
    
    // Drivetrain Control Constants
    public static final double
        kDriveP = 0.001,
        kDriveI = 0.0001,
        kDriveD = 0.0001,
        kDriveVMax = 9.08,
        kDriveA = 0,
        kDriveWheelDiameter = 0.5;

    // Arm Subsystem Ports
    public static final int
        kArmMotor = 0;

    // Wrist Subsystem Ports
    public static final int
        kWristMotor = 0;
    
    public static final int
        kLeftIntakeMotor = 0,
        kRightIntakeMotor = 0;

    // Vision Control Constants
    public static final double
        kThrottleP = 125,
        kTurnP = 0.0015,
        kTurnD = 0.00025;

    // Joystick Constants
    public static final int
        kLeftStickPort = 0,
        kRightStickPort = 1;
    
    // Pneumatic Constants
    public static final int
        kForwardChannel = 0,
        kReverseChannel = 1;
}
