package org.firstinspires.ftc.teamcode.common.commands.drive;

import com.arcrobotics.ftclib.command.CommandBase;
import org.firstinspires.ftc.teamcode.common.hardware.Robot;
import org.firstinspires.ftc.teamcode.pedroPathing.pathGeneration.PathChain;

public class PathChainCommand extends CommandBase {

    private final PathChain pathChain;
    private final Robot robot = Robot.getInstance();
    private final double speed;

    public PathChainCommand(PathChain pathChain) {
        this.pathChain = pathChain;
        this.speed = 1;
    }

    public PathChainCommand(PathChain pathChain, double speed) {
        this.pathChain = pathChain;
        this.speed = speed;
    }

    @Override
    public void initialize() {
        robot.setMaxPower(speed);
        robot.followPath(pathChain, false);
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