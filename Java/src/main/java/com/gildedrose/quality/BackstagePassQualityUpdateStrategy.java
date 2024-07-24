package com.gildedrose.quality;

import com.gildedrose.Item;

class BackstagePassQualityUpdateStrategy implements ItemQualityUpdateStrategy {
    @Override
    public Item updateQuality(Item item) {
        int sellIn = item.sellIn;
        if (sellIn > 10) {
            item.quality = item.quality + 1;
        } else if (sellIn > 5) {
            item.quality = item.quality + 2;
        } else if (sellIn > 0) {
            item.quality = item.quality + 3;
        } else {
            item.quality = 0;
        }
        return item;
    }
}
