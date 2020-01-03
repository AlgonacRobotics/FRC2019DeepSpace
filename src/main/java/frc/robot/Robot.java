/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

//import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//import frc.robot.commands.BackLiftDownCommand;
//import frc.robot.commands.BackLiftUpCommand;
import frc.robot.commands.DriveCommand;
import frc.robot.commands.ExampleCommand;
//import frc.robot.commands.FrontLiftDownCommand;
//import frc.robot.commands.FrontLiftUpCommand;
//import frc.robot.commands.IntakeInCommand;
//import frc.robot.commands.IntakeOutCommand;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.LEDSubsystem;
import frc.robot.subsystems.LiftDriveSubsystem;
import frc.robot.subsystems.PneuSubsystem;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.RobotLiftSubsystem;
import frc.robot.subsystems.LimeLightSubsystem;;
//import edu.wpi.cscore.UsbCamera;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  //Instantiation of Subsystems
  public static ExampleSubsystem m_subsystem = new ExampleSubsystem();
  public static OI m_oi;
  //public static UsbCamera camera1;
  public static DriveSubsystem m_driveSubsystem = new DriveSubsystem();
  public static IntakeSubsystem m_intakeSubsystem = new IntakeSubsystem();
  public static LiftDriveSubsystem m_liftDriveSubsystem = new LiftDriveSubsystem();
  public static PneuSubsystem m_pneuSubsystem = new PneuSubsystem();
  public static ElevatorSubsystem m_elevatorSubsystem = new ElevatorSubsystem();
  public static RobotLiftSubsystem m_robotLiftSubsystem = new RobotLiftSubsystem();
  public static LimeLightSubsystem m_limeLightSubsystem = new LimeLightSubsystem();
  public static LEDSubsystem m_ledSubsystem = new LEDSubsystem();

//Instantiation of commands
  Command m_autonomousCommand;
  Command m_driveCommand = new DriveCommand();
  /*Command m_IntakeInCommand = new IntakeInCommand();
  Command m_IntakeOutCommand = new IntakeOutCommand();
  Command m_FrontLiftUpCommand = new FrontLiftUpCommand();
  Command m_FrontLiftDownCommand = new FrontLiftDownCommand();
  Command m_BackLiftUpCommand = new BackLiftUpCommand();
  Command m_BackLiftDownCommand = new BackLiftDownCommand();*/
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    m_oi = new OI();
    m_chooser.setDefaultOption("Default Auto", new ExampleCommand());
    // chooser.addOption("My Auto", new MyAutoCommand());
    SmartDashboard.putData("Auto mode", m_chooser);
    m_pneuSubsystem.ShootDiscRetract();
    m_pneuSubsystem.RaiseIntake();
    m_pneuSubsystem.PanelGrabberClamp();
    m_ledSubsystem.Rainbow();

    //camera1 = CameraServer.getInstance().startAutomaticCapture(0);
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   * You can use it to reset any subsystem information you want to clear when
   * the robot is disabled.
   */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString code to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional commands to the
   * chooser code above (like the commented example) or additional comparisons
   * to the switch structure below with additional strings & commands.
   */
  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_chooser.getSelected();
    m_driveCommand.start();

    /*
     * String autoSelected = SmartDashboard.getString("Auto Selector",
     * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
     * = new MyAutoCommand(); break; case "Default Auto": default:
     * autonomousCommand = new ExampleCommand(); break; }
     */

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.start();
    }
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.

    m_driveCommand.start();

    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
    //m_driveCommand.start();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}