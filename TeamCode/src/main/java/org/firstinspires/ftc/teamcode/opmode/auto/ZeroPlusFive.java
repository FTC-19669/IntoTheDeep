package org.firstinspires.ftc.teamcode.opmode.auto;

import static org.firstinspires.ftc.teamcode.common.util.AutonomousHelpers.HeadingInterpolation;
import static org.firstinspires.ftc.teamcode.common.util.AutonomousHelpers.buildCurve;
import static org.firstinspires.ftc.teamcode.common.util.AutonomousHelpers.buildLine;

import com.acmerobotics.dashboard.config.Config;
import com.arcrobotics.ftclib.command.CommandScheduler;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.common.commands.drive.PathCommand;
import org.firstinspires.ftc.teamcode.common.hardware.Robot;
import org.firstinspires.ftc.teamcode.pedroPathing.localization.Pose;
import org.firstinspires.ftc.teamcode.pedroPathing.pathGeneration.Path;
import org.firstinspires.ftc.teamcode.pedroPathing.pathGeneration.Point;

@Config
@Autonomous(name = "0+5", preselectTeleOp = "Duo")
public class ZeroPlusFive extends LinearOpMode {
    public static Path lineOne, lineTwo, lineThree, lineFour, lineFive, lineSix, lineSeven,
            lineEight, lineNine, lineTen, lineEleven, lineTwelve, lineThirteen, lineFourteen,
            lineFifteen, lineSixteen;

    public void buildPaths() {
        lineOne = buildLine(
                new Pose(6.375, 65.625, 180),
                new Pose(41.063, 65.625, 180),
                HeadingInterpolation.CONSTANT
        );
        lineTwo = buildCurve(
                new Pose(41.063, 65.625, 180),
                new Point(28.125, 50.063),
                new Pose(46.500, 36.750, 270),
                HeadingInterpolation.LINEAR
        );
        lineThree = buildLine(
                new Pose(46.500, 36.750, 270),
                new Pose(46.500, 36.750, 200),
                HeadingInterpolation.LINEAR
        );
        lineFour = buildLine(
                new Pose(46.500, 36.750, 200),
                new Pose(46.500, 36.750, 270),
                HeadingInterpolation.LINEAR
        );
        lineFive = buildLine(
                new Pose(46.500, 36.750, 270),
                new Pose(46.500, 36.750, 200),
                HeadingInterpolation.LINEAR
        );
        lineSix = buildLine(
                new Pose(46.500, 36.750, 200),
                new Pose(46.500, 28.000, 270),
                HeadingInterpolation.LINEAR
        );
        lineSeven = buildLine(
                new Pose(46.500, 28.000, 270),
                new Pose(46.500, 28.000, 200),
                HeadingInterpolation.LINEAR
        );
        lineEight = buildCurve(
                new Pose(46.500, 28.000, 200),
                new Point(26.625, 34.688),
                new Pose(7.125, 36.375, 0),
                HeadingInterpolation.LINEAR
        );
        lineNine = buildCurve(
                new Pose(7.125, 36.375, 0),
                new Point(28.313, 64.125),
                new Pose(41.063, 64.500, 0),
                HeadingInterpolation.CONSTANT
        );
        lineTen = buildCurve(
                new Pose(41.063, 64.500, 0),
                new Point(28.313, 64.125),
                new Pose(7.125, 36.375, 0),
                HeadingInterpolation.CONSTANT
        );
        lineEleven = buildCurve(
                new Pose(7.125, 36.375, 0),
                new Point(28.313, 64.125),
                new Pose(41.063, 67.500, 0),
                HeadingInterpolation.CONSTANT
        );
        lineTwelve = buildCurve(
                new Pose(41.063, 67.500, 0),
                new Point(28.313, 64.125),
                new Pose(7.125, 36.375, 0),
                HeadingInterpolation.CONSTANT
        );
        lineThirteen = buildCurve(
                new Pose(7.125, 36.375, 0),
                new Point(28.313, 64.125),
                new Pose(41.063, 69.500, 0),
                HeadingInterpolation.CONSTANT
        );
        lineFourteen = buildCurve(
                new Pose(41.063, 69.500, 0),
                new Point(28.313, 64.125),
                new Pose(7.125, 36.375, 0),
                HeadingInterpolation.CONSTANT
        );
        lineFifteen = buildCurve(
                new Pose(7.125, 36.375, 0),
                new Point(28.313, 64.125),
                new Pose(41.063, 71.500, 0),
                HeadingInterpolation.CONSTANT
        );
        lineSixteen = buildCurve(
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

        robot.setPose(new Pose(6.375, 65.625, 180));

        CommandScheduler.getInstance().schedule(
                new SequentialCommandGroup(
                        new PathCommand(lineOne),
                        new PathCommand(lineTwo),
                        new PathCommand(lineThree),
                        new PathCommand(lineFour),
                        new PathCommand(lineFive),
                        new PathCommand(lineSix),
                        new PathCommand(lineSeven),
                        new PathCommand(lineEight),
                        new PathCommand(lineNine),
                        new PathCommand(lineTen),
                        new PathCommand(lineEleven),
                        new PathCommand(lineTwelve),
                        new PathCommand(lineThirteen),
                        new PathCommand(lineFourteen),
                        new PathCommand(lineFifteen),
                        new PathCommand(lineSixteen)
                )
        );

        while (opModeIsActive() && !isStopRequested()) {
            CommandScheduler.getInstance().run();
        }
    }
}