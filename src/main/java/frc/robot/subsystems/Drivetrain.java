/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import frc.robot.commands.drivetrain.ArcadeDrive;
import frc.robot.commands.drivetrain.CurvatureDrive;

/**
 * Subsystem that controls the robot drive base
 */
public class Drivetrain extends Subsystem {
    
    private SpeedControllerGroup
        leftMotors = new SpeedControllerGroup(RobotMap.frontLeftDrive, RobotMap.backleftDrive),
        rightMotors = new SpeedControllerGroup(RobotMap.frontRightDrive, RobotMap.backRightDrive);
    
    private AHRS
        gyro = RobotMap.gyro;
    
    // private Encoder
    //     leftDriveEncoder = RobotMap.leftDriveEncoder,
    //     rightDriveEncoder = RobotMap.rightDriveEncoder;
        
    // public DifferentialDrive drivebase;

    public Drivetrain() {
       rightMotors.setInverted(true);
        // drivebase = new DifferentialDrive(leftMotors, rightMotors);
        //SmartDashboard.putData(drivebase);
    }
    
    public void infuzedDrive(double leftSpeed, double rightSpeed) {
        leftMotors.set(leftSpeed);
        rightMotors.set(rightSpeed);
    }

    public void drive(double leftSpeed, double rightSpeed) {
        // drivebase.tankDrive(leftSpeed, rightSpeed);
    }

    public void curve(double speed, double rotation, boolean isQuickTurn){
        // drivebase.curvatureDrive(speed, rotation, isQuickTurn);
    }

    public void stop() {
        leftMotors.stopMotor();
        rightMotors.stopMotor();
    }

    // public Encoder getLeftEncoder() {
    //     return leftDriveEncoder;
    // }

    // public Encoder getRightEncoder() {
    //     return rightDriveEncoder;
    // }

    // public int getLeftEncoderTicks() {
    //     return leftDriveEncoder.get();
    // }

    // public int getRightEncoderTicks() {
    //     return rightDriveEncoder.get();
    // }

    public double getGyroAngle() {
        return gyro.getAngle();
    }

    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new ArcadeDrive());
    }
}
