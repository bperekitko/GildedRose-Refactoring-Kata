package com.gildedrose.quality;

import com.gildedrose.Item;
import com.gildedrose.ItemType;

import java.util.HashMap;
import java.util.Map;

public class ItemQualityUpdateStrategyContext {

    private final Map<ItemType, ItemQualityUpdateStrategy> strategyByItemName;

    public ItemQualityUpdateStrategyContext() {
        strategyByItemName = new HashMap<>();
        strategyByItemName.put(ItemType.AGED_BRIE, new AgedBrieQualityUpdateStrategy());
        strategyByItemName.put(ItemType.SULFURAS, new SulfurasQualityUpdateStrategy());
        strategyByItemName.put(ItemType.BACKSTAGE_PASS, new BackstagePassQualityUpdateStrategy());
        strategyByItemName.put(ItemType.CONJURED, new ConjuredQualityUpdateStrategy());
    }

    public ItemQualityUpdateStrategy getStrategyFor(Item item) {
        ItemType itemType = ItemType.from(item);
        ItemQualityUpdateStrategy strategy = strategyByItemName.getOrDefault(itemType, new DefaultQualityUpdateStrategy());
        return decoratedWithGuards(strategy);
    }

    private ItemQualityUpdateStrategy decoratedWithGuards(ItemQualityUpdateStrategy strategy) {
        return item -> ItemQualityGuard.checkQualityInvariants(strategy.updateQuality(item));
    }
}
