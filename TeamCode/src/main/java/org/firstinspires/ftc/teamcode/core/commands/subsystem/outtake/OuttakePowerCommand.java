package org.firstinspires.ftc.teamcode.core.commands.subsystem.outtake;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.core.hardware.Robot;

public class OuttakePowerCommand extends CommandBase {
    double power;
    public OuttakePowerCommand(double power) {
        this.power = power;
        addRequirements();
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        Robot.getInstance().outtake.setSlidePower(power);
    }

    @Override
    public void end(boolean interrupted) {
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
