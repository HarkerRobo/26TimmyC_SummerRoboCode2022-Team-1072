package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import harkerrobolib.wrappers.HSTalon;

public class Drivetrain extends SubsystemBase {
    private static Drivetrain instance;

    private HSTalon rightMaster;
    private HSTalon leftMaster;
    private VictorSPX rightFollower;
    private VictorSPX leftFollower;

    private static final int RIGHT_M_ID = 0;
    private static final int LEFT_M_ID = 0;
    private static final int RIGHT_F_ID = 0;
    private static final int LEFT_F_ID = 0;

    private static final boolean rightMasterInvert = false;
    private static final boolean leftMasterInvert = false;
    private static final boolean rightFollowerInvert = false;
    private static final boolean leftFollowerInvert = false;

    public Drivetrain() {
        rightMaster = new HSTalon(RIGHT_M_ID);
        leftMaster = new HSTalon(LEFT_M_ID);
        rightFollower = new VictorSPX(RIGHT_F_ID);
        leftFollower = new VictorSPX(LEFT_F_ID);

        rightMaster.setInverted(rightMasterInvert);
        leftMaster.setInverted(leftMasterInvert);
        rightFollower.setInverted(rightFollowerInvert);
        leftFollower.setInverted(leftFollowerInvert);

        rightFollower.follow(rightMaster);
        leftFollower.follow(leftMaster);
    }

    public void setArcadeDrive(double turn, double speed) {
        rightMaster.set(ControlMode.PercentOutput, speed - turn);
        leftMaster.set(ControlMode.PercentOutput, speed + turn);
    }

    public static Drivetrain getInstance() {
        if (instance == null) {
            instance = new Drivetrain();
        }

        return instance;
    }
}