package org.firstinspires.ftc.teamcode.common.hardware;

public class RobotData {
    public long loopTime = System.currentTimeMillis();

    public boolean scoringSample = false;
    public boolean scoringSpecimen = false;

    public boolean sampleLoaded = false;
    public boolean specimenLoaded = false;
    
    public boolean intakingSample = false;
    public boolean intakingSpecimen = false;

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
