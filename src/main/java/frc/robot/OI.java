/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.groundIntake.IntakeHatch;
import frc.robot.commands.groundIntake.OuttakeGroundHatch;
import frc.robot.commands.intake.IntakeBall;
import frc.robot.commands.pneumatics.OuttakeHatch;
import frc.robot.commands.vision.DoubleRRTFollowing;
import frc.robot.commands.wrist.auto.SetWristPosition;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    public Joystick
        driveStick = new Joystick(Constants.kDriveStickPort);

    public XboxController
        operatorController = new XboxController(Constants.kOperatorController);
    
    public Button 
        alignWithTarget = new JoystickButton(driveStick, Constants.kAlignWithTargetButton),
        intakeBall = new JoystickButton(driveStick, 1),
        outtakeHatch = new JoystickButton(operatorController, Constants.kHatchButton),
        groundIntakeWheelOuttake = new JoystickButton(operatorController, Constants.kGroundWheelButton),
        groundIntakeWheelIntake = new JoystickButton(driveStick, Constants.kGroundWheelIntake);

    public OI() {
        alignWithTarget.whileHeld(new DoubleRRTFollowing());
        intakeBall.whileHeld(new IntakeBall());
        outtakeHatch.whenPressed(new OuttakeHatch(0.3));
        groundIntakeWheelIntake.whileHeld(new IntakeHatch());
        groundIntakeWheelOuttake.whileHeld(new OuttakeGroundHatch());
    }
}
