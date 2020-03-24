package com.juteproduct.response;

public class DocumentResponseFromS3 {
private String owner;
private String key;
private String etag;
private String url;
private String lastModifiedDate;
public String getOwner() {
	return owner;
}
public void setOwner(String owner) {
	this.owner = owner;
}
public String getKey() {
	return key;
}
public void setKey(String key) {
	this.key = key;
}
public String getEtag() {
	return etag;
}
public void setEtag(String etag) {
	this.etag = etag;
}
public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}
public String getLastModifiedDate() {
	return lastModifiedDate;
}
public void setLastModifiedDate(String lastModifiedDate) {
	this.lastModifiedDate = lastModifiedDate;
}

}
