package org.firstinspires.ftc.teamcode.core.commands.actions.outtake;

import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.core.commands.subsystem.outtake.ClawPositionCommand;
import org.firstinspires.ftc.teamcode.core.commands.subsystem.outtake.OuttakeSetPivotCommand;
import org.firstinspires.ftc.teamcode.core.commands.subsystem.outtake.OuttakeSetYawCommand;
import org.firstinspires.ftc.teamcode.core.commands.subsystem.outtake.SlideToPositionCommand;
import org.firstinspires.ftc.teamcode.core.util.Constants;

public class ScoreSpecimenCommand extends SequentialCommandGroup {
    public ScoreSpecimenCommand() {
        super(
                new SlideToPositionCommand((int)Constants.hangSpecimenPosition).alongWith(new ClawPositionCommand(Constants.clawOpenPosition)),
                new WaitCommand(200),
                new OuttakeSetPivotCommand(Constants.highWristHangClipPosition),
                new OuttakeSetYawCommand(Constants.highRotateHangClipPosition),
                new WaitCommand(200),
//                TODO: below, replace constants with correct constants
                new SlideToPositionCommand((int)Constants.hangSpecimenPosition),
                new WaitCommand(200),
                new ClawPositionCommand(Constants.clawOpenPosition),
                new SlideToPositionCommand(0),
                new OuttakeSetYawCommand(Constants.highRotateReadyPosition),
                new OuttakeSetPivotCommand(Constants.highWristReadyPosition)

        );
    }
}
