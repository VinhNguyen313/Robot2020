/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;
import frc.robot.util.VorTXTalonSRX;

public class Intake extends SubsystemBase {
  CANSparkMax rollers;
  VorTXTalonSRX pivot;
  VorTXTalonSRX belt;

  public Intake() {
    rollers = new CANSparkMax(RobotMap.Intake.rollers, MotorType.kBrushless);
    pivot = new VorTXTalonSRX(RobotMap.Intake.pivot);
    belt = new VorTXTalonSRX(RobotMap.Intake.belt);

  }

  public void setBelt(double speed){
    belt.set(speed);
  }

  public void setPivot(double speed) {
    pivot.set(speed);
  }

  public void setRollers(double speed) {
    rollers.set(speed);
  }

  public void suckBalls(double speed, double pivot){
    setBelt(-speed);
    setRollers(speed);
    setPivot(pivot);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
