package org.firstinspires.ftc.teamcode.core.commands.actions.outtake;

import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.core.commands.subsystem.outtake.ClawPositionCommand;
import org.firstinspires.ftc.teamcode.core.commands.subsystem.outtake.OuttakeSetPivotCommand;
import org.firstinspires.ftc.teamcode.core.commands.subsystem.outtake.OuttakeSetYawCommand;
import org.firstinspires.ftc.teamcode.core.commands.subsystem.outtake.SlideToPositionCommand;
import org.firstinspires.ftc.teamcode.core.util.Constants;

public class ScoreSampleCommand extends SequentialCommandGroup {
    public ScoreSampleCommand() {
        super(
                new ClawPositionCommand(Constants.clawDropPosition),
                new WaitCommand(200),
                new SlideToPositionCommand(0),
                new OuttakeSetYawCommand(Constants.highRotateReadyPosition),
                new OuttakeSetPivotCommand(Constants.highWristReadyPosition)
        );
    }
}
