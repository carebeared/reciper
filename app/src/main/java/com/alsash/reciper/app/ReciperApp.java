package com.alsash.reciper.app;

import android.app.Application;

import com.alsash.reciper.BuildConfig;
import com.alsash.reciper.di.component.AppComponent;
import com.alsash.reciper.di.component.DaggerAppComponent;
import com.alsash.reciper.di.component.UiRecipeTabComponent;
import com.alsash.reciper.di.component.UiStartComponent;
import com.alsash.reciper.di.module.AppContextModule;
import com.facebook.stetho.Stetho;

/**
 * RecipeR Application class
 */
public class ReciperApp extends Application {

    private UiStartComponent uiStartComponent;
    private UiRecipeTabComponent uiRecipeTabComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        // Google Dagger 2 initialization
        AppComponent appComponent = DaggerAppComponent.builder()
                .appContextModule(new AppContextModule(this))
                .build();
        uiStartComponent = appComponent
                .getStartComponentBuilder()
                .build();
        uiRecipeTabComponent = appComponent
                .getRecipeTabComponentBuilder()
                .build();

        // Facebook Stetho initialization
        if (BuildConfig.DEBUG) Stetho.initializeWithDefaults(this);

    }

    public UiStartComponent getUiStartComponent() {
        return uiStartComponent;
    }

    public UiRecipeTabComponent getUiRecipeTabComponent() {
        return uiRecipeTabComponent;
    }
}
