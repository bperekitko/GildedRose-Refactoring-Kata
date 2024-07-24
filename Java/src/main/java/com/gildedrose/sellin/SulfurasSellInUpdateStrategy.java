package com.gildedrose.sellin;

import com.gildedrose.Item;

class SulfurasSellInUpdateStrategy implements ItemSellInUpdateStrategy {

    @Override
    public void updateSellInFor(Item item) {
        // Sulfuras, being a legendary item, never has to be sold
    }
}
