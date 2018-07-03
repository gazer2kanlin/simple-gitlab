package uia.gitlab.model;

import com.google.gson.annotations.SerializedName;

/**
 * Gitlab file information.
 *
 * @author Kyle K. Lin
 *
 */
public class GitFile {

    @SerializedName(value = "file_name")
    private String fileName;

    @SerializedName(value = "file_path")
    private String filePath;

    @SerializedName(value = "size")
    private long size;

    @SerializedName(value = "encoding")
    private String encoding;

    @SerializedName(value = "content")
    private String content;

    @SerializedName(value = "blob_id")
    private String blobId;

    /**
     * gitlab api: "last_commit_id" is last commit of this file.
     */
    @SerializedName(value = "last_commit_id")
    private String commitId;

    /**
     * gitlab api: "commit_id" is last commit of this project/repository.
     */
    @SerializedName(value = "commit_id")
    private String projectCommitId;

    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

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

    public String getProjectCommitId() {
        return this.projectCommitId;
    }

    public void setProjectCommitId(String projectCommitId) {
        this.projectCommitId = projectCommitId;
    }

    public String getCommitId() {
        return this.commitId;
    }

    public void setCommitId(String commitId) {
        this.commitId = commitId;
    }

}
