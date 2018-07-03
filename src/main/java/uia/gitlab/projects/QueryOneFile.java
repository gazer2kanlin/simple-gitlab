package uia.gitlab.projects;

import java.io.IOException;
import java.util.Map;

import uia.gitlab.GitLab;
import uia.gitlab.model.GitFile;
import uia.utils.http.SimpleHttpClientResponse;

public class QueryOneFile {

    private String projectPath;

    private String filePath;

    private String ref;

    public QueryOneFile(String projectPath, String filePath) {
        this.projectPath = projectPath;
        this.filePath = filePath;
        this.ref = "master";
    }

    public QueryOneFile(String projectPath, String filePath, String ref) {
        this.projectPath = projectPath;
        this.filePath = filePath;
        this.ref = ref;
    }

    /**
     * Get name of branch, tag or commit
     * @return The name of branch, tag or commit.
     */
    public String getRef() {
        return this.ref;
    }

    /**
     * Setup name of branch, tag or commit
     * @param ref The name of branch, tag or commit.
     */
    public void setRef(String ref) {
        this.ref = ref;
    }

    public Map<String, Object> accept(GitLab gitLab) throws IOException {
        SimpleHttpClientResponse resp = gitLab.get("/projects/" + gitLab.rePath(this.projectPath) + "/repository/files/" + gitLab.rePath(this.filePath) + "?ref=" + this.ref);
        if (resp.getStatusCode() != 200) {
            return null;
        }
        return gitLab.json2Map(resp.getContent("utf-8"));
    }

    public GitFile acceptEx(GitLab gitLab) throws IOException {
        SimpleHttpClientResponse resp = gitLab.get("/projects/" + gitLab.rePath(this.projectPath) + "/repository/files/" + gitLab.rePath(this.filePath) + "?ref=" + this.ref);
        if (resp.getStatusCode() != 200) {
            return null;
        }
        return gitLab.json2Object(resp.getContent("utf-8"), GitFile.class);
    }
}
