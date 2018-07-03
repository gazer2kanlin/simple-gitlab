package uia.gitlab;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import uia.utils.http.SimpleHttpClientResponse;

public abstract class GitLab implements AutoCloseable {

    protected final Gson gson;

    public GitLab() {
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    public abstract SimpleHttpClientResponse get(String action) throws IOException;

    public abstract SimpleHttpClientResponse post(String action, Object data) throws IOException;

    @SuppressWarnings("unchecked")
    public Map<String, Object> json2Map(String json) {
        return this.gson.fromJson(json, Map.class);
    }

    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> json2List(String json) {
        return this.gson.fromJson(json, List.class);
    }

    public <T> T json2Object(String json, Class<T> cls) {
        return this.gson.fromJson(json, cls);
    }

    public <T> T json2Object(String json, Type type) {
        return this.gson.fromJson(json, type);
    }

    public String rePath(String path) {
        return path.replace("/", "%2F");
    }

    public static GitLab create(String address, int port, String apiToken) {
        return new GitLabPAT(address, port, apiToken);
    }
}
