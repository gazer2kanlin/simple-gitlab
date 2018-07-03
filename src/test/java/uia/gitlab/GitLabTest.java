package uia.gitlab;

import org.junit.Test;

import uia.gitlab.projects.QueryProjects;

public class GitLabTest extends AbstractGitLabTest {

    @Test
    public void test() throws Exception {
        GitLab git = createPAT();
        new QueryProjects().accept(git).forEach(m -> {
            System.out.println(m.get("name"));
        });
    }

    @Test
    public void testEx() throws Exception {
        GitLab git = createPAT();
        new QueryProjects().acceptEx(git).forEach(p -> {
            System.out.println(p);
        });
    }
}
