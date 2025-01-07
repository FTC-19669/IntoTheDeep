package org.firstinspires.ftc.teamcode.core.hardware;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.robotcore.external.Telemetry;

import com.arcrobotics.ftclib.command.CommandScheduler;

import org.firstinspires.ftc.teamcode.core.hardware.drivetrain.MecanumDrive;
import org.firstinspires.ftc.teamcode.core.hardware.subsystems.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.core.hardware.subsystems.OuttakeSubsystem;
import org.firstinspires.ftc.teamcode.core.hardware.subsystems.PTOSubsystem;
import org.firstinspires.ftc.teamcode.core.hardware.subsystems.vision.VisionSubsystem;
import org.firstinspires.ftc.teamcode.core.util.wrappers.WSubsystemBase;

import java.util.ArrayList;

public class Robot extends MecanumDrive {
    public Telemetry telemetry;
    private ElapsedTime runtime = new ElapsedTime();

    private static Robot instance = null;
    public static RobotData data = new RobotData();

    public ArrayList<WSubsystemBase> subsystems;
    public IntakeSubsystem intake;
    public OuttakeSubsystem outtake;
    public PTOSubsystem pto;
    public VisionSubsystem vision;

    public void initialize(HardwareMap hardwareMap, Telemetry telemetry) {
        initializePedro(hardwareMap);
        CommandScheduler.getInstance().reset();
        this.telemetry = telemetry;
        subsystems = new ArrayList<>();

        intake = new IntakeSubsystem(hardwareMap);
        outtake = new OuttakeSubsystem(hardwareMap);
        pto = new PTOSubsystem(hardwareMap);
        // vision = new VisionSubsystem(hardwareMap);
    }

    public void write() {
        data.write(telemetry);
    }

    public void periodic() {
        for (WSubsystemBase subsystem : subsystems) {
            subsystem.periodic();
        }
    }

    public void updateData() {
        for (WSubsystemBase subsystem : subsystems) {
            subsystem.updateData();
        }
        this.data.currentPose = this.getPose();
    }

    public static Robot getInstance() {
        if (instance == null) {
            instance = new Robot();
        }
        return instance;
    }
}