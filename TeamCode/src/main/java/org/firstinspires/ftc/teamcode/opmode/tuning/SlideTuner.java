package org.firstinspires.ftc.teamcode.opmode.tuning;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;

@TeleOp(name = "SlideTunerWithRunToPosition", group = "test")
public class SlideTuner extends LinearOpMode {

    private DcMotorEx slideMotor;

    // Adjust these increments as needed
    private static final int TICK_INCREMENT = 50;      // Normal increment/decrement
    private static final int FINE_TICK_INCREMENT = 5;  // Fine increment/decrement

    private int targetPosition = 0;
    private double motorPower = 0.5; // Power for RUN_TO_POSITION moves

    @Override
    public void runOpMode() throws InterruptedException {
        // Initialize the slide motor from the hardware map
        slideMotor = hardwareMap.get(DcMotorEx.class, "slideMotorName");

        // Reset encoder and set up RUN_TO_POSITION mode
        slideMotor.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        slideMotor.setTargetPosition(targetPosition);
        slideMotor.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        slideMotor.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        slideMotor.setPower(motorPower);

        waitForStart();

        while (opModeIsActive()) {
            // Increase/Decrease target position with D-Pad up/down
            if (gamepad1.dpad_up) {
                targetPosition += TICK_INCREMENT;
                sleep(200); // small delay to prevent overly fast increments
            } else if (gamepad1.dpad_down) {
                targetPosition -= TICK_INCREMENT;
                sleep(200);
            }

            // Fine adjustments with D-Pad left/right
            if (gamepad1.dpad_right) {
                targetPosition += FINE_TICK_INCREMENT;
                sleep(200);
            } else if (gamepad1.dpad_left) {
                targetPosition -= FINE_TICK_INCREMENT;
                sleep(200);
            }

            // Clamp the target position if desired (to avoid going negative or beyond max)
            // Example: if your slide shouldn't go below 0:
            if (targetPosition < 0) {
                targetPosition = 0;
            }

            // Set the new target position
            slideMotor.setTargetPosition(targetPosition);

            // Update telemetry
            int currentPosition = slideMotor.getCurrentPosition();
            telemetry.addData("Current Pos", currentPosition);
            telemetry.addData("Target Pos", targetPosition);
            telemetry.addData("Difference", targetPosition - currentPosition);
            telemetry.addData("Power", motorPower);
            telemetry.update();
        }
    }
}