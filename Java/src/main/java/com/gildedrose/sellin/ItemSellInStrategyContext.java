package com.gildedrose.sellin;

import com.gildedrose.Item;
import com.gildedrose.ItemType;

public class ItemSellInStrategyContext {

    public ItemSellInUpdateStrategy getStrategyFor(Item item) {
        return ItemType.from(item) == ItemType.SULFURAS
            ? new SulfurasSellInUpdateStrategy()
            : defaultSellInUpdateStrategy();
    }

    private static ItemSellInUpdateStrategy defaultSellInUpdateStrategy() {
        return item -> item.sellIn = item.sellIn - 1;
    }
}
