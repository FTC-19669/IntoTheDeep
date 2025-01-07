package org.firstinspires.ftc.teamcode.core.commands.subsystem.intake;

import com.arcrobotics.ftclib.command.InstantCommand;

import org.firstinspires.ftc.teamcode.core.hardware.Robot;

public class IntakeYawPositionCommand extends InstantCommand {
    public IntakeYawPositionCommand(double position) {
        super(() -> Robot.getInstance().intake.setYawPosition(position));
    }
}
