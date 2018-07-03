package uia.gitlab.projects;

import org.junit.Test;

import uia.gitlab.AbstractGitLabTest;
import uia.gitlab.GitLab;

public class CreateCommitTest extends AbstractGitLabTest {

    @Test
    public void test() throws Exception {
        try (GitLab gitLab = createPAT()) {
            CreateCommit cc = new CreateCommit("gtm/North")
                    .createTextFile("/README.md", "d:/temp/README.md");

            cc.setAuthorEmail("gazer.kanlin@gmail.com");
            cc.setAuthorName("gazer2kanlin");
            cc.setCommitMessage("initial");

            cc.accept(gitLab);
        }
    }

    @Test
    public void testEx() throws Exception {
        try (GitLab gitLab = createPAT()) {
            CreateCommit cc = new CreateCommit("gtm/North")
                    .createTextFile("/README.md", "d:/temp/README.md");

            cc.setAuthorEmail("gazer.kanlin@gmail.com");
            cc.setAuthorName("gazer2kanlin");
            cc.setCommitMessage("initial");

            System.out.println(cc.acceptEx(gitLab));
        }
    }

    @Test
    public void testEx2() throws Exception {
        try (GitLab gitLab = createPAT()) {
            CreateCommit cc = new CreateCommit("gtm/North")
                    .updateTextFile("/README.md", "d:/temp/README.md")
                    .createTextFile("/v2/README2.md", "d:/temp/README_V1.md");

            cc.setAuthorEmail("gazer.kanlin@gmail.com");
            cc.setAuthorName("gazer2kanlin");
            cc.setCommitMessage("update README");

            System.out.println(cc.acceptEx(gitLab));
        }
    }

    @Test
    public void testEx3s() throws Exception {
        try (GitLab gitLab = createPAT()) {
            CreateCommit cc = new CreateCommit("gtm/North")
                    .createContent("/v4/README1.md", "d:/temp/README.md", false)
                    .createContent("/v4/README2.md", "d:/temp/README_V1.md", false)
                    .createContent("/v4/README3.md", "d:/temp/README_V1.md", false);

            cc.setAuthorEmail("gazer.kanlin@gmail.com");
            cc.setAuthorName("gazer2kanlin");
            cc.setCommitMessage("update README");

            System.out.println(cc.acceptEx(gitLab));
        }
    }
}
