package org.usfirst.frc.team997.robot.subsystems;

import org.usfirst.frc.team997.robot.RobotMap;
import org.usfirst.frc.team997.robot.commands.DummyTankDrive;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Dummydrive extends Subsystem {
	
	private VictorSP leftmotor;
	private VictorSP rightmotor;
	private DigitalInput shootersensor;
	private Counter shootercounter;
	private Servo shooterservo; //AKA the thing that moves when it shoots
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public Dummydrive(int leftport, int rightport) {
		leftmotor = new VictorSP(leftport);
		rightmotor = new VictorSP(rightport);
		shootersensor = new DigitalInput(1);
		shootercounter = new Counter();
		shootercounter.setSamplesToAverage(15);
		shootercounter.setUpSource(0);
		shootercounter.setDistancePerPulse(1);
		
		
		shooterservo = new Servo(RobotMap.ServoPort);
	}
	
	public void dummyvoltage(double leftspeed, double rightspeed) {
		
		leftmotor.set(-leftspeed);
		rightmotor.set(rightspeed);
	}
	
	public void shoot() {
		leftmotor.set(-0.8);
		
		if(shootersensor.get()) {
			shooterservo.set(.8);
		} else {
			shooterservo.set(1);
		}
		
	}
	
	public void gather() {
		if(shootersensor.get()) {
			leftmotor.set(0.0);
		} else {
			leftmotor.set(0.45);
		}
	}
	
	
	public boolean getshootersensor() {
		return shootersensor.get();
	}
	
	public void smartDashboard() {
		//SmartDashboard.putBoolean("shootersensor", shootersensor.get());
		SmartDashboard.putNumber("shooter rate", shootercounter.getRate());
		SmartDashboard.putNumber("average Speed of shooter", shootercounter.getSamplesToAverage());
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new DummyTankDrive());
    }
}

