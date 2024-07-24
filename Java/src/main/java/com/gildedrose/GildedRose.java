package com.gildedrose;

import com.gildedrose.quality.ItemQualityUpdateStrategyContext;
import com.gildedrose.sellin.ItemSellInStrategyContext;

class GildedRose {
    Item[] items;
    private final ItemQualityUpdateStrategyContext qualityUpdateStrategyContext;
    private final ItemSellInStrategyContext sellInStrategyContext;

    public GildedRose(Item[] items, ItemQualityUpdateStrategyContext qualityUpdateStrategyContext, ItemSellInStrategyContext sellInStrategyContext) {
        this.items = items;
        this.qualityUpdateStrategyContext = qualityUpdateStrategyContext;
        this.sellInStrategyContext = sellInStrategyContext;
    }

    public void updateQuality() {
        for (Item item : items) {
            qualityUpdateStrategyContext.getStrategyFor(item).updateQuality(item);
            sellInStrategyContext.getStrategyFor(item).updateSellInFor(item);
        }
    }
}
