package com.gildedrose.quality;

import com.gildedrose.Item;

class DefaultQualityUpdateStrategy implements ItemQualityUpdateStrategy {

    @Override
    public Item updateQuality(Item item) {
        item.quality = item.sellIn > 0 ? item.quality - 1 : item.quality - 2;
        return item;
    }
}
