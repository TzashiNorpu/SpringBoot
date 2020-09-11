package com.tzashinorpu.elasticsearch.bean;

//import io.searchbox.annotations.JestId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "test")
@TypeAlias("Haha")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {

//    @JestId
    private Integer id;
    private String author;
    private String title;
    private String content;
}
