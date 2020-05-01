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
      if (product.getQuality() < 0) {
        product.setQuality(0);
      } else if (product.getQuality() > 50) {
        product.setQuality(50);
      }
    }
  }
}
