package uia.gitlab.groups;

import org.junit.Test;

import uia.gitlab.AbstractGitLabTest;
import uia.gitlab.GitLab;

public class QuerySubGroupsTest extends AbstractGitLabTest {

    @Test
    public void test() throws Exception {
        try (GitLab gitLab = createPAT()) {
            new QuerySubGroups("htks")
                    .accept(gitLab)
                    .forEach(m -> {
                        System.out.println(m.get("name"));
                    });
        }
    }

    @Test
    public void testEx() throws Exception {
        try (GitLab gitLab = createPAT()) {
            new QuerySubGroups("htks")
                    .acceptEx(gitLab)
                    .forEach(System.out::println);
        }
    }
}
