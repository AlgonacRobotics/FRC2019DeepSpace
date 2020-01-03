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

/*This subsystem defines the talon used when the elevator goes
up and down, and sets the speed of the motors when the elevator goes up, down, or is stopped*/

/**
 * Add your docs here.
 */
public class ElevatorSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  //CTR Talon Speed Controller Instantiations
  WPI_TalonSRX elevatorMotor = new WPI_TalonSRX(RobotMap.elevator);

  public ElevatorSubsystem() {

    //Set Factory Default Values
    elevatorMotor.configFactoryDefault();
  }
 

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

public void ElevatorUp(){
  elevatorMotor.set(RobotMap.muskratSpeed);
}

public void ElevatorDown(){
  elevatorMotor.set(-RobotMap.muskratSpeed);
}

public void ElevatorStop(){
  elevatorMotor.set(0);
}

}
