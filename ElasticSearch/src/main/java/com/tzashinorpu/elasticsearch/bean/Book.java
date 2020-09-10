package com.tzashinorpu.elasticsearch.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Document(indexName = "atguigu",type = "book")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private Integer id;
    private String bookName;
    private String author;
}
