package com.team766.robot.mechanisms;

import com.team766.ViSION.*;
import com.team766.framework.AprilTagGeneralCheckedException;
import com.team766.framework.AprilTagGeneralUncheckedException;
import com.team766.framework.Mechanism;
import edu.wpi.first.math.geometry.Pose3d;
import java.util.Optional;
import org.photonvision.EstimatedRobotPose;

public class Vision extends Mechanism{

	Pose3d latestPose;

	PoseEstimator poseEstimator = new PoseEstimator();
	
	public Vision(){

	}


	public double getX(){
		Optional<EstimatedRobotPose> poseList;
		poseList = poseEstimator.getEstimatedGlobalPose();

		if(poseList.isPresent()){
			EstimatedRobotPose estimatedPose = poseList.get();
			latestPose = estimatedPose.estimatedPose;

			return latestPose.getX();
		} else{
			throw new AprilTagGeneralUncheckedException("No pose available");
		}
	}

	public double getY(){
		Optional<EstimatedRobotPose> poseList;
		poseList = poseEstimator.getEstimatedGlobalPose();

		if(poseList.isPresent()){
			EstimatedRobotPose estimatedPose = poseList.get();
			latestPose = estimatedPose.estimatedPose;

			return latestPose.getY();
		} else{
			throw new AprilTagGeneralUncheckedException("No pose available");
		}
	}


}
