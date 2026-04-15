package org.example.session08_baitap04.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Target({ ElementType.TYPE }) // Gắn lên Class
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordMatchingValidator.class)
@Documented
public @interface PasswordMatching {
    // Thông báo lỗi mặc định khi 2 mật khẩu không khớp
    String message() default "Mật khẩu xác nhận không trùng khớp!";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
