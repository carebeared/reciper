package com.alsash.reciper.model.entity;

import java.util.List;

public interface Category extends Entity {

    String getName();

    List<Recipe> getRecipes();
}
