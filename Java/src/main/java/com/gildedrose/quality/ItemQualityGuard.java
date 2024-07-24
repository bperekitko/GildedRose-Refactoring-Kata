package com.gildedrose.quality;

import com.gildedrose.Item;
import com.gildedrose.ItemType;

class ItemQualityGuard {
    private static final int MIN_QUALITY = 0;
    private static final int MAX_QUALITY = 50;

    static Item checkQualityInvariants(Item item) {
        if (item.quality < MIN_QUALITY) {
            item.quality = MIN_QUALITY;
        } else if (item.quality > MAX_QUALITY && ItemType.from(item) != ItemType.SULFURAS) {
            item.quality = MAX_QUALITY;
        }
        return item;
    }
}
