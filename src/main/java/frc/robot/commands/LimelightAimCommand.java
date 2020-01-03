/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
//import oi.limelightvision.limelight.frc.ControlMode.CamMode;


public class LimelightAimCommand extends Command {
   private float kpDistance = -0.1f;
   private float kpAim = -0.02f;
   private double m_moveValue;
   private double m_rotateValue;
   private float min_command = 0.05f;

  public LimelightAimCommand() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.m_limeLightSubsystem);
    requires(Robot.m_driveSubsystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    //Robot.m_driveSubsystem.gLimeLight().setCamMode(CamMode.kvision);
    NetworkTableInstance.getDefault().getTable("limelight").getEntry("camMode").setNumber(0);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double ty = -Robot.m_limeLightSubsystem.getTY();
    double tx = -Robot.m_limeLightSubsystem.getTX();
    //boolean targetFound = Robot.m_limeLightSubsystem.getIsTargetFound();

    /*if(targetFound){
      //m_moveValue = ty * kpDistance;
     //m_rotateValue = tx * kpAim;
    }else{
      m_moveValue = 0;
      m_rotateValue = 0;
    }*/

    if (tx > 1.0){
      m_rotateValue = tx*kpAim - min_command;
    }
    else if (tx < 1.0){
      m_rotateValue = tx*kpAim + min_command;
    }
    m_moveValue = ty * kpDistance;
    Robot.m_driveSubsystem.drive(0, m_rotateValue);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.m_driveSubsystem.drive(0,0);
    //NetworkTableInstance.getDefault().getTable("limelight").getEntry("camMode").setNumber(1);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }

  //estimate distance
  /*private double Estimated_Distance(double a2){
    double h1 = 6.0;
    double h2 = 36.0;
    double a1 = 0.0;
    return(h2-h1)/Math.tan(a1+a2);
  }*/
}
