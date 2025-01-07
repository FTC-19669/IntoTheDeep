package org.firstinspires.ftc.teamcode.core.commands.subsystem.intake;

import com.arcrobotics.ftclib.command.InstantCommand;

import org.firstinspires.ftc.teamcode.core.hardware.Robot;

public class IntakePitchPositionCommand extends InstantCommand {
    public IntakePitchPositionCommand(double position) {
        super(() -> Robot.getInstance().intake.setPitchPosition(position));
    }
}
