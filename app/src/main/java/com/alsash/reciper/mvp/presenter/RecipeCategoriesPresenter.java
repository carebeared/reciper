package com.alsash.reciper.mvp.presenter;

import com.alsash.reciper.database.entity.DaoSession;
import com.alsash.reciper.mvp.model.entity.Category;
import com.alsash.reciper.mvp.model.entity.Recipe;
import com.alsash.reciper.mvp.model.entity.database.CategoryMvpDb;
import com.alsash.reciper.mvp.presenter.interaction.RecipeListInteraction;
import com.alsash.reciper.mvp.view.RecipeCategoriesView;

import java.util.ArrayList;
import java.util.List;


public class RecipeCategoriesPresenter extends BasePresenter<RecipeCategoriesView>
        implements RecipeListInteraction {

    private final DaoSession session;

    public RecipeCategoriesPresenter(DaoSession session) {
        this.session = session;
    }

    @Override
    public void onExpand(Recipe recipe, int position) {
        if (getView() == null) return;
        getView().showDetails(recipe);
    }

    @Override
    public void onOpen(Recipe recipe, int position) {
        if (getView() == null) return;
        getView().showRecipe(recipe);
    }

    public void loadCategories() {

    }

    private List<Category> getCategories() {
        List<Category> mvpCategories = new ArrayList<>();
        List<com.alsash.reciper.database.entity.Category> dbCategories =
                session.getCategoryDao().queryBuilder()
                        .build().forCurrentThread().list();
        for (com.alsash.reciper.database.entity.Category categoryDb : dbCategories) {
            CategoryMvpDb categoryMvpDb = new CategoryMvpDb(categoryDb);
            mvpCategories.add(categoryMvpDb);
        }
        return mvpCategories;
    }
}
