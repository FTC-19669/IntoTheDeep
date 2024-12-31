package org.firstinspires.ftc.teamcode.core.commands.drive;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.core.hardware.Robot;
import org.firstinspires.ftc.teamcode.pedroPathing.pathGeneration.Path;
import org.firstinspires.ftc.teamcode.pedroPathing.pathGeneration.PathChain;

public class FollowPathCommand extends CommandBase {

    private final PathChain pathChain;

    private final Robot robot = Robot.getInstance();

    private final double speed;

    public FollowPathCommand(Path... paths) {
        this.pathChain = new PathChain(paths);
        this.speed = 1;
    }

    public FollowPathCommand(double speed, Path... paths) {
        this.speed = speed;
        this.pathChain = new PathChain(paths);
    }

    @Override
    public void initialize() {
        robot.setMaxPower(speed);
        robot.followPath(pathChain, true);
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