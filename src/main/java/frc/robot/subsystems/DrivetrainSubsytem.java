// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.RobotContainer;

public class DrivetrainSubsytem extends SubsystemBase {
  /** Creates a new DrivetrainSubsytem. */
  CANSparkMax frontLeftMotor;
  CANSparkMax frontRightMotor;
  CANSparkMax backLeftMotor;
  CANSparkMax backRightMotor;

  double leftMotorSpeedX = 0;
  double rightMotorSpeedX = 0;
  double leftMotorSpeedY = 0;
  double rightMotorSpeedY = 0;

  public DrivetrainSubsytem() {
    frontLeftMotor = new CANSparkMax(Constants.FRONT_LEFT_MOTOR_ID, MotorType.kBrushless);
    frontRightMotor = new CANSparkMax(Constants.FRONT_RIGHT_MOTOR_ID, MotorType.kBrushless);
    backLeftMotor = new CANSparkMax(Constants.BACK_LEFT_MOTOR_ID, MotorType.kBrushless);
    backRightMotor = new CANSparkMax(Constants.BACK_RIGHT_MOTOR_ID, MotorType.kBrushless);

    frontLeftMotor.setIdleMode(IdleMode.kBrake);
    frontRightMotor.setIdleMode(IdleMode.kBrake);
    backLeftMotor.setIdleMode(IdleMode.kBrake);
    backRightMotor.setIdleMode(IdleMode.kBrake);

    backLeftMotor.follow(frontLeftMotor);
    backRightMotor.follow(frontRightMotor);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    if(Math.abs(RobotContainer.controler.getRightX()) > 0.25){
      leftMotorSpeedX = RobotContainer.controler.getRightX() * .5;
      rightMotorSpeedX  = RobotContainer.controler.getRightX() * .5;
    }
    else{
      leftMotorSpeedX = 0;
      rightMotorSpeedX = 0;
    }
    
    if(Math.abs(RobotContainer.controler.getRightY()) > 0.25){
      leftMotorSpeedY = RobotContainer.controler.getRightY() * -.5;
      rightMotorSpeedY = RobotContainer.controler.getRightY() * .5;
    }
    else{
      leftMotorSpeedY = 0;
      rightMotorSpeedY = 0;
    }    
    frontLeftMotor.set(leftMotorSpeedX + leftMotorSpeedY);
    frontRightMotor.set(rightMotorSpeedX + rightMotorSpeedY);

      // frontLeftMotor.set((RobotContainer.controler.getRightY() * -.5) + RobotContainer.controler.getRightX() * .5);
      // frontRightMotor.set((RobotContainer.controler.getRightY() * .5)  + RobotContainer.controler.getRightX() * .5);
    

    if(RobotContainer.controler.getPOV() == 0) {
      frontLeftMotor.set(0.25);
      frontRightMotor.set(0.25 * -1);
    }
    else if(RobotContainer.controler.getPOV() == 90){
      frontLeftMotor.set(0.25);
      frontRightMotor.set(.25);
    }
    else if(RobotContainer.controler.getPOV() == 180){
      frontLeftMotor.set(-0.25);
      frontRightMotor.set(-0.25 * -1);
    }
    else if(RobotContainer.controler.getPOV() == 270){
      frontLeftMotor.set(-0.25);
      frontRightMotor.set(-0.25);
    }
  
  }
}
