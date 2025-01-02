package org.firstinspires.ftc.teamcode.core.commands.subsystem.intake;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.core.hardware.Robot;
import org.firstinspires.ftc.teamcode.core.hardware.subsystems.IntakeSubsystem;

public class IntakeEjectCommand extends CommandBase {
    public IntakeEjectCommand() {
        addRequirements();
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        // TODO: replace values with constants
        Robot.getInstance().intake.setYawPosition(0);
        Robot.getInstance().intake.setPivotPosition(0);
        Robot.getInstance().intake.setArmPosition(500);
        Robot.getInstance().intake.setIntakeState(IntakeSubsystem.IntakeState.TRANSFER);
    }

    @Override
    public void end(boolean interrupted) {
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
