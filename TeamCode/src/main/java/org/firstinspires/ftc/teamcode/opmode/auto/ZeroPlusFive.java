package org.firstinspires.ftc.teamcode.opmode.auto;

// FTCLib/Road Runner
import com.acmerobotics.dashboard.config.Config;
import com.arcrobotics.ftclib.command.CommandScheduler;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.ParallelCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

// pedroPathing
import org.firstinspires.ftc.teamcode.pedroPathing.localization.Pose;
import org.firstinspires.ftc.teamcode.pedroPathing.pathGeneration.Path;

// FTC SDK
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.robotcore.external.Telemetry;

// util
import org.firstinspires.ftc.teamcode.common.util.AutonomousHelpers;
import org.firstinspires.ftc.teamcode.common.util.Constants;

@Config
@Autonomous(name = "0+5", preselectTeleOp = "Duo")
public class ZeroPlusFive extends LinearOpMode {
    public static Path preload;
    public void buildPaths() {}

    @Override
    public void runOpMode() {}
}
