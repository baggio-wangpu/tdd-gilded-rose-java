package cn.xpbootcamp.gilded_rose;

import cn.xpbootcamp.gilded_rose.entity.Product;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class GildedRoseTest {

  @Test
  void product_quality_should_between_zero_to_fifty() {
    Product illegalProduct = Product.builder().name("Illegal Product").sellIn(5).quality(100).build();
    GildedRose gildedRose = new GildedRose(Collections.singletonList(illegalProduct));

    gildedRose.updateProductQuality();

    assertTrue(illegalProduct.getQuality() >=0 && illegalProduct.getQuality() <= 50);
  }

  @Test
  void product_quality_double_drop_when_pass_sellIn() {
    Product commonProduct = Product.builder().name("Common Product").sellIn(2).quality(10).build();
    GildedRose gildedRose = new GildedRose(Collections.singletonList(commonProduct));

    int day = 3;
    for (int i = 0; i < day; i++) {
      gildedRose.updateProductQuality();
    }

    assertEquals(6, commonProduct.getQuality());
  }

  @Test
  void product_Aged_Brie_increase_when_passing_sellIn() {
    Product agedBrie = Product.builder().name("Aged Brie").sellIn(10).quality(10).build();
    GildedRose gildedRose = new GildedRose(Collections.singletonList(agedBrie));

    int day = 1;
    for (int i = 0; i < day; i++) {
      gildedRose.updateProductQuality();
    }

    assertEquals("Aged Brie", agedBrie.getName());
    assertEquals(11, agedBrie.getQuality());
  }

  @Test
  void product_Sulfuras_when_days_passed() {
    Product agedBrie = Product.builder().name("Sulfuras").sellIn(10).quality(10).build();
    GildedRose gildedRose = new GildedRose(Collections.singletonList(agedBrie));

    int day = 3;
    for (int i = 0; i < day; i++) {
      gildedRose.updateProductQuality();
    }

    assertEquals("Sulfuras", agedBrie.getName());
    assertEquals(10, agedBrie.getQuality());
  }
}