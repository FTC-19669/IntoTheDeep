package org.firstinspires.ftc.teamcode.opmode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import com.arcrobotics.ftclib.command.Command;
import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.CommandScheduler;
import com.arcrobotics.ftclib.command.ConditionalCommand;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;
import com.arcrobotics.ftclib.gamepad.ButtonReader;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.gamepad.KeyReader;

import org.firstinspires.ftc.teamcode.pedroPathing.localization.Pose;

import org.firstinspires.ftc.teamcode.core.hardware.Robot;
import org.firstinspires.ftc.teamcode.core.hardware.drivetrain.Localizer;
import org.firstinspires.ftc.teamcode.core.hardware.RobotData;



@TeleOp(name = "Solo", group = "TeleOp")
public class Solo extends CommandOpMode {

    private final Robot robot = Robot.getInstance();
    private final RobotData data = Robot.getInstance().data;
    private final CommandScheduler cs = CommandScheduler.getInstance();
    private final GamepadEx gamepad = new GamepadEx(gamepad1);

    Pose currentPose;
    double heading;

    @Override
    public void initialize() {
        robot.initialize(hardwareMap, telemetry);

        data.stopIntakingSample();
        data.stopScoringSample();
        data.stopScoringSpecimen();
        data.setSampleUnloaded();
        data.setSpecimenUnloaded();

        robot.startTeleopDrive();
    }

    @Override
    public void run() {
        cs.run();
        robot.periodic();

        robot.update();
        currentPose = robot.getPose();
        heading = currentPose.getHeading();

        double y = -gamepad1.left_stick_y;
        double x = gamepad1.left_stick_x * 1.1;
        double rx = gamepad1.right_stick_x * 0.8;

        robot.setTeleOpMovementVectors(y, x, rx, true);

    }

}
