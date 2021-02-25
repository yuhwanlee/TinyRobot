package org.exponential.mechanisms;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Servo;

import org.exponential.superclasses.Mechanism;

import java.util.HashMap;

public class Drivetrain implements Mechanism {
    LinearOpMode opMode;

    CRServo frontLeft;
    CRServo frontRight;
    CRServo backLeft;
    CRServo backRight;

    @Override
    public void initialize(LinearOpMode opMode) {
        this.opMode = opMode;
        frontLeft = opMode.hardwareMap.crservo.get("frontLeft");
        frontRight = opMode.hardwareMap.crservo.get("frontRight");
        backLeft = opMode.hardwareMap.crservo.get("backLeft");
        backRight = opMode.hardwareMap.crservo.get("backRight");

    }

    public void setPowerDriveMotors(HashMap<String, Double> powers) {
        frontLeft.setPower(-powers.get("frontLeft"));
        backLeft.setPower(-powers.get("backLeft"));
        frontRight.setPower(powers.get("frontRight"));
        backRight.setPower(powers.get("backRight"));
    }
}
