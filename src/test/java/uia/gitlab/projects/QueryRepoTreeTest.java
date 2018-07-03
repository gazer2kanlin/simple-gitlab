package uia.gitlab.projects;

import org.junit.Test;

import uia.gitlab.AbstractGitLabTest;
import uia.gitlab.GitLab;

public class QueryRepoTreeTest extends AbstractGitLabTest {

    @Test
    public void test() throws Exception {
        GitLab gitLab = createPAT();
        print(new QueryRepoTree("gtm/north")
                .accept(gitLab));
    }

    @Test
    public void testEx() throws Exception {
        try (GitLab gitLab = createPAT()) {
            new QueryRepoTree("gtm/north", "master", false)
                    .acceptEx(gitLab)
                    .forEach(System.out::println);
        }
    }
}
