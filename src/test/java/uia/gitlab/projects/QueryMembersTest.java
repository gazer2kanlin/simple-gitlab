package uia.gitlab.projects;

import org.junit.Test;

import uia.gitlab.AbstractGitLabTest;
import uia.gitlab.GitLab;

public class QueryMembersTest extends AbstractGitLabTest {

    @Test
    public void test() throws Exception {
        try (GitLab gitLab = createPAT()) {
            new QueryMembers("htks/web/psb.web")
                    .accept(gitLab)
                    .forEach(m -> {
                        System.out.println(m.get("username"));
                    });
        }
    }

    @Test
    public void testEx() throws Exception {
        try (GitLab gitLab = createPAT()) {
            new QueryMembers("htks/web/psb.web")
                    .acceptEx(gitLab)
                    .forEach(System.out::println);
        }
    }
}
