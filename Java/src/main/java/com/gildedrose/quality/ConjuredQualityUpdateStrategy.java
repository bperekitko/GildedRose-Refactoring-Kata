package com.gildedrose.quality;

import com.gildedrose.Item;

class ConjuredQualityUpdateStrategy implements ItemQualityUpdateStrategy {

    @Override
    public Item updateQuality(Item item) {
        item.quality = item.sellIn > 0 ? item.quality - 2 : item.quality - 4;
        return item;
    }
}
