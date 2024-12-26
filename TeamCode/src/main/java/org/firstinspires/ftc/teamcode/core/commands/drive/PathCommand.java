package org.firstinspires.ftc.teamcode.core.commands.drive;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.core.hardware.Robot;
import org.firstinspires.ftc.teamcode.pedroPathing.pathGeneration.Path;

public class PathCommand extends CommandBase {

    private final Path path;

    private final Robot robot = Robot.getInstance();

    private final double speed;

    public PathCommand(Path path) {
        this.path = path;
        this.speed = 1;
    }

    public PathCommand(Path path, double speed) {
        this.path = path;
        this.speed = speed;
    }

    @Override
    public void initialize() {
        robot.setMaxPower(speed);
        robot.followPath(path, false);
    }

    @Override
    public void execute() {
        robot.update();
        robot.getDashboardPoseTracker().update();
    }

    @Override
    public boolean isFinished() {
        return Thread.currentThread().isInterrupted() || !robot.isBusy();
    }

    @Override
    public void end(boolean interrupted) {
        robot.setMaxPower(1);
    }
}