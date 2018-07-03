package uia.gitlab;

import com.google.gson.GsonBuilder;

public class AbstractGitLabTest {

    protected GitLab createPAT() {
        // KAO
        // return GitLab.create("59.125.131.19", 8080, "MUs78Dy3yc-7kMvhPbks");
        // DK
        return GitLab.create("172.20.100.97", 18080, "n2UAzzWCKo8qzyFswzKd");
        // return GitLab.create("172.20.100.98", 18080, "SGr4npkzyKHSjNGavxA6");

    }

    protected void print(Object obj) {
        System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(obj));
    }
}
