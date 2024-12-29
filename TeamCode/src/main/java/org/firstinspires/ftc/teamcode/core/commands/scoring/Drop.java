package org.firstinspires.ftc.teamcode.core.commands.scoring;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.core.hardware.Robot;
import org.firstinspires.ftc.teamcode.core.hardware.subsystems.OuttakeSubsystem;

public class Drop extends CommandBase {
    public Drop() {
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        Robot.getInstance().outtake.setRotateState(OuttakeSubsystem.RotateState.DROP);
        Robot.getInstance().outtake.setWristState(OuttakeSubsystem.WristState.DROP);
        Robot.getInstance().outtake.setArmState(OuttakeSubsystem.ArmState.DROP);
        Robot.getInstance().outtake.setClawState(OuttakeSubsystem.ClawState.DROP);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
    }
}
