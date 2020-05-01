package cn.xpbootcamp.gilded_rose;

import cn.xpbootcamp.gilded_rose.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class GildedRose {

  private List<Product> productList;

  public void updateProductQuality() {
    for (Product product : productList) {
      checkQualityRange(product);

      if (!product.getName().equals("Aged Brie") && !product.getName().equals("Sulfuras")
      && !product.getName().equals("Backstage pass")) {
        qualityDecreasedByDay(product);
      } else if (!product.getName().equals("Sulfuras") && !product.getName().equals("Backstage pass")) {
        qualityIncreasedByDay(product);
      } else if (product.getName().equals("Backstage pass")) {
        qualityChangedByDay(product);
      }
    }
  }

  private void qualityChangedByDay(Product product) {
    if (product.getSellIn() > 10) {
      product.setQuality(product.getQuality() + 1);
    } else if (product.getSellIn() > 5) {
      product.setQuality(product.getQuality() + 2);
    } else if (product.getSellIn() > 0) {
      product.setQuality(product.getQuality() + 3);
    } else {
      product.setQuality(0);
    }
    product.setSellIn(product.getSellIn() - 1);
  }

  private void qualityIncreasedByDay(Product product) {
    product.setSellIn(product.getSellIn() - 1);
    product.setQuality(product.getQuality() + 1);
  }

  private void qualityDecreasedByDay(Product product) {
    product.setSellIn(product.getSellIn() - 1);
    if (product.getSellIn() >= 0) {
      product.setQuality(product.getQuality() - 1);
    } else {
      product.setQuality(product.getQuality() - 2);
    }
  }

  private void checkQualityRange(Product product) {
    if (product.getQuality() < 0) {
      product.setQuality(0);
    } else if (product.getQuality() > 50) {
      product.setQuality(50);
    }
  }
}
