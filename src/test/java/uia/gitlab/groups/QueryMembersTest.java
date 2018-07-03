package uia.gitlab.groups;

import org.junit.Test;

import uia.gitlab.AbstractGitLabTest;
import uia.gitlab.GitLab;

public class QueryMembersTest extends AbstractGitLabTest {

    @Test
    public void test() throws Exception {
        try (GitLab gitLab = createPAT()) {
            new QueryMembers("htks/client")
                    .accept(gitLab)
                    .forEach(m -> {
                        System.out.println(m.get("access_level"));
                    });
        }
    }

    @Test
    public void testEx() throws Exception {
        try (GitLab gitLab = createPAT()) {
            new QueryMembers("htks/client")
                    .acceptEx(gitLab)
                    .forEach(System.out::println);
        }
    }
}
