package uia.gitlab;

import java.io.IOException;
import java.util.TreeMap;

import uia.utils.http.SimpleHttpClient;
import uia.utils.http.SimpleHttpClientResponse;

/**
 * GitLab with personal access tokens.
 *
 * @author Kyle K. Lin
 *
 */
public class GitLabPAT extends GitLab {

    private final String apiUrl;

    private SimpleHttpClient client;

    private String apiToken;

    public GitLabPAT(String address, int port, String apiToken) {
        this.apiToken = apiToken;
        this.apiUrl = String.format("http://%s:%s/api/v4", address, port);
        this.client = new SimpleHttpClient(this.apiUrl);
    }

    @Override
    public SimpleHttpClientResponse get(String action) throws IOException {
        TreeMap<String, String> headers = new TreeMap<String, String>();
        headers.put("Private-Token", this.apiToken);
        return this.client.get(action, headers);
    }

    @Override
    public SimpleHttpClientResponse post(String action, Object data) throws IOException {
        TreeMap<String, String> headers = new TreeMap<String, String>();
        headers.put("Private-Token", this.apiToken);
        return this.client.postJson(action, this.gson.toJson(data), headers);
    }

    @Override
    public void close() throws Exception {
        this.client.close();
        System.out.println("http closed");
    }
}
