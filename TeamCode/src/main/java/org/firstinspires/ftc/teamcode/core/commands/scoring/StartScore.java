package org.firstinspires.ftc.teamcode.core.commands.scoring;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.core.hardware.Robot;
import org.firstinspires.ftc.teamcode.core.hardware.subsystems.OuttakeSubsystem;

public class StartScore extends CommandBase {
    public StartScore() {
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        Robot.getInstance().outtake.setSlideState(OuttakeSubsystem.SlideState.EXTEND);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
    }
}
