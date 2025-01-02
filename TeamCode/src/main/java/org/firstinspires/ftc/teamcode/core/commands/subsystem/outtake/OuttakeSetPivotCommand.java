package org.firstinspires.ftc.teamcode.core.commands.subsystem.outtake;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.core.hardware.Robot;

public class OuttakeSetPivotCommand extends CommandBase {
    double position;
    public OuttakeSetPivotCommand(double position) {
        this.position = position;
        addRequirements();
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        Robot.getInstance().outtake.setPivotPosition(position);
    }

    @Override
    public void end(boolean interrupted) {
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
