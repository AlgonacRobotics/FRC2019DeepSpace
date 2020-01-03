/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
//package oi.limelightvision.limelight.frc.limelight;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;

//import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
//import com.ctre.phoenix.motorcontrol.InvertType;
//import com.ctre.phoenix.motorcontrol.Faults;
//import com.ctre.phoenix.motorcontrol.NeutralMode;
//import com.ctre.phoenix.motorcontrol.FeedbackDevice;
//import com.ctre.phoenix.motorcontrol.ControlMode;
import oi.limelightvision.limelight.frc.LimeLight;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;

/*This subsystem defines the talons used fir the driev train, sets up the encoders, followers,
and inversions, as well as assigning the encoders to talons, sets the motors to break mode,
tell what the joystick has to do to get the motors to move*/

/**
 * Add your docs here.
 */
public class DriveSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  //CTR Talon Speed Controller Instantiations
/*  WPI_TalonSRX frontRight = new WPI_TalonSRX(RobotMap.frontRight);
  WPI_TalonSRX centerRight = new WPI_TalonSRX(RobotMap.centerRight);
  WPI_TalonSRX backRight = new WPI_TalonSRX(RobotMap.backRight);
  WPI_TalonSRX frontLeft = new WPI_TalonSRX(RobotMap.frontLeft);
  WPI_TalonSRX centerLeft = new WPI_TalonSRX(RobotMap.centerLeft);
  WPI_TalonSRX backLeft = new WPI_TalonSRX(RobotMap.backLeft);*/
  private CANSparkMax frontRight;
  private CANSparkMax centerRight;
  private CANSparkMax backRight;
  private CANSparkMax frontLeft;
  private CANSparkMax centerLeft;
  private CANSparkMax backLeft;

  

  //Define limelight
  private LimeLight _limelight;

  //Faults faults_L = new Faults();
  //Faults faults_R = new Faults(); 

  //Establish variables needed for error checking
  public int maxLoopNumber = 0;
  public int onTargetCounter = 0;
  public int allowedErrorRange = 0;

  public DifferentialDrive drive;

  public DriveSubsystem() {

    frontRight = new CANSparkMax(RobotMap.frontRight, MotorType.kBrushless);
    centerRight = new CANSparkMax(RobotMap.centerRight, MotorType.kBrushless);
    backRight = new CANSparkMax(RobotMap.backRight, MotorType.kBrushless);
    frontLeft = new CANSparkMax(RobotMap.frontLeft, MotorType.kBrushless);
    centerLeft = new CANSparkMax(RobotMap.centerLeft, MotorType.kBrushless);
    backLeft = new CANSparkMax(RobotMap.backLeft, MotorType.kBrushless);

    //Set Factory Default Value
    frontRight.restoreFactoryDefaults();
    centerRight.restoreFactoryDefaults();
    backRight.restoreFactoryDefaults();
    frontLeft.restoreFactoryDefaults();
    centerLeft.restoreFactoryDefaults();
    backLeft.restoreFactoryDefaults();

    //set current limits
    frontRight.setSmartCurrentLimit(40);
    centerRight.setSmartCurrentLimit(40);
    backRight.setSmartCurrentLimit(40);
    frontLeft.setSmartCurrentLimit(40);
    centerLeft.setSmartCurrentLimit(40);
    backLeft.setSmartCurrentLimit(40);

    //set ramp rate
    frontRight.setOpenLoopRampRate(.4);
    centerRight.setOpenLoopRampRate(.4);
    backRight.setOpenLoopRampRate(.4);
    frontLeft.setOpenLoopRampRate(.4);               
    centerLeft.setOpenLoopRampRate(.4);
    backLeft.setOpenLoopRampRate(.4);

    //Set Up Followers
    centerRight.follow(frontRight);
    backRight.follow(frontRight);
    centerLeft.follow(frontLeft);
    backLeft.follow(frontLeft);

    //set inversions
    frontRight.setInverted(false);
    centerRight.setInverted(false);
    backRight.setInverted(false);
    frontLeft.setInverted(true);
    centerRight.setInverted(true);
    backLeft.setInverted(true);

    //Set front left and right talons to use Grayhill encoders
    //frontRight.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder,0,0);
    //frontLeft.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder,0,0);

    //Set drive motors to Break mode
    frontRight.setIdleMode(IdleMode.kBrake);
    centerRight.setIdleMode(IdleMode.kBrake);
    backRight.setIdleMode(IdleMode.kBrake);
    frontLeft.setIdleMode(IdleMode.kBrake);
    centerLeft.setIdleMode(IdleMode.kBrake);
    backLeft.setIdleMode(IdleMode.kBrake);

    //Adjust Sensor Phase
    //frontLeft.setSensorPhase(true);
    //frontRight.setSensorPhase(true);

    //Establish Differential Drive
    drive = new DifferentialDrive(frontLeft, frontRight);

    //Adjust WPI Drivetrain To Apply + To Both Sides
    drive.setRightSideInverted(false);
  }
  
  //Drives drivetrain based on Joystick and dampening value (speed)
  public void driveJoystick(Joystick joystick, double speed, boolean squareInputs){
    //drive.arcadeDrive(joystick.getY()*speed, joystick.getZ()*speed);
    //drive.arcadeDrive(joystick.getY()*speed, joystick.getZ()/1.25,true);
    drive.arcadeDrive(joystick.getY()*speed, joystick.getZ()*0.6, true);
  }

  //Drives Drivetrain Based On Given Speed and Rotation Values
  public void drive(double speed, double rotationSpeed) {
    drive.arcadeDrive(speed/2, rotationSpeed/2);
  }

  //Get Limelight
  public LimeLight gLimeLight(){
    return _limelight;
  }

  //Zero encoder values
  //public void zeroEncoders(){
  //  frontLeft.setSelectedSensorPosition(0, 0, 0);
  //  frontRight.setSelectedSensorPosition(0, 0, 0);
//
  //  frontLeft.getSensorCollection().setQuadraturePosition(0, 0);
  //  frontRight.getSensorCollection().setQuadraturePosition(0, 0);
  //}

  //Converts inches to encoder pulses
  public double inchToEncoder(double inches){
    return (inches / RobotMap.wheelCir) * 2875;
  }

  //Converts degrees to encoder pulses
  public double degreesToEncoder(double degrees){
    return inchToEncoder((RobotMap.robotCir / 360) * degrees);
  }

  //Sets the distance you are trying to reach in inches
  /*public void setSetPointDrive(double setpointInches){
    frontLeft.set(ControlMode.Position,inchToEncoder(setpointInches));
    frontRight.set(ControlMode.Position,inchToEncoder(setpointInches));

  }*/

  //Sets the angle that you are trying to reach
  /*public void setSetPointTurn(double setPointDegrees){

    zeroEncoders();

    frontLeft.set(ControlMode.Position,degreesToEncoder(-setPointDegrees));
    frontRight.set(ControlMode.Position,degreesToEncoder(setPointDegrees));
  }*/

  //Make sure you are on track to hit your value
  /*public void setupOnTarget (int ticks,  int maxLoopNumber){

    //Zero the OnTarget counter
    onTargetCounter = 0;

    frontLeft.configAllowableClosedloopError(0, ticks, 10);
    frontRight.configAllowableClosedloopError(0, ticks, 10);

    //Set tolerance in ticks
    allowedErrorRange = ticks;

    this.maxLoopNumber = maxLoopNumber;
  }*/

  //Make sure encoders are within range of the set values
  /*public boolean onTarget(){
    if (Math.abs(frontLeft.getClosedLoopError(0)) <= allowedErrorRange &&
    Math.abs(frontRight.getClosedLoopError(0)) <= allowedErrorRange){
      onTargetCounter++;
    }
    else{
      onTargetCounter = 0;
    }
    if (maxLoopNumber <= onTargetCounter){
      return true;
    }
    return false;
  }*/

  //Stops the Motors on the Drivetrain
  public void stop() {
      drive.stopMotor();
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
