package com.team766.ViSION;

import java.util.Optional;
import org.photonvision.EstimatedRobotPose;
import org.photonvision.PhotonCamera;
import org.photonvision.PhotonPoseEstimator;
import org.photonvision.PhotonPoseEstimator.PoseStrategy;
import edu.wpi.first.math.geometry.Transform3d;


public class PoseEstimator {
	public static PhotonPoseEstimator pEstimatorCam1 = new PhotonPoseEstimator(
		SWingFieldTemplate.getFieldLayout(),
		PoseStrategy.LOWEST_AMBIGUITY,
		(PhotonCamera) Cameras.camera1,
		new Transform3d());

	public PhotonPoseEstimator pEstimatorCam2 = new PhotonPoseEstimator(SWingFieldTemplate.getFieldLayout(), 
		PoseStrategy.LOWEST_AMBIGUITY, 
		(PhotonCamera) Cameras.camera2, 
		new Transform3d());

	public PhotonPoseEstimator pEstimatorCam3 = new PhotonPoseEstimator(SWingFieldTemplate.getFieldLayout(),
		PoseStrategy.LOWEST_AMBIGUITY, 
		(PhotonCamera) Cameras.camera3, 
		new Transform3d());

	// ie. run loop
	

	public static Optional<EstimatedRobotPose> getEstimatedGlobalPose() {
		return pEstimatorCam1.update();
	}

}
