package uia.gitlab.projects;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import com.google.gson.reflect.TypeToken;

import uia.gitlab.GitLab;
import uia.gitlab.model.GitMember;
import uia.utils.http.SimpleHttpClientResponse;

public class QueryMembers {

    private String projectPath;

    public QueryMembers(String projectPath) {
        this.projectPath = projectPath;
    }

    public List<Map<String, Object>> accept(GitLab gitLab) throws IOException {
        SimpleHttpClientResponse resp = gitLab.get(
                "/projects/" + gitLab.rePath(this.projectPath) + "/members");
        return gitLab.json2List(resp.getContent("utf-8"));
    }

    public List<GitMember> acceptEx(GitLab gitLab) throws IOException {
        Type type = new TypeToken<List<GitMember>>() {
        }.getType();

        SimpleHttpClientResponse resp = gitLab.get(
                "/projects/" + gitLab.rePath(this.projectPath) + "/members");
        return gitLab.json2Object(resp.getContent("utf-8"), type);
    }
}
