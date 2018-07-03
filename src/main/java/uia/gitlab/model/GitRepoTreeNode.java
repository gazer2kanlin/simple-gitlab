package uia.gitlab.model;

import com.google.gson.annotations.SerializedName;

/**
 * Gitlab commit tree detail information.
 *
 * @author Kyle K. Lin
 *
 */
public class GitRepoTreeNode {

    @SerializedName(value = "id")
    private String id;

    @SerializedName(value = "name")
    private String name;

    @SerializedName(value = "type")
    private String type;

    @SerializedName(value = "path")
    private String path;

    @SerializedName(value = "mode")
    private String mode;

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    public String getPath() {
        return this.path;
    }

    public String getMode() {
        return this.mode;
    }

    public boolean isFile() {
        return "blob".equals(this.type);
    }

    @Override
    public String toString() {
        return this.id + ", " + this.type + ", " + this.path;
    }

}
