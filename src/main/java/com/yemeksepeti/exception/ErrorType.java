package com.yemeksepeti.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
@Getter
@AllArgsConstructor
public enum ErrorType {
    INTERNAL_ERROR(5100, "Sunucu Hatası", HttpStatus.INTERNAL_SERVER_ERROR),
    BAD_REQUEST(4000, "Parametre Hatası", HttpStatus.BAD_REQUEST),
    LOGIN_ERROR(4100, "Kullancı adı veya şifre hatalı", HttpStatus.BAD_REQUEST),
    PASSWORD_ERROR(4200, "Şifreler aynı değil", HttpStatus.BAD_REQUEST),
    USERNAME_DUPLICATE(4300, "Bu kullanıcı zaten kayıtlı", HttpStatus.BAD_REQUEST),
    PRODUCT_DUPLICATE(4302, "Bu product zaten başka restoranda kayıtlı", HttpStatus.BAD_REQUEST),
    EMAIL_DUPLICATE(4301, "Bu kullanıcı mail i zaten kayıtlı", HttpStatus.BAD_REQUEST),
    USER_NOT_FOUND(4400, "Böyle bir kullanıcı bulunamadı", HttpStatus.NOT_FOUND),
    RESTAURANT_NOT_FOUND(4400, "Böyle bir restoran bulunamadı", HttpStatus.NOT_FOUND),
    USER_NOT_ACTIVE(4404, "Kullanıcı aktif değil", HttpStatus.NOT_FOUND),
    ACTIVATE_CODE_ERROR(4500, "Aktivasyon kod hatası", HttpStatus.BAD_REQUEST);

    private int code;
    private String message;
    HttpStatus httpStatus;
}
