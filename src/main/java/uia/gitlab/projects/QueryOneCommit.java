package uia.gitlab.projects;

import java.io.IOException;
import java.util.Map;

import uia.gitlab.GitLab;
import uia.gitlab.model.GitCommit;
import uia.utils.http.SimpleHttpClientResponse;

public class QueryOneCommit {

    private String projectPath;

    private String sha;

    public QueryOneCommit(String projectPath, String sha) {
        this.projectPath = projectPath;
        this.sha = sha;
    }

    public String getProjectPath() {
        return this.projectPath;
    }

    public void setProjectPath(String projectPath) {
        this.projectPath = projectPath;
    }

    public String getSha() {
        return this.sha;
    }

    public void setSha(String sha) {
        this.sha = sha;
    }

    public Map<String, Object> accept(GitLab gitLab) throws IOException {
        SimpleHttpClientResponse resp = gitLab.get(toPath(gitLab));
        return gitLab.json2Map(resp.getContent("utf-8"));
    }

    public GitCommit acceptEx(GitLab gitLab) throws IOException {
        SimpleHttpClientResponse resp = gitLab.get(toPath(gitLab));
        return gitLab.json2Object(resp.getContent("utf-8"), GitCommit.class);
    }

    private String toPath(GitLab gitLab) {
        return String.format("/projects/%s/repository/commits/%s",
                gitLab.rePath(this.projectPath),
                this.sha);
    }
}
