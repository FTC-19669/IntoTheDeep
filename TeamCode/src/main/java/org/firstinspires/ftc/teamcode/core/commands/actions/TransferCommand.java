package org.firstinspires.ftc.teamcode.core.commands.actions;

import com.arcrobotics.ftclib.command.CommandBase;

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
        // TODO: make this a constant
        double placeHolder = 0.0;

        Robot.getInstance().intake.setIntakeState(IntakeSubsystem.IntakeState.TRANSFER);
        Robot.getInstance().intake.setYawPosition(placeHolder);
        Robot.getInstance().intake.setPivotPosition(placeHolder);
        Robot.getInstance().intake.setArmPosition(placeHolder);
        Robot.getInstance().outtake.moveSlidesToPosition(0);
        Robot.getInstance().outtake.setArmPosition(placeHolder);
        Robot.getInstance().outtake.setClawPosition(placeHolder);
        Robot.getInstance().outtake.setPivotPosition(placeHolder);
    }

    @Override
    public void end(boolean interrupted) {
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
