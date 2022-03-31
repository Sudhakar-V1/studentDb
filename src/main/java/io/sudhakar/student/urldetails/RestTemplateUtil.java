package io.sudhakar.student.urldetails;

import io.sudhakar.student.dto.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;


@Slf4j
@Component
public class RestTemplateUtil {

    private final RestTemplate restTemplate;
    private final UrlClass urlClass;

    public RestTemplateUtil(RestTemplate restTemplate, UrlClass urlClass) {
        this.restTemplate = restTemplate;
        this.urlClass = urlClass;
    }

    public <T> T get(String urlName, Class<T> responseType) {

        String resourceUrl = getUrl(urlName);

        ResponseEntity<T> responseEntity = restTemplate.getForEntity(resourceUrl, responseType);

        return responseEntity.getBody();
    }

    public <T> T get(String urlName, Class<T> responseType, int id) {

        String resourceUrl = getUrl(urlName);

        ResponseEntity<T> responseEntity = restTemplate.getForEntity(resourceUrl + id, responseType);

        return responseEntity.getBody();
    }


    public <T> T post(String urlName, Employee employee, Class<T> responseType) {

        String resourceUrl = getUrl(urlName);

        ResponseEntity<T> responseEntity = restTemplate.postForEntity(resourceUrl, employee, responseType);

        return responseEntity.getBody();
    }

    public void delete(String urlName, int id) {

        String resourceUrl = getUrl(urlName);

        restTemplate.delete(resourceUrl + id);
    }

    public void put(String urlName, Employee employee, int id) {

        String resourceUrl = getUrl(urlName);

        restTemplate.put(resourceUrl + id, employee);
    }

    private String getUrl(String urlName) {

        String url = null;

        if ("findAll".equals(urlName)) {
            url = urlClass.getFindAll();
        } else if ("findById".equals(urlName)) {
            url = urlClass.getFindById();
        } else if ("add".equals(urlName)) {
            url = urlClass.getAdd();
        } else if ("update".equals(urlName)) {
            url = urlClass.getUpdate();
        } else if ("delete".equals(urlName)) {
            url = urlClass.getDelete();
        }

        Assert.isTrue(url != null, "no url  mapped for queryName " + urlName);
        return url;
    }

}
