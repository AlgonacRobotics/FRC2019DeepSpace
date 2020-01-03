/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.RobotMap;

/*This subsystem defines the talon used with the motor and
sets the speed for motors*/

/**
 * Add your docs here.
 */
public class LiftDriveSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  //CTR Talon Speed Controller Instantiations
  WPI_TalonSRX robotLiftDrive = new WPI_TalonSRX(RobotMap.robotLiftDrive);

  public LiftDriveSubsystem(){

    //Set factory default values
    robotLiftDrive.configFactoryDefault();
  }
  

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void LiftDriveForward(){
    robotLiftDrive.set(RobotMap.halfSpeed);
  }

  public void LiftDriveBackward(){
    robotLiftDrive.set(-RobotMap.halfSpeed);
  }

  public void LiftDriveStop(){
    robotLiftDrive.set(0);
  }

}
