/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class LEDSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  Spark ledController = new Spark(RobotMap.LEDPWMPort);
  
  public LEDSubsystem(){

    ledController.enableDeadbandElimination(true);
  }

  

  public void PartyPalette(){
    ledController.set(-0.43);
  }

  public void GlitterRainbow(){
    ledController.set(-0.89);
  }

  public void Confetti(){
    ledController.set(-0.87);
  }
  
  public void LEDOff(){
    ledController.set(0);
  }

  public void RefConfusion(){
    ledController.set(-0.11);
  }

  public void Green(){
    ledController.set(0.73);
  }

  //public void Red(){
  //  ledController.set(0.59);
  //}

  public void LavaPalette(){
    ledController.set(-0.25);
    SmartDashboard.putString("LED", "Heartbeat Red");
  }

  public void Rainbow(){
    ledController.set(0.79);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
