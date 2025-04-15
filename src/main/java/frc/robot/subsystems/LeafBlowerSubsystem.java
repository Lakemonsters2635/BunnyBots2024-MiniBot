// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class LeafBlowerSubsystem extends SubsystemBase {
  /** Creates a new LeafBlowerSubsystem. */

   TalonSRX leafBlowerMotor;
   Spark blinkin;
   
  public LeafBlowerSubsystem() {
    leafBlowerMotor = new TalonSRX(Constants.LEAF_BLOWER_MOTOR_ID);
    blinkin = new Spark(Constants.BLINKIN_PORT);
  }

  public void runLeafBlower(){
    leafBlowerMotor.set(TalonSRXControlMode.PercentOutput, Constants.LEAF_BLOWER_RUN_SPEED);
    blinkin.set(-0.07);
  }

  public void stopLeafBlower(){
    leafBlowerMotor.set(TalonSRXControlMode.PercentOutput, Constants.LEAF_BLOWER_STOP_SPEED);
    blinkin.set(-0.13);
  }



  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
