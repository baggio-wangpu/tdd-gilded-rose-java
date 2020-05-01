package cn.xpbootcamp.gilded_rose;

import cn.xpbootcamp.gilded_rose.entity.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GildedRoseTest {

  private GildedRose gildedRose;

  @BeforeEach
  void setUp() {
    Product commonProduct = Product.builder().name("Common Product").sellIn(5).quality(10).build();
    Product agedBrie = Product.builder().name("Aged Brie").sellIn(10).quality(10).build();
    Product sulfuras = Product.builder().name("Sulfuras").sellIn(100).quality(50).build();
    Product backstagePass = Product.builder().name("Backstage pass").sellIn(100).quality(50).build();
    gildedRose = new GildedRose(Arrays.asList(commonProduct, agedBrie, sulfuras, backstagePass));
  }

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
}