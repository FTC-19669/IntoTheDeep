package org.firstinspires.ftc.teamcode.core.commands.subsystem.outtake;

import com.arcrobotics.ftclib.command.InstantCommand;

import org.firstinspires.ftc.teamcode.core.hardware.Robot;

public class OuttakePitchPositionCommand extends InstantCommand {
    public OuttakePitchPositionCommand(double position) {
        super(() -> Robot.getInstance().outtake.setPitchPosition(position));
    }
}
