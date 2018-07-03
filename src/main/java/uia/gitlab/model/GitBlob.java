package uia.gitlab.model;

import com.google.gson.annotations.SerializedName;

/**
 * Gitlab BLOB information。
 *
 * @author Kyle K. Lin
 *
 */
public class GitBlob {

    @SerializedName(value = "size")
    private long size;

    @SerializedName(value = "encoding")
    private String encoding;

    @SerializedName(value = "content")
    private String content;

    @SerializedName(value = "sha")
    private String blobId;

    public long getSize() {
        return this.size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getEncoding() {
        return this.encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getBlobId() {
        return this.blobId;
    }

    public void setBlobId(String blobId) {
        this.blobId = blobId;
    }
}
