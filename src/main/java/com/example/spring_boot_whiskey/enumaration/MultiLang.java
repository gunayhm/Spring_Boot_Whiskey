package com.example.spring_boot_whiskey.enumaration;

import java.util.ResourceBundle;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.context.i18n.LocaleContextHolder;

@Getter
@AllArgsConstructor
public enum MultiLang {

    BRANCH(1, "wording.service.branch");

    private final int code;
    private final String message;

    public int code() {
        return this.code;
    }

    public String message() {
        return ResourceBundle.getBundle("i18n/wording/messages",
                        LocaleContextHolder.getLocale())
                .getString(this.message);
    }

}
