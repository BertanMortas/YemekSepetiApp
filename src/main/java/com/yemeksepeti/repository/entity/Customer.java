package com.yemeksepeti.repository.entity;

import com.yemeksepeti.utility.enums.EStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tblcustomer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;
    @NotBlank(message = "kullanıcı adı boş bırakılamaz")
    private String customerName;
    @Email(message = "lütfen geçerli bir email giriniz")
    private String email;
    @NotBlank(message = "kullanıcı adresi boş bırakılamaz")
    private String customerAddress;
    private String phoneNumber;
//    @Pattern(regexp = "^(?=.[0-9])(?=.[a-z])(?=.[A-Z])(?=.[@#$%^&+=*!])(?=\\S+$).{8,}$",
//            message = "Şifre en az bir büyük, bir küçük, harf, rakam, ve özel karakterden oluşmalıdır.")
    private String password;
    @NotBlank(message = "kullanıcı kart bilgileri boş bırakılamaz")
    private String cardDetails;
    private String balance;
    private String activationCode;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private EStatus status = EStatus.PENDING;
}
