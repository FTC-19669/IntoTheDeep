package org.firstinspires.ftc.teamcode.common.hardware;

import com.arcrobotics.ftclib.command.CommandScheduler;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.teamcode.common.hardware.drivetrain.MecanumDrive;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;

public class Robot extends MecanumDrive {

    public Telemetry telemetry;
    private ElapsedTime runtime = new ElapsedTime();

    public WebcamName webcam;
    public VisionPortal visionPortal;
    public AprilTagProcessor aprilTagProcessor;


    private static Robot instance = null;

    public void initialize(HardwareMap hardwareMap, Telemetry telemetry_) {
        initializePedro(hardwareMap);

        CommandScheduler.getInstance().reset();
    }

    public void write() {
//        this.data.write(telemetry);
    }

    public void periodic() {
//        for (RE_SubsystemBase subsystem : subsystems) {
//            subsystem.periodic();
//        }
    }

    public void updateData() {
//        for (RE_SubsystemBase subsystem : subsystems) {
//            subsystem.updateData();
//        }
//        this.data.currentPose = this.getPose();
    }

//    private void startCamera() {
//        sampleAlignmentProcessor = new SampleAlignmentProcessor();
//        aprilTagProcessor = new AprilTagProcessor.Builder().build();
//        aprilTagProcessor.setDecimation(2);
//        visionPortal = new VisionPortal.Builder()
//                .addProcessor(aprilTagProcessor)
//                .addProcessor(sampleAlignmentProcessor)
//                .setCamera(webcam)
//                .build();
//    }

    public static Robot getInstance() {
        if (instance == null) {
            instance = new Robot();
        }
        return instance;
    }
}