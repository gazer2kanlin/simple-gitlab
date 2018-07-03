package uia.gitlab.projects;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gson.reflect.TypeToken;

import uia.gitlab.GitLab;
import uia.gitlab.model.GitRepoTreeNode;
import uia.utils.http.SimpleHttpClientResponse;

public class QueryRepoTree {

    private String projectPath;

    private String branch;

    private boolean recursive;

    private String searchPath;

    public QueryRepoTree(String projectPath) {
        this.projectPath = projectPath;
        this.branch = "master";
        this.recursive = true;
    }

    public QueryRepoTree(String projectPath, String branch, boolean recursive) {
        this.projectPath = projectPath;
        this.branch = branch;
        this.recursive = recursive;
    }

    public String getBranch() {
        return this.branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public boolean isRecursive() {
        return this.recursive;
    }

    public void setRecursive(boolean recursive) {
        this.recursive = recursive;
    }

    public String getSearchPath() {
        return this.searchPath;
    }

    public void setSearchPath(String searchPath) {
        this.searchPath = searchPath;
    }

    public List<Map<String, Object>> accept(GitLab gitLab) throws IOException {
        SimpleHttpClientResponse resp = gitLab.get(toPath(gitLab));
        return gitLab.json2List(resp.getContent("utf-8"));
    }

    public List<GitRepoTreeNode> acceptEx(GitLab gitLab) throws IOException {
        Type type = new TypeToken<List<GitRepoTreeNode>>() {
        }.getType();

        SimpleHttpClientResponse resp = gitLab.get(toPath(gitLab));
        if (resp.getStatusCode() != 200) {
            return new ArrayList<GitRepoTreeNode>();
        }
        String content = resp.getContent("utf-8");
        return gitLab.json2Object(content, type);
    }

    private String toPath(GitLab gitLab) {
        if (this.searchPath == null) {
            return String.format("/projects/%s/repository/tree?ref=%s&recursive=%s",
                    gitLab.rePath(this.projectPath),
                    this.branch,
                    this.recursive);
        }
        else {
            return String.format("/projects/%s/repository/tree?ref=%s&recursive=%s&path=%s",
                    gitLab.rePath(this.projectPath),
                    this.branch,
                    this.recursive,
                    this.searchPath);
        }
    }
}
