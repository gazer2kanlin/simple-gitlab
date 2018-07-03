package uia.gitlab.projects;

import java.io.IOException;
import java.util.Map;

import uia.gitlab.GitLab;
import uia.gitlab.model.GitCommit;
import uia.gitlab.model.GitCommitRequest;
import uia.utils.file.FileUtils;
import uia.utils.http.SimpleHttpClientResponse;

public class CreateCommit {

    private final String projectPath;

    private final GitCommitRequest request;

    public CreateCommit(String projectPath) {
        this.projectPath = projectPath;
        this.request = new GitCommitRequest();
    }

    public String getId() {
        return this.request.getId();
    }

    public void setId(String id) {
        this.request.setId(id);
    }

    public String getBranch() {
        return this.request.getBranch();
    }

    public void setBranch(String branch) {
        this.request.setBranch(branch);
    }

    public String getCommitMessage() {
        return this.request.getCommitMessage();
    }

    public void setCommitMessage(String commitMessage) {
        this.request.setCommitMessage(commitMessage);
    }

    public String getStartBranch() {
        return this.request.getStartBranch();
    }

    public void setStartBranch(String startBranch) {
        this.request.setStartBranch(startBranch);
    }

    public String getAuthorEmail() {
        return this.request.getAuthorEmail();
    }

    public void setAuthorEmail(String authorEmail) {
        this.request.setAuthorEmail(authorEmail);
    }

    public String getAuthorName() {
        return this.request.getAuthorName();
    }

    public void setAuthorName(String authorName) {
        this.request.setAuthorName(authorName);
    }

    public CreateCommit createContent(String repoPath, String content, boolean base64) {
        GitCommitRequest.Action action = new GitCommitRequest.Action();
        action.setFilePath(repoPath);
        action.setContent(content);
        action.setEncoding(base64 ? GitCommitRequest.Action.ENCODING_BASE64 : GitCommitRequest.Action.ENCODING_TEXT);
        this.request.getActions().add(action);

        return this;
    }

    public CreateCommit updateContent(String repoPath, String content, boolean base64) {
        GitCommitRequest.Action action = new GitCommitRequest.Action();
        action.setActionType(GitCommitRequest.Action.ACTION_UPDATE);
        action.setFilePath(repoPath);
        action.setContent(content);
        action.setEncoding(base64 ? GitCommitRequest.Action.ENCODING_BASE64 : GitCommitRequest.Action.ENCODING_TEXT);
        this.request.getActions().add(action);

        return this;
    }

    public CreateCommit createTextFile(String repoPath, String localPath) throws IOException {
        GitCommitRequest.Action action = new GitCommitRequest.Action();
        action.setFilePath(repoPath);
        action.setContent(FileUtils.readContent(localPath));
        this.request.getActions().add(action);

        return this;
    }

    public CreateCommit updateTextFile(String repoPath, String localPath) throws IOException {
        GitCommitRequest.Action action = new GitCommitRequest.Action();
        action.setActionType(GitCommitRequest.Action.ACTION_UPDATE);
        action.setFilePath(repoPath);
        action.setContent(FileUtils.readContent(localPath));
        this.request.getActions().add(action);

        return this;
    }

    public CreateCommit deleteFile(String repoPath) throws IOException {
        GitCommitRequest.Action action = new GitCommitRequest.Action();
        action.setActionType(GitCommitRequest.Action.ACTION_DELETE);
        action.setFilePath(repoPath);
        this.request.getActions().add(action);

        return this;
    }

    public CreateCommit moveFile(String repoPath, String fromPath) throws IOException {
        GitCommitRequest.Action action = new GitCommitRequest.Action();
        action.setActionType(GitCommitRequest.Action.ACTION_MOVE);
        action.setFilePath(repoPath);
        action.setPreviousPath(fromPath);
        this.request.getActions().add(action);

        return this;
    }

    public Map<String, Object> accept(GitLab gitLab) throws IOException {
        SimpleHttpClientResponse resp = gitLab.post("/projects/" + gitLab.rePath(this.projectPath) + "/repository/commits", this.request);
        return gitLab.json2Map(resp.getContent("utf-8"));
    }

    public GitCommit acceptEx(GitLab gitLab) throws IOException {
        SimpleHttpClientResponse resp = gitLab.post("/projects/" + gitLab.rePath(this.projectPath) + "/repository/commits", this.request);
        if (resp.getStatusCode() == 201) {
            return gitLab.json2Object(resp.getContent("utf-8"), GitCommit.class);
        }
        else {
            return null;
        }
    }
}
