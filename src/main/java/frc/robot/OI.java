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
import frc.robot.commands.BallFollowing;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    public Joystick
        leftStick = new Joystick(RobotConstants.kLeftStickPort),
        rightStick = new Joystick(RobotConstants.kRightStickPort);
    public XboxController controller = new XboxController(3);

    // public Button ballFollow;

    public OI() {
        //ballFollow = new JoystickButton(leftStick, 1); //thumb button on joystick
        //ballFollow.whenPressed(new BallFollowing());
    }
}
