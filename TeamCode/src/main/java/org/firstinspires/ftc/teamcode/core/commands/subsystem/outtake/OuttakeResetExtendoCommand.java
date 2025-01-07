package org.firstinspires.ftc.teamcode.core.commands.subsystem.outtake;

import com.arcrobotics.ftclib.command.InstantCommand;

import org.firstinspires.ftc.teamcode.core.hardware.Robot;

public class OuttakeResetExtendoCommand extends InstantCommand {
    public OuttakeResetExtendoCommand() {
        super(() -> Robot.getInstance().outtake.resetSlides());
    }
}
