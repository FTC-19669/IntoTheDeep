package org.firstinspires.ftc.teamcode.core.commands.actions.outtake;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.core.commands.subsystem.outtake.ClawPositionCommand;
import org.firstinspires.ftc.teamcode.core.commands.subsystem.outtake.OuttakePowerCommand;
import org.firstinspires.ftc.teamcode.core.commands.subsystem.outtake.OuttakeSetPivotCommand;
import org.firstinspires.ftc.teamcode.core.commands.subsystem.outtake.OuttakeSetYawCommand;
import org.firstinspires.ftc.teamcode.core.commands.subsystem.outtake.SlideToPositionCommand;
import org.firstinspires.ftc.teamcode.core.hardware.Robot;
import org.firstinspires.ftc.teamcode.core.util.Constants;

public class PrimeHighBasketCommand extends SequentialCommandGroup {
    public PrimeHighBasketCommand() {
        super(
                new SequentialCommandGroup(
                        new SlideToPositionCommand((int)Constants.outtakeMaxPosition).alongWith(new ClawPositionCommand(Constants.clawOpenPosition)),
                        new WaitCommand(200),
                        new OuttakeSetPivotCommand(Constants.highWristDropPosition),
                        new OuttakeSetYawCommand(Constants.highRotateDropPosition)
                )
        );
    }

}