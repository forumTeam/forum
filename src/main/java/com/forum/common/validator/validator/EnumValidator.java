package com.forum.common.validator.validator;

import com.forum.common.utils.StringUtil;
import com.forum.common.validator.annotation.Enums;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 枚举校验器
 */
public class EnumValidator implements ConstraintValidator<Enums, String> {

    private boolean required = false;
    private String[] enums = null;


    @Override
    public void initialize(Enums constraintAnnotation) {

        required = constraintAnnotation.required();
        enums = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (required) if (StringUtil.isEmpty(value)) return false;
        for (String item : enums) {
            if (item.equals(value)) return true;
        }
        return false;
    }
}
