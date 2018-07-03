package uia.gitlab.groups;

import org.junit.Test;

import uia.gitlab.AbstractGitLabTest;
import uia.gitlab.GitLab;

public class QueryGroupsTest extends AbstractGitLabTest {

    @Test
    public void test() throws Exception {
        try (GitLab gitLab = createPAT()) {
            new QueryGroups()
                    .accept(gitLab)
                    .forEach(m -> {
                        System.out.println(m.get("name"));
                    });
        }
    }

    @Test
    public void testEx() throws Exception {
        try (GitLab gitLab = createPAT()) {
            new QueryGroups()
                    .acceptEx(gitLab)
                    .forEach(System.out::println);
        }
    }
}
