package com.team766.ViSION;

import java.util.Optional;
import org.photonvision.EstimatedRobotPose;
import org.photonvision.PhotonCamera;
import org.photonvision.PhotonPoseEstimator;
import org.photonvision.PhotonPoseEstimator.PoseStrategy;
import edu.wpi.first.math.geometry.Transform3d;


public class PoseEstimator {
	tonightField TonightField = new tonightField();

	public PhotonPoseEstimator pEstimatorCam1 = new PhotonPoseEstimator(TonightField.getFieldLayout(),
		PoseStrategy.LOWEST_AMBIGUITY,
		(PhotonCamera) Cameras.camera1,
		new Transform3d());

	public PhotonPoseEstimator pEstimatorCam2 = new PhotonPoseEstimator(TonightField.getFieldLayout(), 
		PoseStrategy.LOWEST_AMBIGUITY, 
		(PhotonCamera) Cameras.camera2, 
		new Transform3d());

	public PhotonPoseEstimator pEstimatorCam3 = new PhotonPoseEstimator(TonightField.getFieldLayout(),
		PoseStrategy.LOWEST_AMBIGUITY, 
		(PhotonCamera) Cameras.camera3, 
		new Transform3d());

	
	public PhotonPoseEstimator combined1And2 = new PhotonPoseEstimator(TonightField.getFieldLayout(),
		PoseStrategy.CLOSEST_TO_REFERENCE_POSE, 
		(PhotonCamera) Cameras.camera1, 
		new Transform3d());

	
	public PoseEstimator(){
		
	}

	public Optional<EstimatedRobotPose> getCombinedPose(){
		combined1And2.setReferencePose(pEstimatorCam2.getReferencePose());
		return combined1And2.update();
	}

	public Optional<EstimatedRobotPose> getEstimatedGlobalPose() {
		return pEstimatorCam1.update();
	}

}
