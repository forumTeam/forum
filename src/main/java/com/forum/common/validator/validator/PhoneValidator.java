package com.forum.common.validator.validator;

import com.forum.common.utils.StringUtil;
import com.forum.common.validator.annotation.Phone;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class PhoneValidator implements ConstraintValidator<Phone, String> {

    private boolean required = false;

    private Pattern pattern = Pattern.compile("^(13[0-9]|14[5-9]|15[012356789]|166|17[0-8]|18[0-9]|19[8-9])[0-9]{8}$");

    @Override
    public void initialize(Phone constraintAnnotation) {
        required = constraintAnnotation.required();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (required) if (StringUtil.isEmpty(value)) return false;
        if (!required && StringUtil.isEmpty(value)) return true;
        return pattern.matcher(value).find();
    }
}
