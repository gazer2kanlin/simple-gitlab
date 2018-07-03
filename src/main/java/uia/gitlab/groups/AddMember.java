package uia.gitlab.groups;

import java.io.IOException;
import java.util.Map;

import uia.gitlab.GitLab;
import uia.gitlab.model.GitCommit;
import uia.gitlab.model.GitMemberRequest;
import uia.utils.http.SimpleHttpClientResponse;

public class AddMember {

    private String groupPath;

    private GitMemberRequest request;

    public AddMember(String groupPath) {
        this.groupPath = groupPath;
        this.request = new GitMemberRequest();
    }

    public GitMemberRequest getRequest() {
        return this.request;
    }

    public void setRequest(GitMemberRequest request) {
        this.request = request;
    }

    public Map<String, Object> accept(GitLab gitLab) throws IOException {
        SimpleHttpClientResponse resp = gitLab.post(
                "/groups/" + gitLab.rePath(this.groupPath) + "/members", this.request);
        return gitLab.json2Map(resp.getContent("utf-8"));
    }

    public GitCommit acceptEx(GitLab gitLab) throws IOException {
        SimpleHttpClientResponse resp = gitLab.post(
                "/groups/" + gitLab.rePath(this.groupPath) + "/members", this.request);
        return gitLab.json2Object(resp.getContent("utf-8"), GitCommit.class);
    }
}
