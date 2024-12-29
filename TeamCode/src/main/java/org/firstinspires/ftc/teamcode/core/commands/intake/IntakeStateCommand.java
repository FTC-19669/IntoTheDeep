package org.firstinspires.ftc.teamcode.core.commands.intake;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.command.InstantCommand;

import org.firstinspires.ftc.teamcode.core.hardware.Robot;
import org.firstinspires.ftc.teamcode.core.hardware.subsystems.IntakeSubsystem;

public class IntakeStateCommand extends InstantCommand {
    public IntakeStateCommand(IntakeSubsystem.IntakeState state) {
        super(() -> Robot.getInstance().intake.setIntakeState(state));

    }
}
