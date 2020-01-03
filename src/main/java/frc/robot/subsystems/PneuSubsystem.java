/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import frc.robot.RobotMap;

//This subsystem defines the solenoids and what they are used for along
//with the things the solenoids need to do and wether they go forward or in reverse 

/**
 * Add your docs here.
 */
public class PneuSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  //Defining pneumatics solenoids
  public DoubleSolenoid shifters_HighLow = new DoubleSolenoid(RobotMap.pneuShiftA, RobotMap.pneuShiftB);
  public DoubleSolenoid panel_Shooter = new DoubleSolenoid(RobotMap.pneuPanelShooterA, RobotMap.pneuPanelShooterB);
  public DoubleSolenoid intake_Lift = new DoubleSolenoid(RobotMap.pneuIntakeA, RobotMap.pneuIntakeB);
  //public DoubleSolenoid elevator_shooter = new DoubleSolenoid(RobotMap.pneuElevatorShooterA, RobotMap.pneuElevatorShooterB);
  public DoubleSolenoid panel_Grabber = new DoubleSolenoid(RobotMap.pneuPanelGrabberA, RobotMap.pneuPanelGrabberB);

public PneuSubsystem() {

  //Set Factory Default Values

}

public void LowGear(){
  shifters_HighLow.set(Value.kReverse);
  SmartDashboard.putString("Drive Gear", "Low");

}

public void HighGear(){
  shifters_HighLow.set(Value.kForward);
  SmartDashboard.putString("Drive Gear", "High");
}

public void ShifterOff(){
  shifters_HighLow.set(Value.kOff);
}

public void ShootDiscExtend(){
 panel_Shooter.set(DoubleSolenoid.Value.kReverse); 
 SmartDashboard.putString("Panel", "Extend");
}

public void ShootDiscRetract(){
  panel_Shooter.set(DoubleSolenoid.Value.kForward);
  SmartDashboard.putString("Panel", "Retract");
}

public void ShootDiscOff(){
  panel_Shooter.set(DoubleSolenoid.Value.kOff);
}


public void LowerIntake(){
  intake_Lift.set(Value.kForward);
}

public void RaiseIntake(){
  intake_Lift.set(Value.kReverse);
}

public void IntakeLiftOff(){
  intake_Lift.set(Value.kOff);
}

//public void ElevatorShootDiscExtend(){
  //elevator_shooter.set(Value.kForward);
//}

//public void ElevatorShootDiscRetract(){
  //elevator_shooter.set(Value.kReverse);
//}

//public void ElevatorClawOff(){
  //elevator_shooter.set(Value.kOff);
//}

public void PanelGrabberClamp(){
  panel_Grabber.set(Value.kForward);
}

public void PanelGrabberRelease(){
  panel_Grabber.set(Value.kReverse);
}

public void PanelGrabeerOff(){
  panel_Grabber.set(Value.kOff);
}

@Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
