/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.drivetrain.auto.RampDrive;
import frc.robot.commands.drivetrain.auto.RampToLeftCargoShip;
import frc.robot.commands.superstructure.CenterStartToLeftCargoShipHatch;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Pneumatics;
import frc.robot.subsystems.Vision;
import frc.robot.subsystems.Wrist;

public class Robot extends TimedRobot {
    public static OI oi;

    // Initialize Subsystems Here
    public static Drivetrain drivetrain = new Drivetrain();
    public static Vision vision = new Vision();
    public static Arm arm = new Arm();
    public static Wrist wrist = new Wrist();
    public static Intake intake = new Intake();
    public static Pneumatics pneumatics = new Pneumatics();

    Command m_autonomousCommand;
    SendableChooser<Command> m_chooser = new SendableChooser<>();

    @Override
    public void robotInit() {
        oi = new OI();
        // m_chooser.setDefaultOption("Default Auto", new SimpleFourFoot());
        // chooser.addOption("My Auto", new MyAutoCommand());
        SmartDashboard.putData("Auto mode", m_chooser);
        pneumatics.turnOn();
        // pneumatics.turnOff();
    }

    @Override
    public void robotPeriodic() {
    }

    @Override
    public void disabledInit() {
    }

    @Override
    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void autonomousInit() {
        // m_autonomousCommand = m_chooser.getSelected();
        
        // if (m_autonomousCommand != null) {
        //     m_autonomousCommand.start();
        // }
        m_autonomousCommand = new RampToLeftCargoShip(); // Change to any command group in commands.drivetrain.auto
        m_autonomousCommand.start(); // This will automatically run when Autonomous is Enabled in the driverstation (BE CAREFUL!)
    }

    @Override
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void teleopInit() {
        if (m_autonomousCommand != null) {
            m_autonomousCommand.cancel();
        }
    }

    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        // System.out.println("Gyro: " + RobotMap.gyro.getAngle());
        // System.out.println("Right Encoder: " + RobotMap.rightDriveEncoder.get());
        // System.out.println("Left Encoder: " + RobotMap.leftDriveEncoder.get());
        System.out.println("Left drive encoder: " + RobotMap.leftDriveEncoder.get());
        System.out.println("Right drive encoder: " + RobotMap.rightDriveEncoder.get());
        System.out.println("Wrist Motor Velocity: " + RobotMap.wristMotor.getSelectedSensorVelocity());
        System.out.println("Arm Motor Velocity: " + RobotMap.armMasterMotor.getSelectedSensorVelocity());
        System.out.println("Wrist angle: " + wrist.getAngle());
        System.out.println("Arm Motor Angle: " + (90 - arm.getAngle()));
    }

    @Override
    public void testPeriodic() {
    }
}
