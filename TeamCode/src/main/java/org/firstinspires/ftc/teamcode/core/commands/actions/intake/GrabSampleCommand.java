package org.firstinspires.ftc.teamcode.core.commands.actions.intake;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.core.hardware.Robot;
import org.firstinspires.ftc.teamcode.core.hardware.subsystems.IntakeSubsystem;

public class GrabSampleCommand extends CommandBase {
    public GrabSampleCommand() {
        addRequirements();
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        // TODO: replace with constants
        Robot.getInstance().intake.setYawPosition(0);
        Robot.getInstance().intake.setPivotPosition(0);
        Robot.getInstance().intake.setArmPosition(0);

        Robot.getInstance().intake.setIntakeState(IntakeSubsystem.IntakeState.INTAKE);
    }

    @Override
    public void end(boolean interrupted) {
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
