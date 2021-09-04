package xyz.liaojl.fund.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import xyz.liaojl.fund.common.CommonException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.Charset;

@Service
public class FundService {
        private static final ObjectMapper objectMapper = new ObjectMapper();
        @Value("${fund.url.detail}")
        private String fundDetailUrl;

        public String getNameByCode(String code) {
                HttpRequest request = HttpRequest.newBuilder()
                        .GET()
                        .uri(URI.create(String.format(fundDetailUrl, code)))
                        .build();
                try {
                        String response = HttpClient.newBuilder().build()
                                .send(request, HttpResponse.BodyHandlers.ofString(Charset.defaultCharset())).body();
                        JsonNode jsonNode = objectMapper.readTree(response);
                        return jsonNode.get("Expansion").get("SHORTNAME").asText();
                } catch (IOException | InterruptedException e) {
                        throw new CommonException("Get fund name failed!");
                }
        }
}
