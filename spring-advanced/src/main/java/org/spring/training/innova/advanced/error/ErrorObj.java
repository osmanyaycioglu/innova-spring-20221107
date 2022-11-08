package org.spring.training.innova.advanced.error;

import java.util.ArrayList;
import java.util.List;

public class ErrorObj {

    private List<ErrorObj> subErrors;
    private String microservice; // domain.subdomain.boundedcontext.name
    private String errorDesc;
    private int errorCode;

    public ErrorObj() {
    }

    public ErrorObj(List<ErrorObj> subErrors,
                    String microservice,
                    String errorDesc,
                    int errorCode) {
        this.subErrors = subErrors;
        this.microservice = microservice;
        this.errorDesc = errorDesc;
        this.errorCode = errorCode;
    }

    public ErrorObj addSubError(ErrorObj errorObj){
        if (subErrors == null){
            subErrors = new ArrayList<>();
        }
        subErrors.add(errorObj);
        return this;
    }

    public ErrorObj addSubErrors(List<ErrorObj> errorObj){
        if (subErrors == null){
            subErrors = new ArrayList<>();
        }
        subErrors.addAll(errorObj);
        return this;
    }

    public static ErrorObjBuilder builder() {
        return new ErrorObjBuilder();
    }


    public List<ErrorObj> getSubErrors() {
        return this.subErrors;
    }

    public String getMicroservice() {
        return this.microservice;
    }

    public String getErrorDesc() {
        return this.errorDesc;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public void setSubErrors(List<ErrorObj> subErrors) {
        this.subErrors = subErrors;
    }

    public void setMicroservice(String microservice) {
        this.microservice = microservice;
    }

    public void setErrorDesc(String errorDesc) {
        this.errorDesc = errorDesc;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public static class ErrorObjBuilder {
        private List<ErrorObj> subErrors;
        private String         microservice;
        private String         errorDesc;
        private int            errorCode;

        ErrorObjBuilder() {
        }

        public ErrorObjBuilder withSubErrors(List<ErrorObj> subErrors) {
            this.subErrors = subErrors;
            return this;
        }

        public ErrorObjBuilder withMicroservice(String microservice) {
            this.microservice = microservice;
            return this;
        }

        public ErrorObjBuilder withErrorDesc(String errorDesc) {
            this.errorDesc = errorDesc;
            return this;
        }

        public ErrorObjBuilder withErrorCode(int errorCode) {
            this.errorCode = errorCode;
            return this;
        }

        public ErrorObj build() {
            return new ErrorObj(subErrors,
                                microservice,
                                errorDesc,
                                errorCode);
        }

        public String toString() {
            return "ErrorObj.ErrorObjBuilder(subErrors=" + this.subErrors + ", microservice=" + this.microservice + ", errorDesc=" + this.errorDesc + ", errorCode=" + this.errorCode + ")";
        }
    }
}
