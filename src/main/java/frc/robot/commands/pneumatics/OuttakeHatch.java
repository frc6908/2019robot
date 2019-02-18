/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.pneumatics;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.TimedCommand;
import frc.robot.Robot;

/**
 * Add your docs here.
 */
public class OuttakeHatch extends TimedCommand {
  /**
   * Add your docs here.
   */
  private boolean
    in = false,
    out = true;

  public OuttakeHatch(double timeout) {
    super(timeout);
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.pneumatics);
  }

  // Called just before this Command runs the first time
  @Override 
  protected void initialize() {
    Robot.pneumatics.setSolenoidPosition(in); // Initialize to in
    long storeTime = System.currentTimeMillis();
    while(System.currentTimeMillis() - storeTime <= 0.3) {
      // Wait for some time
    }
    Robot.pneumatics.setSolenoidPosition(out); // Push hatch out
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
  }

  // Called once after timeout
  @Override
  protected void end() {
    Robot.pneumatics.setSolenoidPosition(in);
    long storeTime = System.currentTimeMillis();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
