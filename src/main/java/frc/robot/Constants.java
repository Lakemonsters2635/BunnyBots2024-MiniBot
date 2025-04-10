// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static int FRONT_RIGHT_MOTOR_ID = 5;
  public static int FRONT_LEFT_MOTOR_ID = 4;
  public static int BACK_RIGHT_MOTOR_ID = 2;
  public static int BACK_LEFT_MOTOR_ID = 6;

  public static int XBOX_CONTROLLER_PORT = 0;

  //leaf Blower
  public static int LEAF_BLOWER_MOTOR_ID = 10;
  // public static int LEAF_BLOWER_BUTTON = 2; //Button A for some controller
  public static int LEAF_BLOWER_BUTTON = 0; //Button A for Mostly Operation Logitech X-box controller
  public static double LEAF_BLOWER_RUN_SPEED = 1; 
  public static int LEAF_BLOWER_STOP_SPEED = 0;
}
