package uia.gitlab.groups;

import org.junit.Test;

import uia.gitlab.AbstractGitLabTest;
import uia.gitlab.GitLab;

public class QueryProjectsTest extends AbstractGitLabTest {

    @Test
    public void test() throws Exception {
        try (GitLab gitLab = createPAT()) {
            new QueryProjects("htks/client")
                    .accept(gitLab)
                    .forEach(m -> {
                        System.out.println(m.get("name"));
                    });
        }
    }

    @Test
    public void testEx() throws Exception {
        try (GitLab gitLab = createPAT()) {
            new QueryProjects("htks")
                    .acceptEx(gitLab)
                    .forEach(System.out::println);
        }
    }
}
