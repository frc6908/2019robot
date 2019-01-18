/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * Add your docs here.
 */
public class RobotConstants {
    // Drivetrain Constants
    public static final int
        kfrontLeftTalon = 2,
        kbackleftTalon = 3,
        kfrontRightTalon = 1,
        kbackRightTalon = 0,
        kLeftDriveEncoderChannelA = 0,
        kLeftDriveEncoderChannelB = 1,
        kRightDriveEncoderChannelA = 2,
        kRightDriveEncoderChannelB = 3,
        kDriveEncoderTicksPerRev = 255;

    // Joystick Constants
    public static final int
        kLeftStickPort = 0,
        kRightStickPort = 1;
    
    // Pathfinder Constants
    public static final double
        kP = 0.001,
        kI = 0.0001,
        kD = 0.0001,
        kVMax = 9.08,
        kA = 0,
        kWheelDiameter = 0.5;

    //Vision Constants
    public static final double
        kUltrasonicSensorChannel = 0,
        kScaleFactor = 5.0800027432;
}
