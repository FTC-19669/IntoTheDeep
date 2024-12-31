package org.firstinspires.ftc.teamcode.core.commands.actions.intake;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.core.hardware.Robot;

public class IntakeAdjustYawCommand extends CommandBase {
    double adjust;
    public IntakeAdjustYawCommand(double adjust) {
        this.adjust = adjust;
        addRequirements();
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        double yaw = Robot.getInstance().intake.getYawPosition();
        Robot.getInstance().intake.setYawPosition(yaw+adjust);
    }

    @Override
    public void end(boolean interrupted) {
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
