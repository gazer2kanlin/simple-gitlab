package uia.gitlab.model;

import com.google.gson.annotations.SerializedName;

/**
 * Gitlab group information.
 *
 * @author Kyle K. Lin
 *
 */
public class GitGroup {

    @SerializedName(value = "id")
    private String id;

    @SerializedName(value = "name")
    private String name;

    @SerializedName(value = "path")
    private String path;

    @SerializedName(value = "description")
    private String description;

    @SerializedName(value = "visibility")
    private String visibility;

    @SerializedName(value = "lfs_enabled")
    private String lfsEnabled;

    @SerializedName(value = "request_access_enabled")
    private String requestAccessEnabled;

    @SerializedName(value = "full_name")
    private String fullName;

    @SerializedName(value = "full_path")
    private String fullPath;

    @SerializedName(value = "parent_id")
    private String parentId;

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getPath() {
        return this.path;
    }

    public String getDescription() {
        return this.description;
    }

    public String getVisibility() {
        return this.visibility;
    }

    public String getLfsEnabled() {
        return this.lfsEnabled;
    }

    public String getRequestAccessEnabled() {
        return this.requestAccessEnabled;
    }

    public String getFullName() {
        return this.fullName;
    }

    public String getFullPath() {
        return this.fullPath;
    }

    public String getParentId() {
        return this.parentId;
    }

    @Override
    public String toString() {
        return this.id + ": " + this.fullPath;
    }

}
