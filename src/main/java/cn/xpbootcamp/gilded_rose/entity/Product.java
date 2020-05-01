package cn.xpbootcamp.gilded_rose.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product {

  private String name;

  private int sellIn;

  private int quality;
}
