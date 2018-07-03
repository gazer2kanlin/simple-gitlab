package uia.gitlab.projects;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import com.google.gson.reflect.TypeToken;

import uia.gitlab.GitLab;
import uia.gitlab.model.GitProject;
import uia.utils.http.SimpleHttpClientResponse;

public class QueryProjects {

    public List<Map<String, Object>> accept(GitLab gitLab) throws IOException {
        SimpleHttpClientResponse resp = gitLab.get("/projects");
        return gitLab.json2List(resp.getContent("utf-8"));
    }

    public List<GitProject> acceptEx(GitLab gitLab) throws IOException {
        Type type = new TypeToken<List<GitProject>>() {
        }.getType();

        SimpleHttpClientResponse resp = gitLab.get("/projects");
        return gitLab.json2Object(resp.getContent("utf-8"), type);
    }
}
