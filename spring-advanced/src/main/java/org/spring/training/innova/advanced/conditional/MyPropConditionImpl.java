package org.spring.training.innova.advanced.conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.MultiValueMap;

public class MyPropConditionImpl implements Condition {
    @Override
    public boolean matches(ConditionContext context,
                           AnnotatedTypeMetadata metadata) {
        MultiValueMap<String, Object> allAnnotationAttributes = metadata.getAllAnnotationAttributes(MyPropCondition.class.getName());
        if (allAnnotationAttributes == null){
            return false;
        }
        String conf = (String) allAnnotationAttributes.getFirst("conf");
        if (conf == null) {
            return false;
        }
        String confVal = (String) allAnnotationAttributes.getFirst("confValue");
        String conf1 = context.getEnvironment()
                              .getProperty(conf);
        if (conf1 == null) {
            return false;
        }
        return conf1.equalsIgnoreCase(confVal);
    }
}
