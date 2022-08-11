package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import harkerrobolib.wrappers.HSTalon;

public class Wrist extends SubsystemBase {
    private static Wrist instance;

    private HSTalon master;
    private VictorSPX follower;

    private static final int M_ID = 0;
    private static final int F_ID = 0;

    private static final boolean masterInvert = false;
    private static final boolean followerInvert = false;

    public Wrist() {
        master = new HSTalon(M_ID);
        follower = new VictorSPX(F_ID);

        master.setInverted(masterInvert);
        follower.setInverted(followerInvert);

        follower.follow(master);
    }

    public void setOutput(double output) {
        master.set(ControlMode.PercentOutput, output);
    }

    public static Wrist getInstance() {
        if (instance == null) {
            instance = new Wrist();
        }

        return instance;
    }
}
