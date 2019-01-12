/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.TankDrive;

/**
 * 2019 robot drivetrain subsystem
 */
public class Drivetrain extends Subsystem {
    public SpeedControllerGroup
        leftMotors = new SpeedControllerGroup(RobotMap.frontLeftDrive, RobotMap.backleftDrive),
        rightMotors = new SpeedControllerGroup(RobotMap.frontRightDrive, RobotMap.backRightDrive);

    public void drive(double leftSpeed, double rightSpeed) {
        System.out.println(leftSpeed);
        System.out.println(rightSpeed);
        leftMotors.set(-leftSpeed);
        rightMotors.set(-rightSpeed);
    }

    public void stop() {
        leftMotors.stopMotor();
        rightMotors.stopMotor();
    }

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new TankDrive());
    }
}
