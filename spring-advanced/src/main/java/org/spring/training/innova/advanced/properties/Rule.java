package org.spring.training.innova.advanced.properties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.Duration;

@Getter
@Setter
@ToString
public class Rule {

    private String ruleName;
    private Integer ruleCount;
    private Duration ruleTimeout;

}
