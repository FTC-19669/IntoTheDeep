package org.firstinspires.ftc.teamcode.core.commands.subsystem.outtake;

import com.arcrobotics.ftclib.command.InstantCommand;

import org.firstinspires.ftc.teamcode.core.hardware.Robot;

public class OuttakeExtendoPowerCommand extends InstantCommand {
    public OuttakeExtendoPowerCommand(double power) {
        super(() -> Robot.getInstance().outtake.setSlidePower(power));
    }
}
