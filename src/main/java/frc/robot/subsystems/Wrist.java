/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;
import frc.robot.RobotMap;
import frc.robot.commands.wrist.ManualWristControl;

/**
 * Subsystem that controls the wrist mechanism to angle the intake
 */
public class Wrist extends Subsystem {

  private WPI_TalonSRX
    wristMotor = RobotMap.wristMotor;

  public Wrist() {
    wristMotor.setNeutralMode(NeutralMode.Brake);
    wristMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute);

    wristMotor.setSensorPhase(false);
    wristMotor.setInverted(true);

    wristMotor.configNominalOutputForward(0, 0);
    wristMotor.configNominalOutputReverse(0, 0);
    wristMotor.configPeakOutputForward(1, 0);
    wristMotor.configPeakOutputReverse(-1, 0);

    wristMotor.selectProfileSlot(0, 0);
    wristMotor.config_kF(0, Constants.kWristF,0);
    wristMotor.config_kP(0, Constants.kWristP, 0);
    wristMotor.config_kI(0, Constants.kWristI, 0);
    wristMotor.config_kD(0, Constants.kWristD, 0);
    
    wristMotor.configMotionCruiseVelocity(Constants.kWristCruiseVelocity, 0);
    wristMotor.configMotionAcceleration(Constants.kWristAcceleration, 0);

    wristMotor.setSelectedSensorPosition(0, 0, 0);
  }

  public void setPosition(double position) {
    wristMotor.set(ControlMode.MotionMagic, position);    
  }
  
  public void setSpeed(double speed) {
    wristMotor.set(speed);
  }
  
  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new ManualWristControl());
  }
}
