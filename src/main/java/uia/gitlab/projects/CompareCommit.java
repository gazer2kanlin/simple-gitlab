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
public class CompareCommit {

    private String projectPath;

    private String from;

    private String to;

    public CompareCommit(String projectPath, String from, String to) {
        this.projectPath = projectPath;
        this.from = from;
        this.to = to;
    }

    public String getProjectPath() {
        return this.projectPath;
    }

    public void setProjectPath(String projectPath) {
        this.projectPath = projectPath;
    }

    public String getFrom() {
        return this.from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return this.to;
    }

    public void setTo(String to) {
        this.to = to;
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
        return String.format("/projects/%s/repository/compare?from=%s&to=%s",
                gitLab.rePath(this.projectPath),
                this.from,
                this.to);
    }
}
