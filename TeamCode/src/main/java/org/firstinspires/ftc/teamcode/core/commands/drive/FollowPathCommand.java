package org.firstinspires.ftc.teamcode.core.commands.drive;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.core.hardware.Robot;
import org.firstinspires.ftc.teamcode.pedroPathing.pathGeneration.Path;
import org.firstinspires.ftc.teamcode.pedroPathing.pathGeneration.PathChain;

public class FollowPathCommand extends CommandBase {

    private final PathChain path;

    private final Robot robot = Robot.getInstance();

    private final double speed;

    public FollowPathCommand(Path... paths) {
        this.path = new PathChain(paths);
        this.speed = 1;
    }

    public FollowPathCommand(double speed, Path... paths) {
        this.speed = speed;
        this.path = new PathChain(paths);
    }

    @Override
    public void initialize() {
        robot.setMaxPower(speed);
        robot.followPath(path, true);
    }

    @Override
    public void execute() {
        robot.update();
        robot.getDashboardPoseTracker().update();
    }

    @Override
    public boolean isFinished() {
        double xError = Math.abs(robot.getPose().getX() - path.getPath(0).getLastControlPoint().getX());
        double yError = Math.abs(robot.getPose().getY() - path.getPath(0).getLastControlPoint().getY());
        double headingError = Math.abs(robot.getPose().getHeading() - path.getPath(0).getHeadingGoal(1));

        return xError < 1 && yError < 1 && headingError < 2;
    }
}