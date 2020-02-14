package com.enorkus.academy.validation;

public abstract class Validator<T>{
    public abstract void validate(T Attribute, String message);
}