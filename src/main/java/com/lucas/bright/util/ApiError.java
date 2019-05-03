package com.lucas.bright.util;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 *
 * @author Lucas Daniel
 */
@JacksonXmlRootElement(localName = "error")
public class ApiError {

    private String code;

    public ApiError(String code) {
        super();
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
