package com.alsash.reciper.mvp.presenter;

import com.alsash.reciper.logic.StorageLogic;
import com.alsash.reciper.mvp.model.entity.Category;
import com.alsash.reciper.mvp.model.entity.Recipe;
import com.alsash.reciper.mvp.view.RecipeTabCategoryView;

import java.lang.ref.WeakReference;
import java.util.List;

/**
 * A Presenter that represents collection of Recipes grouped by Categories
 */
public class RecipeTabCategoryPresenter
        extends BaseRecipeGroupPresenter<Category, RecipeTabCategoryView> {

    private static final int PAGINATION_CATEGORY_LIMIT = 10;
    private static final int PAGINATION_RECIPE_LIMIT = 10;

    private final StorageLogic storage;

    public RecipeTabCategoryPresenter(StorageLogic storage) {
        super(PAGINATION_CATEGORY_LIMIT, PAGINATION_RECIPE_LIMIT);
        this.storage = storage;
    }

    @Override
    protected List<Category> loadNextGroups(int offset, int limit) {
        return null; //  storage.getCategories(offset, limit);
    }

    @Override
    protected List<Recipe> loadNextRecipes(int offset, int limit, long categoryId) {
        return null; // storage.getCategorizedRecipes(offset, limit, categoryId);
    }

    @Override
    protected boolean doLoading(int visiblePosition) {
        return super.doLoading(visiblePosition);
    }

    @Override
    protected void setLoading(boolean loading, WeakReference<RecipeTabCategoryView> viewRef) {
        super.setLoading(loading, viewRef);
    }
}
