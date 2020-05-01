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
      product.setSellIn(product.getSellIn() - 1);
      if (product.getSellIn() >= 0) {
        product.setQuality(product.getQuality() - 1);
      } else {
        product.setQuality(product.getQuality() - 2);
      }
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
