package uia.gitlab.model;

import java.util.Date;

import com.google.gson.annotations.SerializedName;

/**
 * Gitlab project information.
 *
 * @author Kyle K. Lin
 *
 */
public class GitProject {

    @SerializedName(value = "id")
    private String id;

    @SerializedName(value = "description")
    private String description;

    @SerializedName(value = "default_branch")
    private String defaultBranch;

    @SerializedName(value = "visibility")
    private String visibility;

    @SerializedName(value = "ssh_url_to_repo")
    private String sshUrlToRepo;

    @SerializedName(value = "http_url_to_repo")
    private String httpUrlToRepo;

    @SerializedName(value = "web_url")
    private String webUrl;

    @SerializedName(value = "name")
    private String name;

    @SerializedName(value = "name_with_namespace")
    private String nameWithNamespace;

    @SerializedName(value = "path")
    private String path;

    @SerializedName(value = "path_with_namespace")
    private String pathWithNamespace;

    @SerializedName(value = "created_at")
    private Date createdAt;

    @SerializedName(value = "last_activity_at")
    private Date lastActivityAt;

    public String getId() {
        return this.id;
    }

    public String getDescription() {
        return this.description;
    }

    public String getDefaultBranch() {
        return this.defaultBranch;
    }

    public String getVisibility() {
        return this.visibility;
    }

    public String getSshUrlToRepo() {
        return this.sshUrlToRepo;
    }

    public String getHttpUrlToRepo() {
        return this.httpUrlToRepo;
    }

    public String getWebUrl() {
        return this.webUrl;
    }

    public String getName() {
        return this.name;
    }

    public String getNameWithNamespace() {
        return this.nameWithNamespace;
    }

    public String getPath() {
        return this.path;
    }

    public String getPathWithNamespace() {
        return this.pathWithNamespace;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public Date getLastActivityAt() {
        return this.lastActivityAt;
    }

    @Override
    public String toString() {
        return String.format("%4s: %s", this.id, this.pathWithNamespace);
    }

}
