package uia.gitlab.projects;

import org.junit.Test;

import uia.gitlab.AbstractGitLabTest;
import uia.gitlab.GitLab;
import uia.gitlab.model.GitCommit;

public class QueryOneCommitTest extends AbstractGitLabTest {

    @Test
    public void test1() throws Exception {
        try (GitLab gitLab = createPAT()) {
            print(new QueryOneCommit("devops/coding_style", "686f2e2aea4fba7e2f1faaecd3c2f5c114610ee4")
                    .accept(gitLab));
        }
    }

    @Test
    public void test2() throws Exception {
        try (GitLab gitLab = createPAT()) {
            GitCommit gc = new QueryOneCommit("devops/coding_style", "686f2e2aea4fba7e2f1faaecd3c2f5c114610ee4")
                    .acceptEx(gitLab);
            System.out.println(gc);
        }
    }
}
