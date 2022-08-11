package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import harkerrobolib.wrappers.HSTalon;

public class Elevator extends SubsystemBase{
    private static Elevator instance;

    private HSTalon master;
    private HSTalon masterFollower1;
    private VictorSPX masterFollower2;
    private VictorSPX followerFollower;

    private static final int M_ID = 0;
    private static final int MF1_ID = 0;
    private static final int MF2_ID = 0;
    private static final int FF_ID = 0;

    private static final boolean masterInvert = false;
    private static final boolean masterFollower1Invert = false;
    private static final boolean masterFollower2Invert = false;
    private static final boolean followerFollowerInvert = false;

    public Elevator() {
        master = new HSTalon(M_ID);
        masterFollower1 = new HSTalon(MF1_ID);
        masterFollower2 = new VictorSPX(MF2_ID);
        followerFollower = new VictorSPX(FF_ID);

        master.setInverted(masterInvert);
        masterFollower1.setInverted(masterFollower1Invert);
        masterFollower2.setInverted(masterFollower2Invert);
        followerFollower.setInverted(followerFollowerInvert);

        masterFollower1.follow(master);
        masterFollower2.follow(master);
        followerFollower.follow(masterFollower1);
    }

    public void setOutput(double output) {
        master.set(ControlMode.PercentOutput, output);
    }

    public static Elevator getInstance() {
        if (instance == null) {
            instance = new Elevator();
        }

        return instance;
    }
}
