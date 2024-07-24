package com.gildedrose.quality;

import com.gildedrose.Item;

class AgedBrieQualityUpdateStrategy implements ItemQualityUpdateStrategy {

    @Override
    public Item updateQuality(Item item) {
        if (item.sellIn <= 0) {
            item.quality = item.quality + 2;
        } else {
            item.quality = item.quality + 1;
        }
        return item;
    }
}
