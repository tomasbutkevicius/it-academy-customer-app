package com.enorkus.academy.validation;

import java.security.InvalidParameterException;
import java.text.MessageFormat;
import java.util.Properties;

public class Validator extends Exception {
    public String getProperty(final String key) {
        if(key == null || key.isEmpty()) {
            throw new NullPointerException("Missing value in form");
           // throw new InvalidParameterException(MessageFormat.format("Missing value in form ", key));
        }
        return key;
    }

   // public String getProperty(final String key, final String defaultValue) {
        // Throw exception here as above if you want to throw exception even with defaultValue
  //      return super.getProperty(key, defaultValue);
   // }
}