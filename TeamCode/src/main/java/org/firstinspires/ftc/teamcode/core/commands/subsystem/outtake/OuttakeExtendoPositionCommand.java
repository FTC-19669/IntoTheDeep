package org.firstinspires.ftc.teamcode.core.commands.subsystem.outtake;

import com.arcrobotics.ftclib.command.InstantCommand;

import org.firstinspires.ftc.teamcode.core.hardware.Robot;

public class OuttakeExtendoPositionCommand extends InstantCommand {
    public OuttakeExtendoPositionCommand(int position) {
        super (() -> Robot.getInstance().outtake.moveSlidesToPosition(position));
    }
}
