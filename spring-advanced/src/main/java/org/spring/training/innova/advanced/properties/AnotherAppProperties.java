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
@ConfigurationProperties(prefix = "another.properties")
@Component
public class AnotherAppProperties {

    private String aprop;
    private String bprop;
    private Integer port2;
    private Duration defaulTimeout;
    private Rule anotherDefaultRule;
    private List<String> ruleList;
    private List<Rule> executableRuleList;
    private Map<String,Rule> monitoringRuleMap;


}
