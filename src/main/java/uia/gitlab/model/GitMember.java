package uia.gitlab.model;

import java.util.Date;

import com.google.gson.annotations.SerializedName;

/**
 * Gitlab member information.
 *
 * @author Kyle K. Lin
 *
 */
public class GitMember {

    @SerializedName(value = "id")
    private String id;

    @SerializedName(value = "username")
    private String userName;

    @SerializedName(value = "name")
    private String aliasName;

    @SerializedName(value = "state")
    private String state;

    @SerializedName(value = "created_at")
    private Date createdAt;

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

    public String getAliasName() {
        return this.aliasName;
    }

    public void setAliasName(String aliasName) {
        this.aliasName = aliasName;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
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
        return this.id + ", " + this.userName + ", " + this.aliasName + ", " + this.state + ", " + this.accessLevel;
    }
}
