package com.team766.ViSION;

import edu.wpi.first.apriltag.AprilTag;
import edu.wpi.first.apriltag.AprilTagFieldLayout;
import edu.wpi.first.math.geometry.Pose3d;
import edu.wpi.first.math.geometry.Rotation3d;
import java.util.*;

public class SWingFieldTemplate {
	
	private static final double fieldLength = 0.0; //find correct values
	private static final double fieldWidth = 0.0; //find correct values
	
	
	private static final int tag1ID = 2;
	private static final int tag2ID = 3;

	private Rotation3d tag1Rotation = new Rotation3d(0,0,0); //find correct values
	private Rotation3d tag2Rotation = new Rotation3d(0,0,0); //find correct values

	private Pose3d 	tag1Pose = new Pose3d(0,0,0,tag1Rotation); //find correct values later
	private Pose3d 	tag2Pose = new Pose3d(0,0,0,tag2Rotation); //find correct values later

	private ArrayList<AprilTag> tagList = new ArrayList<AprilTag>();
	public AprilTagFieldLayout SWingField;
	
	public SWingFieldTemplate(){ 
		tagList.add(new AprilTag(tag1ID, tag1Pose));
		tagList.add(new AprilTag(tag2ID, tag2Pose));

		SWingField = new AprilTagFieldLayout(null, fieldLength, fieldWidth);
	}

	public AprilTagFieldLayout getFieldLayout(){
		return SWingField;
	}

}
