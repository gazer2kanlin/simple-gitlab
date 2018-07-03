package uia.gitlab.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

/**
 * Gitlab commit information.
 *
 * @author Kyle K. Lin
 *
 */
public class GitCommit {

    @SerializedName(value = "id")
    private String id;

    @SerializedName(value = "short_id")
    private String shortId;

    @SerializedName(value = "title")
    private String title;

    @SerializedName(value = "author_name")
    private String authorName;

    @SerializedName(value = "author_email")
    private String authorEmail;

    @SerializedName(value = "committer_name")
    private String committerName;

    @SerializedName(value = "committer_email")
    private String committerEmail;

    @SerializedName(value = "committed_date")
    private String committedDate;

    @SerializedName(value = "created_at")
    private String createdAt;

    @SerializedName(value = "message")
    private String message;

    @SerializedName(value = "parent_ids")
    private List<String> parentIds;

    public String getId() {
        return this.id;
    }

    public String getShortId() {
        return this.shortId;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthorName() {
        return this.authorName;
    }

    public String getAuthorEmail() {
        return this.authorEmail;
    }

    public String getCommitterName() {
        return this.committerName;
    }

    public String getCommitterEmail() {
        return this.committerEmail;
    }

    public String getCommittedDate() {
        return this.committedDate;
    }

    public String getCreatedAt() {
        return this.createdAt;
    }

    public String getMessage() {
        return this.message;
    }

    public List<String> getParentIds() {
        return this.parentIds;
    }

    @Override
    public String toString() {
        return this.id + ", " + this.committedDate + ", " + this.committerName + ", " + this.message;
    }

}
