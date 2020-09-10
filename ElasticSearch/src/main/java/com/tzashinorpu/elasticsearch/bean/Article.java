package com.tzashinorpu.elasticsearch.bean;

import io.searchbox.annotations.JestId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {

    @JestId
    private Integer id;
    private String author;
    private String title;
    private String content;
}
