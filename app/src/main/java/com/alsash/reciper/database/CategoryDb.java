package com.alsash.reciper.database;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.List;

/**
 * Local database table that holds categories of recipes
 */
@Entity(nameInDb = "category",
        indexes = {
                @Index(value = "name", unique = true)
        })
public class CategoryDb {
    @Id
    private long id;
    private String name;
    @ToMany(referencedJoinProperty = "categoryId")
    private List<RecipeDb> recipes;
// Next will be generated sources
}