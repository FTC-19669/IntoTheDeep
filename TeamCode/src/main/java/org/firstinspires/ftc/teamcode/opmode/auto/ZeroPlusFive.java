package org.firstinspires.ftc.teamcode.opmode.auto;

import static org.firstinspires.ftc.teamcode.core.util.AutonomousHelpers.HeadingInterpolation;
import static org.firstinspires.ftc.teamcode.core.util.AutonomousHelpers.buildCurve;
import static org.firstinspires.ftc.teamcode.core.util.AutonomousHelpers.buildLine;

import com.acmerobotics.dashboard.config.Config;
import com.arcrobotics.ftclib.command.CommandScheduler;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.core.commands.drive.FollowPathCommand;
import org.firstinspires.ftc.teamcode.core.hardware.Robot;
import org.firstinspires.ftc.teamcode.core.util.Constants;
import org.firstinspires.ftc.teamcode.pedroPathing.localization.Pose;
import org.firstinspires.ftc.teamcode.pedroPathing.pathGeneration.Path;
import org.firstinspires.ftc.teamcode.pedroPathing.pathGeneration.Point;

@Config
@Autonomous(name = "0+5", group = "Auto", preselectTeleOp = "Solo")
public class ZeroPlusFive extends LinearOpMode {
    public static Path[] paths = new Path[16];

    public void buildPaths() {
        paths[0] = buildLine(
                Constants.specimenStartPose,
                new Pose(41.063, 65.625, 180),
                HeadingInterpolation.CONSTANT
        );
        paths[1] = buildCurve(
                new Pose(41.063, 65.625, 180),
                new Point(28.125, 50.063),
                new Pose(46.500, 36.750, 270),
                HeadingInterpolation.LINEAR
        );
        paths[2] = buildLine(
                new Pose(46.500, 36.750, 270),
                new Pose(46.500, 36.750, 200),
                HeadingInterpolation.LINEAR
        );
        paths[3] = buildLine(
                new Pose(46.500, 36.750, 200),
                new Pose(46.500, 36.750, 270),
                HeadingInterpolation.LINEAR
        );
        paths[4] = buildLine(
                new Pose(46.500, 36.750, 270),
                new Pose(46.500, 36.750, 200),
                HeadingInterpolation.LINEAR
        );
        paths[5] = buildLine(
                new Pose(46.500, 36.750, 200),
                new Pose(46.500, 28.000, 270),
                HeadingInterpolation.LINEAR
        );
        paths[6] = buildLine(
                new Pose(46.500, 28.000, 270),
                new Pose(46.500, 28.000, 200),
                HeadingInterpolation.LINEAR
        );
        paths[7] = buildCurve(
                new Pose(46.500, 28.000, 200),
                new Point(26.625, 34.688),
                new Pose(7.125, 36.375, 0),
                HeadingInterpolation.LINEAR
        );
        paths[8] = buildCurve(
                new Pose(7.125, 36.375, 0),
                new Point(28.313, 64.125),
                new Pose(41.063, 64.500, 0),
                HeadingInterpolation.CONSTANT
        );
        paths[9] = buildCurve(
                new Pose(41.063, 64.500, 0),
                new Point(28.313, 64.125),
                new Pose(7.125, 36.375, 0),
                HeadingInterpolation.CONSTANT
        );
        paths[10] = buildCurve(
                new Pose(7.125, 36.375, 0),
                new Point(28.313, 64.125),
                new Pose(41.063, 67.500, 0),
                HeadingInterpolation.CONSTANT
        );
        paths[11] = buildCurve(
                new Pose(41.063, 67.500, 0),
                new Point(28.313, 64.125),
                new Pose(7.125, 36.375, 0),
                HeadingInterpolation.CONSTANT
        );
        paths[12] = buildCurve(
                new Pose(7.125, 36.375, 0),
                new Point(28.313, 64.125),
                new Pose(41.063, 69.500, 0),
                HeadingInterpolation.CONSTANT
        );
        paths[13] = buildCurve(
                new Pose(41.063, 69.500, 0),
                new Point(28.313, 64.125),
                new Pose(7.125, 36.375, 0),
                HeadingInterpolation.CONSTANT
        );
        paths[14] = buildCurve(
                new Pose(7.125, 36.375, 0),
                new Point(28.313, 64.125),
                new Pose(41.063, 71.500, 0),
                HeadingInterpolation.CONSTANT
        );
        paths[15] = buildCurve(
                new Pose(41.063, 71.500, 0),
                new Point(13.875, 47.625),
                new Pose(6.750, 37.500, 0),
                HeadingInterpolation.CONSTANT
        );
    }

    @Override
    public void runOpMode() {
        Robot robot = Robot.getInstance();

        robot.initialize(hardwareMap, telemetry);
        CommandScheduler.getInstance().reset();

        buildPaths();

        while (!isStarted()) {
            CommandScheduler.getInstance().run();
        }

        robot.setStartingPose(Constants.specimenStartPose);

        CommandScheduler.getInstance().schedule(
                new SequentialCommandGroup(
                        new FollowPathCommand(paths[0]),
                        new FollowPathCommand(paths[1]),
                        new FollowPathCommand(paths[2]),
                        new FollowPathCommand(paths[3]),
                        new FollowPathCommand(paths[4]),
                        new FollowPathCommand(paths[5]),
                        new FollowPathCommand(paths[6]),
                        new FollowPathCommand(paths[7]),
                        new FollowPathCommand(paths[8]),
                        new FollowPathCommand(paths[9]),
                        new FollowPathCommand(paths[10]),
                        new FollowPathCommand(paths[11]),
                        new FollowPathCommand(paths[12]),
                        new FollowPathCommand(paths[13]),
                        new FollowPathCommand(paths[14]),
                        new FollowPathCommand(paths[15])
                )
        );

        while (opModeIsActive() && !isStopRequested()) {
            CommandScheduler.getInstance().run();
        }
    }
}