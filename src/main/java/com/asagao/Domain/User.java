package com.asagao.Domain;


import java.time.LocalDate;

import lombok.Data;

@Data
public class User {

	/** ユーザー内部ID */
	private Integer id;
    /** メールアドレス */
    private String email;
    /** パスワード */
    private String password;
    /** 役割（1:管理者、2:一般ユーザー） */
    private Integer role = 2;
    /** 名 */
    private String lastName;
    /** 姓 */
    private String firstName;
    /** 郵便番号 */
    private String postNumber;
    /** 住所 */
    private String address;
    /** 電話番号 */
    private String telNumber;
    /** 作成日時 */
    private LocalDate createdAt;
    /** 更新日時 */
    private LocalDate updatedAt;
}
