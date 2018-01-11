package com.lanou3g.bookstore.category.service;

import com.lanou3g.bookstore.category.dao.CategoryDao;
import com.lanou3g.bookstore.category.domain.Category;
import com.lanou3g.bookstore.util.RandomId;

import java.util.List;

public class CategoryService {
    private CategoryDao cd = new CategoryDao();
    public List<Category> findAll() {
        List<Category> categoryList = cd.findAll();
        return categoryList;
    }


    public void add(Category category) {
        category.setCid(RandomId.randomId());
        cd.add(category);
    }

    public String findByCname(String cname) {
        String byCname = cd.findByCname(cname);
        return byCname;


    }

    public String delete(String cname) {
        String cid = findByCname(cname);
        String delete = cd.delete(cid);
        return delete;
    }

    public void edit(Category category) {

        cd.edit(category);


    }
}
