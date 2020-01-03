/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.Faults;

/*This subsystem defines the talons that are used with the intake and
sets the speeds we want the motor to go when the intake is going in, out, or stopped*/

/**
 * Add your docs here.
 */
public class IntakeSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  //CTR Talon Speed Controller Instantiations
  WPI_TalonSRX intakeMotor = new WPI_TalonSRX(RobotMap.intakeMotor);

  Faults faults_L = new Faults();
  Faults faults_R = new Faults(); 

  public IntakeSubsystem() {

    //Set Factory Default Values
    intakeMotor.configFactoryDefault();
  }
 

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

public void IntakeIn(){
  intakeMotor.set(RobotMap.fullSpeed);
}

public void IntakeOut(){
  intakeMotor.set(-RobotMap.fullSpeed);
}

public void IntakeStop(){
  intakeMotor.set(0);
}


}
