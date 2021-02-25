package org.exponential.mechanisms;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;

import org.exponential.superclasses.Mechanism;

import java.util.HashMap;

public class Drivetrain implements Mechanism {
    LinearOpMode opMode;

    Servo frontLeft;
    Servo frontRight;
    Servo backLeft;
    Servo backRight;

    @Override
    public void initialize(LinearOpMode opMode) {
        this.opMode = opMode;
        frontLeft = opMode.hardwareMap.servo.get("frontLeft");
        frontRight = opMode.hardwareMap.servo.get("frontRight");
        backLeft = opMode.hardwareMap.servo.get("backLeft");
        backRight = opMode.hardwareMap.servo.get("backRight");
    }

    public void setPowerDriveMotors(HashMap<String, Double> powers) {
        frontLeft.setPosition(powers.get("frontLeft"));
        backLeft.setPosition(powers.get("backLeft"));
        frontRight.setPosition(powers.get("frontRight"));
        backRight.setPosition(powers.get("backRight"));
    }
}
