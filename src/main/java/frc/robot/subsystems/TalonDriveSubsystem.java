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

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.Faults;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.ControlMode;
import oi.limelightvision.limelight.frc.LimeLight;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANSparkMax;

/*This subsystem defines the talons used fir the driev train, sets up the encoders, followers,
and inversions, as well as assigning the encoders to talons, sets the motors to break mode,
tell what the joystick has to do to get the motors to move*/

/**
 * Add your docs here.
 */
public class TalonDriveSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  //CTR Talon Speed Controller Instantiations
  WPI_TalonSRX frontRight = new WPI_TalonSRX(RobotMap.frontRight);
  WPI_TalonSRX centerRight = new WPI_TalonSRX(RobotMap.centerRight);
  WPI_TalonSRX backRight = new WPI_TalonSRX(RobotMap.backRight);
  WPI_TalonSRX frontLeft = new WPI_TalonSRX(RobotMap.frontLeft);
  WPI_TalonSRX centerLeft = new WPI_TalonSRX(RobotMap.centerLeft);
  WPI_TalonSRX backLeft = new WPI_TalonSRX(RobotMap.backLeft);

  //Define limelight
  private LimeLight _limelight;

  Faults faults_L = new Faults();
  Faults faults_R = new Faults(); 

  //Establish variables needed for error checking
  public int maxLoopNumber = 0;
  public int onTargetCounter = 0;
  public int allowedErrorRange = 0;

  public DifferentialDrive drive;

  public TalonDriveSubsystem() {

    //Set Factory Default Values
    frontRight.configFactoryDefault();
    centerRight.configFactoryDefault();
    backRight.configFactoryDefault();
    frontLeft.configFactoryDefault();
    centerLeft.configFactoryDefault();
    backLeft.configFactoryDefault();

    //Set Up Followers
    centerRight.follow(frontRight);
    backRight.follow(frontRight);
    centerLeft.follow(frontLeft);
    backLeft.follow(frontLeft);

    //set inversions
    frontRight.setInverted(false);
    centerRight.setInverted(InvertType.FollowMaster);
    backRight.setInverted(InvertType.FollowMaster);
    frontLeft.setInverted(true);
    centerLeft.setInverted(InvertType.FollowMaster);
    backLeft.setInverted(InvertType.FollowMaster);

    //Set front left and right talons to use Grayhill encoders
    frontRight.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder,0,0);
    frontLeft.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder,0,0);

    //Set drive motors to Break mode
    frontRight.setNeutralMode(NeutralMode.Brake);
    centerRight.setNeutralMode(NeutralMode.Brake);
    backRight.setNeutralMode(NeutralMode.Brake);
    frontLeft.setNeutralMode(NeutralMode.Brake);
    centerLeft.setNeutralMode(NeutralMode.Brake);
    backLeft.setNeutralMode(NeutralMode.Brake);

    //Adjust Sensor Phase
    frontLeft.setSensorPhase(true);
    frontRight.setSensorPhase(true);

    //Establish Differential Drive
    drive = new DifferentialDrive(frontLeft, frontRight);

    //Adjust WPI Drivetrain To Apply + To Both Sides
    drive.setRightSideInverted(false);
  }
  
  //Drives drivetrain based on Joystick and dampening value (speed)
  public void driveJoystick(Joystick joystick, double speed, boolean squareInputs){
    //drive.arcadeDrive(joystick.getY()*speed, joystick.getZ()*speed);
    //drive.arcadeDrive(joystick.getY()*speed, joystick.getZ()/1.25,true);
    drive.arcadeDrive(joystick.getY()*speed, joystick.getZ()*0.7, true);
  }

  //Drives Drivetrain Based On Given Speed and Rotation Values
  public void drive(double speed, double rotationSpeed) {
    drive.arcadeDrive(speed, rotationSpeed);
  }

  //Get Limelight
  public LimeLight gLimeLight(){
    return _limelight;
  }

  //Zero encoder values
  public void zeroEncoders(){
    frontLeft.setSelectedSensorPosition(0, 0, 0);
    frontRight.setSelectedSensorPosition(0, 0, 0);

    frontLeft.getSensorCollection().setQuadraturePosition(0, 0);
    frontRight.getSensorCollection().setQuadraturePosition(0, 0);
  }

  //Converts inches to encoder pulses
  public double inchToEncoder(double inches){
    return (inches / RobotMap.wheelCir) * 2875;
  }

  //Converts degrees to encoder pulses
  public double degreesToEncoder(double degrees){
    return inchToEncoder((RobotMap.robotCir / 360) * degrees);
  }

  //Sets the distance you are trying to reach in inches
  public void setSetPointDrive(double setpointInches){
    frontLeft.set(ControlMode.Position,inchToEncoder(setpointInches));
    frontRight.set(ControlMode.Position,inchToEncoder(setpointInches));

  }

  //Sets the angle that you are trying to reach
  public void setSetPointTurn(double setPointDegrees){

    zeroEncoders();

    frontLeft.set(ControlMode.Position,degreesToEncoder(-setPointDegrees));
    frontRight.set(ControlMode.Position,degreesToEncoder(setPointDegrees));
  }

  //Make sure you are on track to hit your value
  public void setupOnTarget (int ticks,  int maxLoopNumber){

    //Zero the OnTarget counter
    onTargetCounter = 0;

    frontLeft.configAllowableClosedloopError(0, ticks, 10);
    frontRight.configAllowableClosedloopError(0, ticks, 10);

    //Set tolerance in ticks
    allowedErrorRange = ticks;

    this.maxLoopNumber = maxLoopNumber;
  }

  //Make sure encoders are within range of the set values
  public boolean onTarget(){
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
  }

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
