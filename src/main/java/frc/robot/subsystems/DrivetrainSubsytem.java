// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

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

  public DrivetrainSubsytem() {
    frontLeftMotor = new CANSparkMax(Constants.FRONT_LEFT_MOTOR_ID, MotorType.kBrushless);
    frontRightMotor = new CANSparkMax(Constants.FRONT_RIGHT_MOTOR_ID, MotorType.kBrushless);
    backLeftMotor = new CANSparkMax(Constants.BACK_LEFT_MOTOR_ID, MotorType.kBrushless);
    backRightMotor = new CANSparkMax(Constants.BACK_RIGHT_MOTOR_ID, MotorType.kBrushless);

    backLeftMotor.follow(frontLeftMotor);
    backRightMotor.follow(frontRightMotor);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    frontLeftMotor.set((RobotContainer.controler.getLeftY() * -1.0 * .5) + RobotContainer.controler.getLeftX()  * .5);
    frontRightMotor.set((RobotContainer.controler.getLeftY() * 1.0 * .5) + RobotContainer.controler.getLeftX() * .5);
    
  }
}
