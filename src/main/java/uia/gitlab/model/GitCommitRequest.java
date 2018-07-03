package uia.gitlab.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.google.gson.annotations.SerializedName;

/**
 * Gitlab commit request。
 *
 * @author Kyle K. Lin
 *
 */
public class GitCommitRequest {

    @SerializedName(value = "id")
    private String id;

    @SerializedName(value = "branch")
    private String branch;

    @SerializedName(value = "commit_message")
    private String commitMessage;

    @SerializedName(value = "start_branch")
    private String startBranch;

    @SerializedName(value = "author_email")
    private String authorEmail;

    @SerializedName(value = "actions")
    private List<Action> actions;

    @SerializedName(value = "author_name")
    private String authorName;

    public GitCommitRequest() {
        this.id = UUID.randomUUID().toString();
        this.branch = "master";
        this.actions = new ArrayList<Action>();
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBranch() {
        return this.branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getCommitMessage() {
        return this.commitMessage;
    }

    public void setCommitMessage(String commitMessage) {
        this.commitMessage = commitMessage;
    }

    public String getStartBranch() {
        return this.startBranch;
    }

    public void setStartBranch(String startBranch) {
        this.startBranch = startBranch;
    }

    public String getAuthorEmail() {
        return this.authorEmail;
    }

    public void setAuthorEmail(String authorEmail) {
        this.authorEmail = authorEmail;
    }

    public List<Action> getActions() {
        return this.actions;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }

    public String getAuthorName() {
        return this.authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public static class Action {

        public static final String ACTION_CREATE = "create";

        public static final String ACTION_UPDATE = "update";

        public static final String ACTION_MOVE = "move";

        public static final String ACTION_DELETE = "delete";

        public static final String ENCODING_TEXT = "text";

        public static final String ENCODING_BASE64 = "base64";

        @SerializedName(value = "action")
        private String actionType;

        @SerializedName(value = "file_path")
        private String filePath;

        @SerializedName(value = "previous_path")
        private String previousPath;

        @SerializedName(value = "content")
        private String content;

        @SerializedName(value = "encoding")
        private String encoding;

        @SerializedName(value = "last_commit_id")
        private String lastCommitId;

        public Action() {
            this.actionType = ACTION_CREATE;
            this.encoding = ENCODING_TEXT;
        }

        public String getActionType() {
            return this.actionType;
        }

        public void setActionType(String actionType) {
            this.actionType = actionType;
        }

        public String getFilePath() {
            return this.filePath;
        }

        public void setFilePath(String filePath) {
            this.filePath = filePath;
        }

        public String getPreviousPath() {
            return this.previousPath;
        }

        public void setPreviousPath(String previousPath) {
            this.previousPath = previousPath;
        }

        public String getContent() {
            return this.content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getEncoding() {
            return this.encoding;
        }

        public void setEncoding(String encoding) {
            this.encoding = encoding;
        }

        public String getLastCommitId() {
            return this.lastCommitId;
        }

        public void setLastCommitId(String lastCommitId) {
            this.lastCommitId = lastCommitId;
        }
    }
}
