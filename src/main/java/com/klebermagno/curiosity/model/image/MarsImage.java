/* Generated by JavaFromJSON */
/*http://javafromjson.dashingrocket.com*/

package com.klebermagno.curiosity.model.image;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MarsImage {
	@JsonProperty("photos")
	private PhotoElement[] photos;

 	public void setPhotos(PhotoElement[] photos) {
		this.photos = photos;
	}

	public PhotoElement[] getPhotos() {
		return photos;
	}

}