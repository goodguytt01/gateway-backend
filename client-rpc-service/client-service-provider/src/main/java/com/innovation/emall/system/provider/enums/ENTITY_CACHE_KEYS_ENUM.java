package com.innovation.emall.system.provider.enums;

public enum ENTITY_CACHE_KEYS_ENUM {
    CLIENT("cliClient"), PRODUCT("product"), Wed("Wednesday"), Thu("Thursday"), Fri( "Friday"), Sat("Saturday"), Sun("Sunday");

    private final String day;
    private ENTITY_CACHE_KEYS_ENUM(String day) {
        this.day = day;
    }
}
