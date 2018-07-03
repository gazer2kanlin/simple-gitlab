package uia.gitlab.groups;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import com.google.gson.reflect.TypeToken;

import uia.gitlab.GitLab;
import uia.gitlab.model.GitMember;
import uia.utils.http.SimpleHttpClientResponse;

public class QueryMembers {

    private final String groupPath;

    public QueryMembers(String groupPath) {
        this.groupPath = groupPath;
    }

    public List<Map<String, Object>> accept(GitLab gitLab) throws IOException {
        SimpleHttpClientResponse resp = gitLab.get(
                "/groups/" + gitLab.rePath(this.groupPath) + "/members");
        return gitLab.json2List(resp.getContent("utf-8"));
    }

    public List<GitMember> acceptEx(GitLab gitLab) throws IOException {
        Type type = new TypeToken<List<GitMember>>() {
        }.getType();

        SimpleHttpClientResponse resp = gitLab.get(
                "/groups/" + gitLab.rePath(this.groupPath) + "/members");
        return gitLab.json2Object(resp.getContent("utf-8"), type);
    }
}
