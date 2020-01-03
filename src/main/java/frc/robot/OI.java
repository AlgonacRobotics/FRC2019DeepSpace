/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
//import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.IntakeInCommand;
import frc.robot.commands.IntakeOutCommand;
//import frc.robot.commands.FrontLiftUpCommand;
//import frc.robot.commands.FrontLiftDownCommand;
//import frc.robot.commands.BackLiftUpCommand;
//import frc.robot.commands.BackLiftDownCommand;
import frc.robot.commands.LiftDriveForwardCommand;
import frc.robot.commands.LimelightAimCommand;
import frc.robot.commands.LiftDriveBackwardCommand;
import frc.robot.commands.ShifterHighGearCommand;
import frc.robot.commands.ShifterLowGearCommand;
import frc.robot.commands.IntakeRaiseCommand;
import frc.robot.commands.IntakeLowerCommand;
import frc.robot.commands.ShootDiscCommandGroup;
//import frc.robot.commands.ElevatorShootDiscCommandGroup;
//import frc.robot.commands.ElevatorShootDiscExtendCommand;
//import frc.robot.commands.ElevatorShootDiscRetractCommand;
//import frc.robot.commands.ElevatorUpCommand;
//import frc.robot.commands.ElevatorDownCommand;
//import frc.robot.commands.ElevatorIntakeInCommand;
//import frc.robot.commands.ElevatorIntakeOutCommand;
//import frc.robot.commands.LimelightAimCommand;
import frc.robot.commands.LimelightAimRangeCommand;
//import frc.robot.commands.LimelightRangeCommand;
import frc.robot.commands.RobotLiftDownCommand;
import frc.robot.commands.RobotLiftUpCommand;
//import frc.robot.commands.ShootDiscExtendCommand;
//import frc.robot.commands.ShootDiscRetractCommand;
//import frc.robot.commands.REMShootDiscCommand;
import frc.robot.commands.PanelGrabberClampCommand;
import frc.robot.commands.PanelGrabberReleaseCommand;
import frc.robot.commands.LEDCommand1;
import frc.robot.commands.LEDRedCommand;
import frc.robot.commands.LEDGreenCommand;
import frc.robot.commands.ShootDiscRetractCommand;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);

  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());

  //Instantiation of Joysticks
  Joystick driverStick = new Joystick(RobotMap.driverStick);
  Joystick operatorStick = new Joystick(RobotMap.operatorStick);
  Joystick operatorPanel = new Joystick(RobotMap.operatorPanel);

  //Define Operator Stick Buttons
  JoystickButton IntakeIn = new JoystickButton(operatorStick, 1);
  JoystickButton IntakeOut = new JoystickButton(operatorStick, 2);
  JoystickButton ShootDisc = new JoystickButton(operatorStick, 3);
  JoystickButton LEDNormal = new JoystickButton(operatorStick, 4);  
  JoystickButton LEDGreen = new JoystickButton(driverStick, 9);
  JoystickButton LEDRed = new JoystickButton(driverStick, 10);
  JoystickButton IntakeLower = new JoystickButton(operatorStick, 5);
  JoystickButton IntakeRaise = new JoystickButton(operatorStick, 6);
  JoystickButton PanelGrabberClamp = new JoystickButton(operatorStick, 7);
  JoystickButton PanelGrabberRelease = new JoystickButton(operatorStick, 8);
  //JoystickButton FrontLiftUp = new JoystickButton(operatorStick, 3);
  //JoystickButton FrontLiftDown = new JoystickButton(operatorStick, 4);
  //JoystickButton BackLiftUp = new JoystickButton(operatorStick, 5);
  //JoystickButton BackLiftDown = new JoystickButton(operatorStick, 6);
  //*JoystickButton ElevatorShootDisc = new JoystickButton(operatorStick, 4);
  //JoystickButton ShootDiscExtend = new JoystickButton(operatorStick, 7);
  //JoystickButton ShootDiscRetract = new JoystickButton(operatorStick, 8);
 // JoystickButton ShootDiscNew = new JoystickButton(driverStick, 4);



  //Define Driver stick Buttons
  JoystickButton LiftDriveForward = new JoystickButton(driverStick, 9);
  JoystickButton LiftDriveBackward = new JoystickButton(driverStick, 10);
  JoystickButton RobotLiftDown = new JoystickButton(driverStick, 11);
  JoystickButton RobotLiftUp = new JoystickButton(driverStick, 12);
  JoystickButton ShootDiscRetract = new JoystickButton(driverStick, 2);
  //*JoystickButton ElevatorDown = new JoystickButton(driverStick, 8);
  JoystickButton ShifterHighGear = new JoystickButton(driverStick, 3);
  JoystickButton ShifterLowGear = new JoystickButton(driverStick, 4);
  JoystickButton LimelightAimRange = new JoystickButton(driverStick, 7);
  JoystickButton LimelightAim = new JoystickButton(driverStick, 8);
  
 
  //Define Operator Panel Buttons
 // JoystickButton LimelightAim = new JoystickButton(operatorPanel, 1);
 // JoystickButton LimelightRange = new JoystickButton(operatorPanel, 2);
 
  //JoystickButton ElevatorIntakeIn = new JoystickButton(operatorPanel, 3);
  //JoystickButton ElevatorIntakeOut = new JoystickButton(operatorPanel, 4);

  //Joystick accessors
  public Joystick getDriverStick(){
    return driverStick;
  }

  public Joystick getOperatorStick(){
    return operatorStick;
  }

 public OI(){
   //Programming buttons for commands
  IntakeIn.whileHeld(new IntakeInCommand());
  IntakeOut.whileHeld(new IntakeOutCommand());
  RobotLiftUp.whileHeld(new RobotLiftUpCommand());
  RobotLiftDown.whileHeld(new RobotLiftDownCommand());
  //BackLiftUp.whileHeld(new BackLiftUpCommand());
  //BackLiftDown.whileHeld(new BackLiftDownCommand());
  LiftDriveForward.whileHeld(new LiftDriveForwardCommand());
  LiftDriveBackward.whileHeld(new LiftDriveBackwardCommand());
  IntakeRaise.whenPressed(new IntakeRaiseCommand());
  IntakeLower.whenPressed(new IntakeLowerCommand());
  ShootDisc.whenPressed(new ShootDiscCommandGroup());
  ShootDiscRetract.whenPressed(new ShootDiscRetractCommand(1.5));
  //ElevatorShootDisc.whenPressed(new ElevatorShootDiscCommandGroup());
  //ShootDiscExtend.whenPressed(new ShootDiscExtendCommand(2.0));
  //ShootDiscRetract.whenPressed(new ShootDiscRetractCommand(2.0));
  PanelGrabberClamp.whenPressed(new PanelGrabberClampCommand());
  PanelGrabberRelease.whenPressed(new PanelGrabberReleaseCommand());
  ShifterHighGear.whenPressed(new ShifterHighGearCommand());
  ShifterLowGear.whenPressed(new ShifterLowGearCommand());
  //ElevatorUp.whileHeld(new ElevatorUpCommand());
  //ElevatorDown.whileHeld(new ElevatorDownCommand());
  //ElevatorIntakeIn.whileHeld(new ElevatorIntakeInCommand());
  //ElevatorIntakeOut.whileHeld(new ElevatorIntakeOutCommand());
  LimelightAim.whileHeld(new LimelightAimCommand());
  LimelightAimRange.whileHeld(new LimelightAimRangeCommand());
 // LimelightRange.whileHeld(new LimelightRangeCommand());
 // RobotLiftUp.whileHeld(new RobotLiftUpCommand());
 // RobotLiftDown.whileHeld(new RobotLiftDownCommand());
  //ShootDiscNew.whenPressed(new REMShootDiscCommand(true));
  //ShootDiscNew.whenPressed(new REMShootDiscCommand(false));
  LEDNormal.whenPressed(new LEDCommand1());
  LEDRed.whenPressed(new LEDRedCommand());
  LEDGreen.whenPressed(new LEDGreenCommand());
 }

}
