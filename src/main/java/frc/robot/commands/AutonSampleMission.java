/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
//import frc.robot.commands.EncoderDriveCommand;
//import frc.robot.commands.EncoderTurnCommand;
import frc.robot.commands.AutonIntakeInCommand;
import frc.robot.commands.AutonIntakeOutCommand;
//import frc.robot.commands.AutonFrontLiftUpCommand;
//import frc.robot.commands.AutonBackLiftUpCommand;
//import frc.robot.commands.AutonFrontLiftDownCommand;
//import frc.robot.commands.AutonBackLiftDownCommand;
//import frc.robot.commands.AutonLiftDriveForwardCommand;
//import frc.robot.commands.AutonLiftDriveBackwardCommand;
import frc.robot.commands.ShootDiscCommandGroup;
import frc.robot.commands.AutonElevatorDownCommand;
import frc.robot.commands.AutonElevatorUpCommand;
//import frc.robot.commands.AutonElevatorIntakeInCommand;
//import frc.robot.commands.AutonElevatorIntakeOutCommand;

public class AutonSampleMission extends CommandGroup {
  /**
   * Add your docs here.
   */
  public AutonSampleMission() {
    // Add Commands here:
    // e.g. addSequential(new Command1());
    // addSequential(new Command2());
    // these will run in order.

    // To run multiple commands at the same time,
    // use addParallel()
    // e.g. addParallel(new Command1());
    // addSequential(new Command2());
    // Command1 and Command2 will run in parallel.

    // A command group will require all of the subsystems that each member
    // would require.
    // e.g. if Command1 requires chassis, and Command2 requires arm,
    // a CommandGroup containing them would require both the chassis and the
    // arm.

    //Drive forward 48 inches
    /*addSequential(new EncoderDriveCommand(48,2));

    //Turn right 30 degrees
    addSequential(new EncoderTurnCommand(30,2));

    //Drive backward 24 inches
    addSequential(new EncoderDriveCommand(-24,2));

    //Turn left 90 degrees
    addSequential(new EncoderTurnCommand(-90,2));*/

    //Turn on Intake in for 5 sec
    addSequential(new AutonIntakeInCommand(5.0));

    //Turn on intake out for 10 sec
    addSequential(new AutonIntakeOutCommand(10.0));

    //Lift go down 2 sec
   //addParallel(new AutonFrontLiftDownCommand(2.0));
    //addParallel(new AutonBackLiftDownCommand(2.0));

    //Lift go up 2 sec
    //addSequential(new AutonFrontLiftUpCommand(2.0));
    //addSequential(new AutonBackLiftUpCommand(2.0));

    //Lift Drive Forward 2 sec
    //addSequential(new AutonLiftDriveForwardCommand(2.0));

    //Lift Drive Backward 7 sec
    //addSequential(new AutonLiftDriveBackwardCommand(7.0));

    //Shoot Panel Disc
    addSequential(new ShootDiscCommandGroup());

    //Elevator Up for 2 sec
    addSequential(new AutonElevatorUpCommand(2.0));

    //Elevator Down for 2 sec
    addSequential(new AutonElevatorDownCommand(2.0));

    //Elevator Intake In 4 sec
    //addSequential(new AutonElevatorIntakeInCommand(4.0));

    //Elevator Intake Out 6 sec
    //addSequential(new AutonElevatorIntakeOutCommand(6.0));

    
  }
}
