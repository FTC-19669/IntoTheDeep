package org.firstinspires.ftc.teamcode.core.commands.subsystem.intake;

import com.arcrobotics.ftclib.command.CommandBase;
import org.firstinspires.ftc.teamcode.core.hardware.Robot;


public class ExtendPowerCommand extends CommandBase {
    double power;
    public ExtendPowerCommand(double power) {
        this.power = power;
        addRequirements();
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        // TODO: make this a constant
        int max = 1000;
        if ((Robot.getInstance().intake.getExtensionPosition() < 0 && power < 0) || (Robot.getInstance().intake.getExtensionPosition() > max && power > 0)) {
            Robot.getInstance().intake.stopExtension();
            return;
        }
        Robot.getInstance().intake.setExtensionPower(power);
    }

    @Override
    public void end(boolean interrupted) {
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
