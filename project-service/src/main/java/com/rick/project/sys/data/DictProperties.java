package com.rick.project.sys.data;

import lombok.Data;
import lombok.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author Rick
 * @createdAt 2021-09-06 18:18:00
 */
@ConfigurationProperties(prefix = "dict")
@Component
@Data
public class DictProperties {

    private List<Item> items;

    @Data
    public static class Item {

        private String type;

        private String sql;

        private Map<String, String> map;
    }
}
