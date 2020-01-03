/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;

  //Define robot motors
  public static final int frontRight = 1;
  public static final int centerRight = 2;
  public static final int backRight = 3;
  public static final int frontLeft = 4;
  public static final int centerLeft = 5;
  public static final int backLeft = 6;

  public static final int intakeMotor = 7;

  //Define lift motors rl = robotlift
  public static final int rlFrontLeft = 20;
  public static final int rlBackLeft = 21;
  public static final int rlFrontRight = 22;
  public static final int rlBackRight = 23;
  public static final int robotLiftDrive = 8;
  public static final int robotLift = 9;
  public static final int robotLift2 = 12;

  //Elevator motors
  public static final int elevator = 13;
  public static final int elevatorIntake = 14;

  //Define LED controller
  public static final int LEDPWMPort = 1;

  //Pneumatics Control Module and compressor
  public static final int pcmA = 0;
  public static int pneumaticsCompressor = 1;
  public static final int pneuPanelGrabberA = 0;
  public static final int pneuPanelGrabberB = 1;
  public static final int pneuShiftA = 2;
  public static final int pneuShiftB = 3;
  public static final int pneuIntakeA = 4;
  public static final int pneuIntakeB = 5;
  public static final int pneuPanelShooterA = 6;
  public static final int pneuPanelShooterB = 7;

  //Define Joysticks
  public static final int driverStick = 0;
  public static final int operatorStick = 1;
  public static final int operatorPanel = 2;

  //Define Wheel Circumference for 6 inch wheels
  public static final double wheelCir = 18.84;

  //Set Circumference of the Robot
  public static final double robotCir = 180;

  //Set speeds
  public static double fullSpeed = 1;
  public static double muskratSpeed = .75;
  public static double halfSpeed = .5;
  public static double slowSpeed = .25;
}
