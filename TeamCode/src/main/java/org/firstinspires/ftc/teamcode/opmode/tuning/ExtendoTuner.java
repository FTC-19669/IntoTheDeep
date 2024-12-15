package org.firstinspires.ftc.teamcode.opmode.tuning;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;

@TeleOp(name = "ExtendoTuner", group = "test")
public class ExtendoTuner extends LinearOpMode {

    private DcMotorEx extendoLeft;
    private DcMotorEx extendoRight;

    // Adjust these increments as needed
    private static final int TICK_INCREMENT = 50;      // Normal increment/decrement
    private static final int FINE_TICK_INCREMENT = 5;  // Fine increment/decrement

    private int targetPosition = 0;
    private double motorPower = 0.5; // Power for RUN_TO_POSITION moves

    @Override
    public void runOpMode() throws InterruptedException {
        // Initialize the slide motor from the hardware map
        extendoLeft = hardwareMap.get(DcMotorEx.class, "extendoLeft");
        extendoRight = hardwareMap.get(DcMotorEx.class, "extendoRight");

        // Reset encoder and set up RUN_TO_POSITION mode
        extendoLeft.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        extendoRight.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        extendoLeft.setTargetPosition(targetPosition);
        extendoRight.setTargetPosition(targetPosition);
        extendoLeft.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        extendoRight.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        extendoLeft.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        extendoRight.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        extendoLeft.setPower(motorPower);
        extendoRight.setPower(motorPower);

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
            extendoLeft.setTargetPosition(targetPosition);
            extendoRight.setTargetPosition(targetPosition);

            // Update telemetry
            int currentLeftPosition = extendoLeft.getCurrentPosition();
            int currentRightPosition = extendoRight.getCurrentPosition();
            telemetry.addData("Current left Pos", currentLeftPosition);
            telemetry.addData("Current right Pos", currentRightPosition);
            telemetry.addData("Target Pos", targetPosition);
            telemetry.addData("Difference left", targetPosition - currentLeftPosition);
            telemetry.addData("Difference right", targetPosition - currentRightPosition);
            telemetry.addData("Power", motorPower);
            telemetry.update();
        }
    }
}