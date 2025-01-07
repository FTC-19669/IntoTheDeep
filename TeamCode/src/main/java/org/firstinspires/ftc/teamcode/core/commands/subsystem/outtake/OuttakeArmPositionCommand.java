package org.firstinspires.ftc.teamcode.core.commands.subsystem.outtake;

import com.arcrobotics.ftclib.command.InstantCommand;

import org.firstinspires.ftc.teamcode.core.hardware.Robot;

public class OuttakeArmPositionCommand extends InstantCommand {
    public OuttakeArmPositionCommand(double position) {
        super(() -> Robot.getInstance().outtake.setArmPosition(position));
    }
}
