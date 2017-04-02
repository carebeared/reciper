package com.alsash.reciper.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alsash.reciper.R;
import com.alsash.reciper.api.RecipeManager;
import com.alsash.reciper.ui.activity.RecipeDetailActivity;
import com.alsash.reciper.ui.adapter.RecipeSingleCardAdapter;
import com.alsash.reciper.ui.animator.FlipCardAnimator;
import com.alsash.reciper.ui.fragment.dialog.RecipeBottomDialog;
import com.alsash.reciper.ui.presenter.entity.Recipe;
import com.alsash.reciper.ui.presenter.interaction.RecipeListInteraction;

import java.util.List;


public class RecipeSingleListFragment extends Fragment implements RecipeListInteraction {

    // Model
    private List<Recipe> recipes;

    // Views
    private RecyclerView recyclerView;

    public static RecipeSingleListFragment newInstance() {
        Bundle args = new Bundle();
        RecipeSingleListFragment fragment = new RecipeSingleListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onExpand(Recipe recipe, int position) {
        RecipeBottomDialog bottomDialog = RecipeBottomDialog.newInstance(recipe);
        bottomDialog.show(getActivity().getSupportFragmentManager(), bottomDialog.getTag());
    }

    @Override
    public void onOpen(Recipe recipe, int position) {
        RecipeDetailActivity.start(getContext(), recipe.getId());
        recyclerView.getAdapter().notifyItemChanged(position);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindModel();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.view_list, container, false);
        bindViews(layout);
        setupList();
        return layout;
    }

    private void bindModel() {
        recipes = RecipeManager.getInstance().list();
    }

    private void bindViews(View layout) {
        recyclerView = (RecyclerView) layout.findViewById(R.id.list);
    }

    private void setupList() {
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), getResources()
                .getInteger(R.integer.recipe_list_span)));
        recyclerView.setAdapter(new RecipeSingleCardAdapter(this, recipes));
        recyclerView.setItemAnimator(new FlipCardAnimator());
    }
}