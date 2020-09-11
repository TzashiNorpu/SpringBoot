package com.tzashinorpu.elasticsearch.controller;

import com.tzashinorpu.elasticsearch.bean.Article;
import com.tzashinorpu.elasticsearch.bean.Book;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.IndexOperations;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.GetQuery;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class ESController {

    private ElasticsearchOperations elasticsearchOperations;

    public ESController(ElasticsearchOperations elasticsearchOperations) {
        this.elasticsearchOperations = elasticsearchOperations;
    }

    @PostMapping("/book")
    public String save(@RequestBody Book book) {

        IndexQuery indexQuery = new IndexQueryBuilder()
                .withId(book.getId().toString())
                .withObject(book)
                .build();
        IndexCoordinates indexCoordinates = IndexCoordinates.of("tzashinorpu");
        String index = elasticsearchOperations.index(indexQuery, indexCoordinates);
        return index;
    }

    @GetMapping("/book/{id}")
    public Book findById(@PathVariable("id")  Long id) {
        Book person = elasticsearchOperations.queryForObject(GetQuery.getById(id.toString()), Book.class);
        return person;
    }

    @PostMapping("/article")
    public Article save(@RequestBody Article article) {

       /* IndexQuery indexQuery = new IndexQueryBuilder()
                .withId(book.getId().toString())
                .withObject(book)
                .build();
        IndexCoordinates indexCoordinates = IndexCoordinates.of("tzashinorpu");*/
        Article save = elasticsearchOperations.save(article);
        return save;
    }
}
