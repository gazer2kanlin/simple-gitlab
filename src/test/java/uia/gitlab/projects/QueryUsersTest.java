package uia.gitlab.projects;

import org.junit.Test;

import uia.gitlab.AbstractGitLabTest;
import uia.gitlab.GitLab;

public class QueryUsersTest extends AbstractGitLabTest {

    @Test
    public void test() throws Exception {
        GitLab gitLab = createPAT();
        print(new QueryUsers("htks/web/psb.web")
                .accept(gitLab));
    }

    @Test
    public void testEx() throws Exception {
        try (GitLab gitLab = createPAT()) {
            new QueryUsers("htks/web/psb.web")
                    .acceptEx(gitLab)
                    .forEach(System.out::println);
        }
    }
}
