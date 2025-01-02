package org.firstinspires.ftc.teamcode.core.commands.subsystem.outtake;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.core.hardware.Robot;
import org.firstinspires.ftc.teamcode.core.util.Constants;

public class SlideToPositionCommand extends CommandBase {
    int position;
    public SlideToPositionCommand(int position) {
        this.position = position;
        addRequirements();
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        Robot.getInstance().outtake.moveSlidesToPosition(position);

    }

    @Override
    public void end(boolean interrupted) {
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
