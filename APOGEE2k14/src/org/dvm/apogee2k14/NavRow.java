package org.dvm.apogee2k14;

//package com.example.apogee2k14;

public class NavRow {
	
	private int imageId;
    private String title;
    
    public NavRow(int imageId, String title) {
        this.setImageId(imageId);
        this.setTitle(title);
    }

	public int getImageId() {
		return imageId;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
