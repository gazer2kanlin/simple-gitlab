package uia.gitlab.projects;

import java.io.IOException;
import java.util.Map;

import uia.gitlab.GitLab;
import uia.gitlab.model.GitBlob;
import uia.utils.http.SimpleHttpClientResponse;

public class QueryBlob {

    private String projectPath;

    private String blobId;

    public QueryBlob(String projectPath, String blobId) {
        this.projectPath = projectPath;
        this.blobId = blobId;
    }

    public Map<String, Object> accept(GitLab gitLab) throws IOException {
        SimpleHttpClientResponse resp = gitLab.get(
                "/projects/" + gitLab.rePath(this.projectPath) + "/repository/blobs/" + this.blobId);
        if (resp.getStatusCode() == 404) {
            return null;
        }
        return gitLab.json2Map(resp.getContent("utf-8"));
    }

    public GitBlob acceptEx(GitLab gitLab) throws IOException {
        SimpleHttpClientResponse resp = gitLab.get(
                "/projects/" + gitLab.rePath(this.projectPath) + "/repository/blobs/" + this.blobId);
        if (resp.getStatusCode() != 200) {
            return null;
        }
        return gitLab.json2Object(resp.getContent("utf-8"), GitBlob.class);
    }
}
