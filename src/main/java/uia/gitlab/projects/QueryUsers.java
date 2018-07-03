package uia.gitlab.projects;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import com.google.gson.reflect.TypeToken;

import uia.gitlab.GitLab;
import uia.gitlab.model.GitUser;
import uia.utils.http.SimpleHttpClientResponse;

public class QueryUsers {

    private String projectPath;

    public QueryUsers(String projectPath) {
        this.projectPath = projectPath;
    }

    public List<Map<String, Object>> accept(GitLab gitLab) throws IOException {
        SimpleHttpClientResponse resp = gitLab.get(
                "/projects/" + gitLab.rePath(this.projectPath) + "/users");
        return gitLab.json2List(resp.getContent("utf-8"));
    }

    public List<GitUser> acceptEx(GitLab gitLab) throws IOException {
        Type type = new TypeToken<List<GitUser>>() {
        }.getType();

        SimpleHttpClientResponse resp = gitLab.get(
                "/projects/" + gitLab.rePath(this.projectPath) + "/users");
        return gitLab.json2Object(resp.getContent("utf-8"), type);
    }
}
