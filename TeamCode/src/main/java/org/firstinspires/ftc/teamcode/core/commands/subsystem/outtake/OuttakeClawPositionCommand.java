package org.firstinspires.ftc.teamcode.core.commands.subsystem.outtake;

import com.arcrobotics.ftclib.command.InstantCommand;

import org.firstinspires.ftc.teamcode.core.hardware.Robot;

public class OuttakeClawPositionCommand extends InstantCommand {
    public OuttakeClawPositionCommand(double position) {
        super(() -> Robot.getInstance().outtake.setClawPosition(position));
    }
}
