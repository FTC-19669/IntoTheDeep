package org.firstinspires.ftc.teamcode.core.commands.actions;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.core.hardware.Robot;
import org.firstinspires.ftc.teamcode.core.hardware.subsystems.IntakeSubsystem;

public class TransferCommand extends CommandBase {
    public TransferCommand() {
        addRequirements();
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
    }

    @Override
    public void end(boolean interrupted) {
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
