package org.firstinspires.ftc.teamcode.core.hardware;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.pedroPathing.localization.Pose;

public class RobotData {
    public long loopTime = System.currentTimeMillis();

    public Pose currentPose = new Pose(0,0, Math.toRadians(0));

    public boolean scoringSample = false;
    public boolean scoringSpecimen = false;

    public boolean sampleLoaded = false;
    public boolean specimenLoaded = false;

    public boolean intakingSample = false;
    public boolean intakingSpecimen = false;


    // TODO: Add hardware data as variable and to write() method
    public void write(Telemetry telemetry) {
        telemetry.addData("Loop Time:", System.currentTimeMillis() - loopTime);
        loopTime = System.currentTimeMillis();

        telemetry.addLine();

        telemetry.addData("Pose:", currentPose);
        telemetry.addData("Busy:", Robot.getInstance().isBusy());

        telemetry.addLine();

        telemetry.addData("Scoring Sample", scoringSample);
        telemetry.addData("Scoring Specimen", scoringSpecimen);
        telemetry.addData("Sample Loaded", sampleLoaded);
        telemetry.addData("Specimen Loaded", specimenLoaded);
        telemetry.addData("Intaking Sample", intakingSample);
        telemetry.addData("Intaking Specimen", intakingSpecimen);

        telemetry.update();
    }


    public void startScoringSample() {
        scoringSample = true;
        intakingSample = false;
    }

    public void stopScoringSample() {
        scoringSample = false;
        intakingSample = false;
    }

    public void startIntakingSample() {
        scoringSample = false;
        intakingSample = true;
    }

    public void stopIntakingSample() {
        scoringSample = false;
        intakingSample = false;
    }

    public void setSampleLoaded() {
        sampleLoaded = true;
    }

    public void setSampleUnloaded() {
        sampleLoaded = false;
    }

    public void startScoringSpecimen() {
        scoringSpecimen = true;
        intakingSpecimen = false;
    }

    public void stopScoringSpecimen() {
        scoringSpecimen = false;
        intakingSpecimen = false;
    }

    public void startIntakingSpecimen() {
        scoringSpecimen = false;
        intakingSpecimen = true;
    }

    public void stopIntakingSpecimen() {
        scoringSpecimen = false;
        intakingSpecimen = false;
    }

    public void setSpecimenLoaded() {
        specimenLoaded = true;
    }

    public void setSpecimenUnloaded() {
        specimenLoaded = false;
    }
}
