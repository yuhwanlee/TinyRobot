package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.exponential.robots.TinyRobot;

import java.util.HashMap;
import java.util.Map;

@TeleOp(group="TeleOp", name="BasicTeleOp")
public class BasicTeleOp extends LinearOpMode {
    TinyRobot tinyRobot;

    @Override
    public void runOpMode() throws InterruptedException {
        tinyRobot = new TinyRobot();
        tinyRobot.initialize(this);
        while (opModeIsActive()) {
            double leftStickX = gamepad1.left_stick_x;
            double leftStickY = -gamepad1.left_stick_y;
            double rightStickX = gamepad1.right_stick_x;
            double rightStickY = -gamepad1.right_stick_y;

            tinyRobot.drivetrain.setPowerDriveMotors(getMotorPowers(leftStickX, leftStickY, gamepad1.right_stick_x));
        }
    }

    public HashMap<String, Double> getMotorPowers(double x, double y, double rotate) {
        HashMap<String, Double> powers = new HashMap<>();
        powers.put("frontLeft", -x + y + rotate);
        powers.put("backLeft", x + y + rotate);
        powers.put("frontRight", x + y - rotate);
        powers.put("backRight", -x + y - rotate);

        double maxPower = Math.max(Math.max(Math.max(Math.abs(powers.get("frontLeft")),
                Math.abs(powers.get("backLeft"))), Math.abs(powers.get("frontRight"))), Math.abs(powers.get("backRight")));
        if (maxPower > 1) {
            for (Map.Entry<String, Double> mapElement : powers.entrySet()) {
                powers.put(mapElement.getKey(), mapElement.getValue() / maxPower);
            }
        }
        return powers;
    }
}
