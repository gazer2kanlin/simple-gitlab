package uia.gitlab.model;

import java.util.Date;

import com.google.gson.annotations.SerializedName;

/**
 * Gitlab member request.
 *
 * @author Kyle K. Lin
 *
 */
public class GitMemberRequest {

    @SerializedName(value = "id")
    private String id;

    @SerializedName(value = "user_id")
    private String userName;

    @SerializedName(value = "access_level")
    private String accessLevel;

    @SerializedName(value = "expires_at")
    private Date expiresAt;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAccessLevel() {
        return this.accessLevel;
    }

    public void setAccessLevel(String accessLevel) {
        this.accessLevel = accessLevel;
    }

    public Date getExpiresAt() {
        return this.expiresAt;
    }

    public void setExpiresAt(Date expiresAt) {
        this.expiresAt = expiresAt;
    }

    @Override
    public String toString() {
        return this.id + ", " + this.userName;
    }
}
