package org.spring.training.innova.advanced.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@ConfigurationProperties(prefix = "my.app.prop")
@Component
public class AppProperties {

    private String prop1;
    private String prop2;
    private Integer port;
    private Duration timeout;
    private Rule defaultRule;
    private List<String> ruleNames;
    private List<Rule> rules;
    private Map<String,Rule> ruleMap;

    public String consolidate(){
        return prop1 + " " + prop2;
    }

}
