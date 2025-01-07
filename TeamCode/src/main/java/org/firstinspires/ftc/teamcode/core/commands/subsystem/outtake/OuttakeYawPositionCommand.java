package org.firstinspires.ftc.teamcode.core.commands.subsystem.outtake;

import com.arcrobotics.ftclib.command.InstantCommand;

import org.firstinspires.ftc.teamcode.core.hardware.Robot;

public class OuttakeYawPositionCommand extends InstantCommand {
    public OuttakeYawPositionCommand(double position) {
        super(() -> Robot.getInstance().outtake.setYawPosition(position));
    }
}