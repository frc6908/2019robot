/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import frc.robot.commands.TankDrive;
import frc.robot.commands.ArcadeDrive;

/**
 * 2019 robot drivetrain subsystem
 */
public class Drivetrain extends Subsystem {
    public SpeedControllerGroup
        leftMotors = new SpeedControllerGroup(RobotMap.frontLeftDrive, RobotMap.backleftDrive),
        rightMotors = new SpeedControllerGroup(RobotMap.frontRightDrive, RobotMap.backRightDrive);
        
    public DifferentialDrive drivebase;

    public Drivetrain() {
        rightMotors.setInverted(true);
        drivebase = new DifferentialDrive(leftMotors, rightMotors);
        SmartDashboard.putData(drivebase);
    }
    
    public void infuzedDrive(double leftSpeed, double rightSpeed) {
        leftMotors.set(leftSpeed);
        rightMotors.set(rightSpeed);
    }

    public void drive(double leftSpeed, double rightSpeed) {
        drivebase.tankDrive(leftSpeed, rightSpeed);
    }

    public void curve(double speed, double rotation, boolean isQuickTurn){
        drivebase.curvatureDrive(speed, rotation, isQuickTurn);
    }

    public void stop() {
        leftMotors.stopMotor();
        rightMotors.stopMotor();
    }

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new ArcadeDrive());
    }
}
