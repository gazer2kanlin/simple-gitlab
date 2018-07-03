package uia.gitlab.model;

import com.google.gson.annotations.SerializedName;

/**
 * Gitlab user information.
 *
 * @author Kyle K. Lin
 *
 */
public class GitUser {

    @SerializedName(value = "id")
    private String id;

    @SerializedName(value = "username")
    private String userName;

    @SerializedName(value = "name")
    private String aliasName;

    @SerializedName(value = "state")
    private String state;

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

    @Override
    public String toString() {
        return this.id + ", " + this.userName + ", " + this.aliasName + ", " + this.state;
    }
}
