// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.LeafBlowerSubsystem;

public class LeafBlowerCommand extends Command {
  /** Creates a new LeafBlowerCommand. */

  LeafBlowerSubsystem m_leafBlowerSubsystem;
  public LeafBlowerCommand(LeafBlowerSubsystem leafBlowerSubsystem) {

    m_leafBlowerSubsystem = leafBlowerSubsystem;
    addRequirements(m_leafBlowerSubsystem);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_leafBlowerSubsystem.runLeafBlower();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_leafBlowerSubsystem.stopLeafBlower();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
