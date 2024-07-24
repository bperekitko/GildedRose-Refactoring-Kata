package com.gildedrose;

import java.util.Arrays;

public enum ItemType {
    SULFURAS("Sulfuras"),
    BACKSTAGE_PASS("Backstage pass"),
    AGED_BRIE("Aged Brie"),
    CONJURED("Conjured"),
    OTHER("");

    private final String prefix;

    ItemType(String prefix) {
        this.prefix = prefix;
    }

    public static ItemType from(Item item) {
        return Arrays.stream(values())
            .filter(v -> item.name.startsWith(v.prefix))
            .findFirst()
            .orElse(OTHER);
    }
}
