package org.example.session08_baitap04.validator;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.example.session08_baitap04.dto.UserRegistrationDto;

public class PasswordMatchingValidator implements ConstraintValidator<PasswordMatching, UserRegistrationDto> {

    @Override
    public boolean isValid(UserRegistrationDto dto, ConstraintValidatorContext context) {
        String password = dto.getPassword();
        String confirmPassword = dto.getConfirmPassword();

        // Chống bẫy NullPointerException:
        // Nếu một trong hai trường null, ta trả về false ngay lập tức
        if (password == null || confirmPassword == null) {
            return false;
        }

        // Kiểm tra tính khớp nhau của chuỗi
        return password.equals(confirmPassword);
    }
}