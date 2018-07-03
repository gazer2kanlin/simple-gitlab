package uia.gitlab.projects;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

import uia.gitlab.AbstractGitLabTest;
import uia.gitlab.GitLab;
import uia.gitlab.model.GitBlob;

public class QueryBlobTest extends AbstractGitLabTest {

    @Test
    public void test() throws Exception {
        try (GitLab gitLab = createPAT()) {
            print(new QueryBlob("devops/coding_style", "eee4a6deb85f57f67ef70b6002ea33f6efe9bada")
                    .accept(gitLab));
        }
    }

    @Test
    public void testEx() throws Exception {
        try (GitLab gitLab = createPAT()) {
            GitBlob blob = new QueryBlob("gtm/north", "8e2d9baced20d05c6376b8370225e711a47a1b4e")
                    .acceptEx(gitLab);
            String content = blob.getContent();
            System.out.println(new String(Base64.decodeBase64(content.getBytes())));
        }
    }

}
