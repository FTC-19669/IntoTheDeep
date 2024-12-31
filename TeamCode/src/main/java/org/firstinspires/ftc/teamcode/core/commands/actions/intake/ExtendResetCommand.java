package org.firstinspires.ftc.teamcode.core.commands.actions.intake;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.core.hardware.Robot;

public class ExtendResetCommand extends CommandBase {
    public ExtendResetCommand() {
        addRequirements();
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        Robot.getInstance().intake.resetExtensionEncoder();
    }

    @Override
    public void end(boolean interrupted) {
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
