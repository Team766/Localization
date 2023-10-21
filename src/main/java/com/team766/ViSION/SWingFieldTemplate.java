package com.team766.ViSION;

import edu.wpi.first.apriltag.AprilTag;
import edu.wpi.first.apriltag.AprilTagFieldLayout;
import edu.wpi.first.math.geometry.Pose3d;
import edu.wpi.first.math.geometry.Rotation3d;
import java.util.*;

public class SWingFieldTemplate {
	
	private static final double fieldLength = 5.842; 
	private static final double fieldWidth = 5.7277; 
	
	
	private static final int tag1ID = 2;
	private static final int tag2ID = 3;

	private Rotation3d tag1Rotation = new Rotation3d(0,0,90);
	private Rotation3d tag2Rotation = new Rotation3d(0,0,-90); 

	private Pose3d tag1Pose = new Pose3d(2.86385,0,0.49,  tag1Rotation); //find correct values later
	private Pose3d tag2Pose = new Pose3d(2.86385,5.842,0.49, tag2Rotation); //find correct values later

	private List<AprilTag> tagList = new ArrayList<AprilTag>();
	public AprilTagFieldLayout SWingField;

	private boolean added = false;
	
	public SWingFieldTemplate(){
		if(!added){
			tagList.add(new AprilTag(tag1ID, tag1Pose));
			tagList.add(new AprilTag(tag2ID, tag2Pose));

			
			SWingField = new AprilTagFieldLayout(tagList, fieldLength, fieldWidth);

			added = true;
		}
	}

	public AprilTagFieldLayout getFieldLayout(){
		return SWingField;
	}

}
