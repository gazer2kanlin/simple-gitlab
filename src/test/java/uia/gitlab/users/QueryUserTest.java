package uia.gitlab.users;

import org.junit.Test;

import uia.gitlab.AbstractGitLabTest;
import uia.gitlab.GitLab;

public class QueryUserTest extends AbstractGitLabTest {

    @Test
    public void test() throws Exception {
        try (GitLab gitLab = createPAT()) {
            new QueryUsers()
                    .accept(gitLab)
                    .forEach(m -> {
                        System.out.println(m.get("username"));
                    });
        }
    }

    @Test
    public void testEx() throws Exception {
        try (GitLab gitLab = createPAT()) {
            new QueryUsers()
                    .acceptEx(gitLab)
                    .forEach(System.out::println);
        }
    }
}
