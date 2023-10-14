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

	private static Rotation3d tag1Rotation = new Rotation3d(0,0,0); //find correct values
	private static Rotation3d tag2Rotation = new Rotation3d(0,0,0); //find correct values

	private static Pose3d tag1Pose = new Pose3d(0,0,0,  tag1Rotation); //find correct values later
	private static Pose3d tag2Pose = new Pose3d(0,0,0, tag2Rotation); //find correct values later

	private static ArrayList<AprilTag> tagList = new ArrayList<AprilTag>();
	public static AprilTagFieldLayout SWingField;

	private static boolean added = false;
	
	public SWingFieldTemplate(){ 

	}

	public static AprilTagFieldLayout getFieldLayout(){

		if(!added){
			tagList.add(new AprilTag(tag1ID, tag1Pose));
			tagList.add(new AprilTag(tag2ID, tag2Pose));

			SWingField = new AprilTagFieldLayout(null, fieldLength, fieldWidth);

			added = true;
		}
		
		return SWingField;
	}

}
