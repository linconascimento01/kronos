package com.hours.kronos.enums;

import lombok.Getter;

@Getter
public enum PerfilEnum {
    ADMINISTRADOR(1),
    DESENVOLVEDOR(2),
    CLIENTE_EMPRESA(3);

    private final Integer value;

    PerfilEnum(Integer value) {
        this.value = value;
    }
}
