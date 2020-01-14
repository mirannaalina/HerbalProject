package ro.herb.herbalproject.constraint;


import ro.herb.herbalproject.controller.user.UserDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FieldMatchValidator  implements ConstraintValidator<FieldMatch,Object>{

    private String firstFieldName;
    private String secondFieldName;
    private String message;

    @Override
    public void initialize(final FieldMatch constraintAnnotation) {
        firstFieldName=constraintAnnotation.first();
        secondFieldName=constraintAnnotation.second();
        message=constraintAnnotation.message();
    }

    @Override
    public boolean isValid(final Object value, final ConstraintValidatorContext context) {
        UserDto user = (UserDto) value;
        return user.getPassword().equals(user.getMatchingPassword());

    }
}
