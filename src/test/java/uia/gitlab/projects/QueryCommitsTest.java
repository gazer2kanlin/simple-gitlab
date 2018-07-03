package uia.gitlab.projects;

import org.junit.Test;

import uia.gitlab.AbstractGitLabTest;
import uia.gitlab.GitLab;

public class QueryCommitsTest extends AbstractGitLabTest {

    @Test
    public void test() throws Exception {
        try (GitLab gitLab = createPAT()) {
            print(new QueryCommits("devops/coding_style")
                    .acceptEx(gitLab));
        }
    }

    @Test
    public void testEx1() throws Exception {
        try (GitLab gitLab = createPAT()) {
            new QueryCommits("devops/coding_style")
                    .acceptEx(gitLab)
                    .forEach(System.out::println);
        }
    }

    @Test
    public void testEx2() throws Exception {
        QueryCommits qc = new QueryCommits("gtm/North");
        qc.setPath("README_TEST_A.txt");
        try (GitLab gitLab = createPAT()) {
            qc.acceptEx(gitLab).forEach(System.out::println);
        }
    }
}
