package org.firstinspires.ftc.teamcode.core.commands.intake;

import com.arcrobotics.ftclib.command.InstantCommand;

import org.firstinspires.ftc.teamcode.core.hardware.Robot;
import org.firstinspires.ftc.teamcode.core.hardware.subsystems.IntakeSubsystem;

public class IntakeSystemStateCommand extends InstantCommand {
    public IntakeSystemStateCommand(IntakeSubsystem.SystemState state) {
        super(() -> Robot.getInstance().intake.setSystemState(state));

    }
}
