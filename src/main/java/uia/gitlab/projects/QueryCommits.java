package uia.gitlab.projects;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import com.google.gson.reflect.TypeToken;

import uia.gitlab.GitLab;
import uia.gitlab.model.GitCommit;
import uia.utils.http.SimpleHttpClientResponse;

/**
 * Query commits of specific branch. Default branch is 'master'.
 * @author Kyle K. Lin
 *
 */
public class QueryCommits {

    private String projectPath;

    private String branch;

    private String path;

    public QueryCommits(String projectPath) {
        this.branch = "master";
        this.projectPath = projectPath;
    }

    public QueryCommits(String projectPath, String path) {
        this.branch = "master";
        this.projectPath = projectPath;
        this.path = path;
    }

    public QueryCommits(String projectPath, String path, String branch) {
        this.branch = branch;
        this.projectPath = projectPath;
        this.path = path;
    }

    public String getBranch() {
        return this.branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<Map<String, Object>> accept(GitLab gitLab) throws IOException {
        SimpleHttpClientResponse resp = gitLab.get(toPath(gitLab));
        return gitLab.json2List(resp.getContent("utf-8"));
    }

    public List<GitCommit> acceptEx(GitLab gitLab) throws IOException {
        Type type = new TypeToken<List<GitCommit>>() {
        }.getType();

        SimpleHttpClientResponse resp = gitLab.get(toPath(gitLab));
        return gitLab.json2Object(resp.getContent("utf-8"), type);
    }

    private String toPath(GitLab gitLab) {
        if (this.path == null) {
            return String.format("/projects/%s/repository/commits?ref_name=%s",
                    gitLab.rePath(this.projectPath),
                    this.branch);
        }
        else {
            return String.format("/projects/%s/repository/commits?ref_name=%s&path=%s",
                    gitLab.rePath(this.projectPath),
                    this.branch,
                    this.path);
        }
    }
}
