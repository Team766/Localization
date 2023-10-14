package com.team766.ViSION;

import java.util.Optional;
import org.photonvision.EstimatedRobotPose;
import org.photonvision.PhotonCamera;
import org.photonvision.PhotonPoseEstimator;
import org.photonvision.PhotonPoseEstimator.PoseStrategy;
import edu.wpi.first.math.geometry.Transform3d;


public class PoseEstimator {
	SWingFieldTemplate sWingFieldTemplate = new SWingFieldTemplate();
	
	public PhotonPoseEstimator pEstimatorCam1 = new PhotonPoseEstimator(
		sWingFieldTemplate.getFieldLayout(),
		PoseStrategy.LOWEST_AMBIGUITY,
		(PhotonCamera) Cameras.camera1,
		new Transform3d());

	public PhotonPoseEstimator pEstimatorCam2 = new PhotonPoseEstimator(sWingFieldTemplate.getFieldLayout(), 
		PoseStrategy.LOWEST_AMBIGUITY, 
		(PhotonCamera) Cameras.camera2, 
		new Transform3d());

	public PhotonPoseEstimator pEstimatorCam3 = new PhotonPoseEstimator(sWingFieldTemplate.getFieldLayout(),
		PoseStrategy.LOWEST_AMBIGUITY, 
		(PhotonCamera) Cameras.camera3, 
		new Transform3d());

	// ie. run loop
	public PoseEstimator(){

	}

	public Optional<EstimatedRobotPose> getEstimatedGlobalPose() {
		return pEstimatorCam1.update();
	}

}
