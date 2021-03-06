package com.beheresoft.website.dict.pojo;

import com.google.common.collect.Lists;
import lombok.Getter;

import java.util.List;

/**
 * @author Aladi
 */
public class Catalog {

    @Getter
    private String name;
    @Getter
    private long hashcode;
    @Getter
    private List<Catalog> subCatalogs = Lists.newArrayList();
    @Getter
    private List<MetaData> articles = Lists.newArrayList();

    public Catalog(String name, long parentHash) {
        this.name = name;
        this.hashcode = HashCode.asLong(name, parentHash);
    }

    public void addCatalog(Catalog catalog) {
        this.subCatalogs.add(catalog);
    }

    public void addMetaData(MetaData metaData) {
        this.articles.add(metaData);
    }

    public List<String> catalogs() {
        List<String> list = Lists.newLinkedList();
        for (Catalog catalog : subCatalogs) {
            list.add(catalog.getName());
        }
        return list;
    }

    public int getArticleCount() {
        return articles.size();
    }

}
