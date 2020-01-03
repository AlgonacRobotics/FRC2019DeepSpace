/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
//import frc.robot.OI;
//import frc.robot.subsystems.DriveSubsystem;
/*import oi.limelightvision.limelight.frc.ControlMode.CamMode;
import oi.limelightvision.limelight.frc.LimeLight;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;*/
import edu.wpi.first.networktables.NetworkTableInstance;

public class DriveCommand extends Command {
  public DriveCommand() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    //Ensure Motors are stopped
    Robot.m_driveSubsystem.stop();
    NetworkTableInstance.getDefault().getTable("limelight").getEntry("camMode").setNumber(1);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    //Use Driver Joystick to Control the Drivetrain With no Damper on Speed
    //In testing If Else statement wan't working properly
    //if (Robot.m_oi.getDriverStick().getRawButtonPressed(5)){
    // Robot.m_driveSubsystem.driveJoystick(Robot.m_oi.getDriverStick(), .5, true);
    //} else {
      //if (Robot.m_oi.getDriverStick().getThrottle() > 0.0){
      Robot.m_driveSubsystem.driveJoystick(Robot.m_oi.getDriverStick(), Robot.m_oi.getDriverStick().getThrottle(), true);
     // }
      //else {
      //  Robot.m_driveSubsystem.driveJoystick(Robot.m_oi.getDriverStick(), 0, true);
      //}
      //SmartDashboard.putNumber(Robot.m_oi.getDriverStick().getThrottle());
    //}
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    //Stop all Motors
    Robot.m_driveSubsystem.stop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
