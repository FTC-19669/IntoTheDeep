package org.firstinspires.ftc.teamcode.core.commands.actions.intake;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.core.hardware.Robot;

public class ExtendToPositionCommand extends CommandBase {
    int position;
    double power;
    public ExtendToPositionCommand(int position, double power) {
        this.position = position;
        this.power = power;
        addRequirements();
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        Robot.getInstance().intake.setExtensionPosition(position, power);
    }

    @Override
    public void end(boolean interrupted) {
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
