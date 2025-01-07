package org.firstinspires.ftc.teamcode.core.commands.subsystem.intake;

import com.arcrobotics.ftclib.command.InstantCommand;

import org.firstinspires.ftc.teamcode.core.hardware.Robot;
import org.firstinspires.ftc.teamcode.core.hardware.subsystems.IntakeSubsystem;

public class IntakeStateCommand extends InstantCommand {
    public IntakeStateCommand(IntakeSubsystem.IntakeState state) {
        super(() -> Robot.getInstance().intake.setIntakeState(state));
    }
}
