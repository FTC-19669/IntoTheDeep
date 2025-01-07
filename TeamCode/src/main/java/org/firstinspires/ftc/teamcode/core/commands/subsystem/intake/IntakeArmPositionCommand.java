package org.firstinspires.ftc.teamcode.core.commands.subsystem.intake;

import com.arcrobotics.ftclib.command.InstantCommand;

import org.firstinspires.ftc.teamcode.core.hardware.Robot;

public class IntakeArmPositionCommand extends InstantCommand {
    public IntakeArmPositionCommand(double position) {
        super(() -> Robot.getInstance().intake.setArmPosition(position));
    }
}
