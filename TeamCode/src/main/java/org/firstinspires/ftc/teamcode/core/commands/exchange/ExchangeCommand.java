package org.firstinspires.ftc.teamcode.core.commands.exchange;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.core.hardware.Robot;
import org.firstinspires.ftc.teamcode.core.hardware.subsystems.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.core.hardware.subsystems.OuttakeSubsystem;

public class ExchangeCommand extends CommandBase {
    public ExchangeCommand() {
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        Robot.getInstance().intake.setSystemState(IntakeSubsystem.SystemState.EXCHANGE);
        Robot.getInstance().outtake.setSlideState(OuttakeSubsystem.SlideState.RETRACT);
        Robot.getInstance().outtake.setArmState(OuttakeSubsystem.ArmState.EXCHANGE);
        Robot.getInstance().outtake.setClawState(OuttakeSubsystem.ClawState.EXCHANGE);
        Robot.getInstance().outtake.setWristState(OuttakeSubsystem.WristState.EXCHANGE);
        Robot.getInstance().outtake.setRotateState(OuttakeSubsystem.RotateState.EXCHANGE);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
    }
}
