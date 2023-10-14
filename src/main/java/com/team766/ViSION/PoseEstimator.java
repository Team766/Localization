package com.team766.ViSION;

import org.photonvision.PhotonCamera;
import org.photonvision.PhotonPoseEstimator;
import org.photonvision.PhotonPoseEstimator.PoseStrategy;
import edu.wpi.first.math.geometry.Transform3d;


public class PoseEstimator {
	public PhotonPoseEstimator pEstimator = new PhotonPoseEstimator(
		SWingFieldTemplate.getFieldLayout(),
		PoseStrategy.MULTI_TAG_PNP,
		(PhotonCamera) Cameras.camera1,
		new Transform3d());

	
}
