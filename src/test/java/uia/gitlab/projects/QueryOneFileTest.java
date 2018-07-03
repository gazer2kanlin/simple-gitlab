package uia.gitlab.projects;

import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

import uia.gitlab.AbstractGitLabTest;
import uia.gitlab.GitLab;
import uia.gitlab.model.GitFile;

public class QueryOneFileTest extends AbstractGitLabTest {

    @Test
    public void testPublicEx() throws Exception {
        try (GitLab gitLab = createPAT()) {
            GitFile file = new QueryOneFile("devops/coding_style", "README.md")
                    .acceptEx(gitLab);
            String content = file.getContent();
            System.out.println(new String(Base64.decodeBase64(content.getBytes())));
        }
    }

    @Test
    public void testPrivate() throws Exception {
        try (GitLab gitLab = createPAT()) {
            Map<String, Object> data = new QueryOneFile("gtm/North", "README_TEST_A.txt")
                    .accept(gitLab);
            print(data);
        }
    }

    @Test
    public void testPrivateEx() throws Exception {
        try (GitLab gitLab = createPAT()) {
            GitFile file = new QueryOneFile("gtm/North", "README_TEST_A.txt")
                    .acceptEx(gitLab);
            String content = file.getContent();
            System.out.println("path:           " + file.getFilePath());
            System.out.println("blob:           " + file.getBlobId());
            System.out.println("commit:         " + file.getCommitId());
            System.out.println("project commit: " + file.getProjectCommitId());
            System.out.println("content: ");
            System.out.println(new String(Base64.decodeBase64(content.getBytes())));
        }
    }
}
