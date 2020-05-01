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

  @Test
  void product_Backstage_quality_increase_when_performance_day_larger_than_ten() {
    Product backstagePass = Product.builder().name("Backstage pass").sellIn(12).quality(10).build();
    GildedRose gildedRose = new GildedRose(Collections.singletonList(backstagePass));

    int day = 1;
    for (int i = 0; i < day; i++) {
      gildedRose.updateProductQuality();
    }

    assertEquals("Backstage pass", backstagePass.getName());
    assertEquals(11, backstagePass.getQuality());
  }

  @Test
  void product_Backstage_quality_increase_when_performance_day_between_ten_and_five() {
    Product backstagePass = Product.builder().name("Backstage pass").sellIn(12).quality(10).build();
    GildedRose gildedRose = new GildedRose(Collections.singletonList(backstagePass));

    int day = 3;
    for (int i = 0; i < day; i++) {
      gildedRose.updateProductQuality();
    }

    assertEquals("Backstage pass", backstagePass.getName());
    assertEquals(14, backstagePass.getQuality());
  }

  @Test
  void product_Backstage_quality_increase_when_performance_day_less_than_five() {
    Product backstagePass = Product.builder().name("Backstage pass").sellIn(12).quality(10).build();
    GildedRose gildedRose = new GildedRose(Collections.singletonList(backstagePass));

    int day = 10;
    for (int i = 0; i < day; i++) {
      gildedRose.updateProductQuality();
    }

    assertEquals("Backstage pass", backstagePass.getName());
    assertEquals(31, backstagePass.getQuality());
  }

  @Test
  void product_Backstage_quality_increase_when_performance_day_equals_zero() {
    Product backstagePass = Product.builder().name("Backstage pass").sellIn(12).quality(10).build();
    GildedRose gildedRose = new GildedRose(Collections.singletonList(backstagePass));

    int day = 12;
    for (int i = 0; i < day; i++) {
      gildedRose.updateProductQuality();
    }

    assertEquals("Backstage pass", backstagePass.getName());
    assertEquals(37, backstagePass.getQuality());
  }

  @Test
  void product_Backstage_quality_increase_when_performance_day_less_than_zero() {
    Product backstagePass = Product.builder().name("Backstage pass").sellIn(12).quality(10).build();
    GildedRose gildedRose = new GildedRose(Collections.singletonList(backstagePass));

    int day = 13;
    for (int i = 0; i < day; i++) {
      gildedRose.updateProductQuality();
    }

    assertEquals("Backstage pass", backstagePass.getName());
    assertEquals(0, backstagePass.getQuality());
  }
}