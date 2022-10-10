package com.cb.tracker.models;

import java.io.Serializable;



public class AccountSnapshotId implements Serializable {
	
	String analystId;
	
	
	String asset;
	public AccountSnapshotId() {
		// TODO Auto-generated constructor stub
	}
	
	public AccountSnapshotId(String analystId, String asset) {
		// TODO Auto-generated constructor stub
		this.analystId = analystId;
        this.asset = asset;
	}

}
