package com.bjtu.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class CartItemVo {
    private Integer bookId;
    private String bookTitle;
    private BigDecimal bookPrice;
    private Integer amount;
}
