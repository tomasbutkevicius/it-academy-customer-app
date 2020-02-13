package com.enorkus.academy.validation;

import com.enorkus.academy.exception.MandatoryValueMissingException;

import java.security.InvalidParameterException;
import java.text.MessageFormat;
import java.util.Properties;

public interface Validator<T>{
    T getProperty(T key);
}