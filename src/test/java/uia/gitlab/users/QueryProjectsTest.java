package uia.gitlab.users;

import org.junit.Test;

import uia.gitlab.AbstractGitLabTest;
import uia.gitlab.GitLab;

public class QueryProjectsTest extends AbstractGitLabTest {

    @Test
    public void test() throws Exception {
        try (GitLab gitLab = createPAT()) {
            new QueryProjects("2")
                    .accept(gitLab)
                    .forEach(m -> {
                        System.out.println(m.get("name"));
                    });
        }
    }

    @Test
    public void testEx() throws Exception {
        try (GitLab gitLab = createPAT()) {
            new QueryProjects("2")
                    .acceptEx(gitLab)
                    .forEach(System.out::println);
        }
    }
}
