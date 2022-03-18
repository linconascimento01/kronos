package com.hours.kronos;

import lombok.Getter;

@Getter
public enum PerfilEnum {
    ADMINISTRADOR(1),
    DESENVOLVEDOR(2),
    CLIENTE_EMPRESA(3);

    private Integer value;

    PerfilEnum(Integer value) {
        this.value = value;
    }
}
