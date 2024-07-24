package com.gildedrose;

import com.gildedrose.quality.ItemQualityUpdateStrategyContext;
import com.gildedrose.sellin.ItemSellInStrategyContext;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GildedRoseTest {

    private static final GildedRose gildedRose = new GildedRose(new Item[]{}, new ItemQualityUpdateStrategyContext(), new ItemSellInStrategyContext());
    @Test
    void shouldDecreaseQualityByOneForDefaultItem() {
        // given
        int initialQuality = 10;
        Item item = new Item("SomeItem", 10, initialQuality);
        gildedRose.items = new Item[]{item};

        // when
        gildedRose.updateQuality();

        // then
        assertThat(item.quality).isEqualTo(initialQuality - 1);
    }

    @Test
    void shouldDecreaseQualityByTwoWhenSellInPassed() {
        // given
        int initialQuality = 10;
        Item item = new Item("SomeItem", 0, initialQuality);
        gildedRose.items = new Item[]{item};

        // when
        gildedRose.updateQuality();

        // then
        assertThat(item.quality).isEqualTo(initialQuality - 2);
    }

    @Test
    void shouldNotDecreaseQualityBelowZero() {
        // given
        int initialQuality = 0;
        Item item = new Item("SomeItem", 10, initialQuality);
        gildedRose.items = new Item[]{item};

        // when
        gildedRose.updateQuality();
        gildedRose.updateQuality();
        gildedRose.updateQuality();

        // then
        assertThat(item.quality).isEqualTo(0);
    }

    @Test
    void shouldIncreaseQualityByOneForAgedBrie() {
        // given
        int initialQuality = 10;
        Item item = new Item("Aged Brie", 10, initialQuality);
        gildedRose.items = new Item[]{item};

        // when
        gildedRose.updateQuality();

        // then
        assertThat(item.quality).isEqualTo(initialQuality + 1);
    }

    @Test
    void shouldIncreaseQualityByTwoForAgedBrieWhenSellInPassed() {
        // given
        int initialQuality = 10;
        Item item = new Item("Aged Brie", 0, initialQuality);
        gildedRose.items = new Item[]{item};

        // when
        gildedRose.updateQuality();

        // then
        assertThat(item.quality).isEqualTo(initialQuality + 2);
    }

    @Test
    void shouldNotIncreaseQualityAboveFifty() {
        // given
        int initialQuality = 50;
        Item item = new Item("Aged Brie", 10, initialQuality);
        gildedRose.items = new Item[]{item};

        // when
        gildedRose.updateQuality();
        gildedRose.updateQuality();
        gildedRose.updateQuality();

        // then
        assertThat(item.quality).isEqualTo(50);
    }

    @Test
    void shouldNotUpdateSulfurasItem() {
        // given
        int initialQuality = 80;
        int initialSellIn = 10;
        Item item = new Item("Sulfuras, Hand of Ragnaros", initialSellIn, initialQuality);
        gildedRose.items = new Item[]{item};

        // when
        gildedRose.updateQuality();
        gildedRose.updateQuality();
        gildedRose.updateQuality();

        // then
        assertThat(item.quality).isEqualTo(initialQuality);
        assertThat(item.sellIn).isEqualTo(initialSellIn);
    }

    @Test
    void shouldIncreaseQualityByOneForBackstagePassesWhenMoreThan10Days() {
        // given
        int initialQuality = 10;
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 11, initialQuality);
        gildedRose.items = new Item[]{item};

        // when
        gildedRose.updateQuality();

        // then
        assertThat(item.quality).isEqualTo(initialQuality + 1);
    }

    @Test
    void shouldIncreaseQualityByTwoForBackstagePassesWhenMoreThan5Days() {
        // given
        int initialQuality = 10;
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 6, initialQuality);
        gildedRose.items = new Item[]{item};

        // when
        gildedRose.updateQuality();

        // then
        assertThat(item.quality).isEqualTo(initialQuality + 2);
    }

    @Test
    void shouldIncreaseQualityByThreeForBackstagePassesWhenMoreThan0Days() {
        // given
        int initialQuality = 10;
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 1, initialQuality);
        gildedRose.items = new Item[]{item};

        // when
        gildedRose.updateQuality();

        // then
        assertThat(item.quality).isEqualTo(initialQuality + 3);
    }

    @Test
    void shouldSetQualityToZeroForBackstagePassesWhenSellInPassed() {
        // given
        int initialQuality = 10;
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 0, initialQuality);
        gildedRose.items = new Item[]{item};

        // when
        gildedRose.updateQuality();

        // then
        assertThat(item.quality).isEqualTo(0);
    }

    @Test
    void shouldDecreaseQualityByTwoForConjuredItem() {
        // given
        int initialQuality = 10;
        Item item = new Item("Conjured Mana Cake", 10, initialQuality);
        gildedRose.items = new Item[]{item};

        // when
        gildedRose.updateQuality();

        // then
        assertThat(item.quality).isEqualTo(initialQuality - 2);
    }

    @Test
    void shouldDecreaseQualityByFourForConjuredItemWhenSellInPassed() {
        // given
        int initialQuality = 10;
        Item item = new Item("Conjured Mana Cake", 0, initialQuality);
        gildedRose.items = new Item[]{item};

        // when
        gildedRose.updateQuality();

        // then
        assertThat(item.quality).isEqualTo(initialQuality - 4);
    }
}
