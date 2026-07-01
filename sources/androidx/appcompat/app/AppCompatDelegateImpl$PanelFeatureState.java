package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Resources$Theme;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$style;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.view.menu.ListMenuPresenter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter$Callback;
import androidx.appcompat.view.menu.MenuView;

/* JADX INFO: loaded from: classes.dex */
public final class AppCompatDelegateImpl$PanelFeatureState {
    public int background;
    public View createdPanelView;
    public ViewGroup decorView;
    public int featureId;
    public Bundle frozenActionViewState;
    public Bundle frozenMenuState;
    public int gravity;
    public boolean isHandled;
    public boolean isOpen;
    public boolean isPrepared;
    public ListMenuPresenter listMenuPresenter;
    public Context listPresenterContext;
    public MenuBuilder menu;
    public boolean qwertyMode;
    public boolean refreshDecorView = false;
    public boolean refreshMenuContent;
    public View shownPanelView;
    public boolean wasLastOpen;
    public int windowAnimations;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f23x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f24y;

    public AppCompatDelegateImpl$PanelFeatureState(int i) {
        this.featureId = i;
    }

    public void applyFrozenState() {
        Bundle bundle;
        MenuBuilder menuBuilder = this.menu;
        if (menuBuilder == null || (bundle = this.frozenMenuState) == null) {
            return;
        }
        menuBuilder.restorePresenterStates(bundle);
        this.frozenMenuState = null;
    }

    public void clearMenuPresenters() {
        MenuBuilder menuBuilder = this.menu;
        if (menuBuilder != null) {
            menuBuilder.removeMenuPresenter(this.listMenuPresenter);
        }
        this.listMenuPresenter = null;
    }

    public MenuView getListMenuView(MenuPresenter$Callback menuPresenter$Callback) {
        if (this.menu == null) {
            return null;
        }
        if (this.listMenuPresenter == null) {
            ListMenuPresenter listMenuPresenter = new ListMenuPresenter(this.listPresenterContext, R$layout.abc_list_menu_item_layout);
            this.listMenuPresenter = listMenuPresenter;
            listMenuPresenter.setCallback(menuPresenter$Callback);
            this.menu.addMenuPresenter(this.listMenuPresenter);
        }
        return this.listMenuPresenter.getMenuView(this.decorView);
    }

    public boolean hasPanelItems() {
        if (this.shownPanelView == null) {
            return false;
        }
        return this.createdPanelView != null || this.listMenuPresenter.getAdapter().getCount() > 0;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        AppCompatDelegateImpl$PanelFeatureState$SavedState appCompatDelegateImpl$PanelFeatureState$SavedState = (AppCompatDelegateImpl$PanelFeatureState$SavedState) parcelable;
        this.featureId = appCompatDelegateImpl$PanelFeatureState$SavedState.featureId;
        this.wasLastOpen = appCompatDelegateImpl$PanelFeatureState$SavedState.isOpen;
        this.frozenMenuState = appCompatDelegateImpl$PanelFeatureState$SavedState.menuState;
        this.shownPanelView = null;
        this.decorView = null;
    }

    public Parcelable onSaveInstanceState() {
        AppCompatDelegateImpl$PanelFeatureState$SavedState appCompatDelegateImpl$PanelFeatureState$SavedState = new AppCompatDelegateImpl$PanelFeatureState$SavedState();
        appCompatDelegateImpl$PanelFeatureState$SavedState.featureId = this.featureId;
        appCompatDelegateImpl$PanelFeatureState$SavedState.isOpen = this.isOpen;
        if (this.menu != null) {
            Bundle bundle = new Bundle();
            appCompatDelegateImpl$PanelFeatureState$SavedState.menuState = bundle;
            this.menu.savePresenterStates(bundle);
        }
        return appCompatDelegateImpl$PanelFeatureState$SavedState;
    }

    public void setMenu(MenuBuilder menuBuilder) {
        ListMenuPresenter listMenuPresenter;
        MenuBuilder menuBuilder2 = this.menu;
        if (menuBuilder == menuBuilder2) {
            return;
        }
        if (menuBuilder2 != null) {
            menuBuilder2.removeMenuPresenter(this.listMenuPresenter);
        }
        this.menu = menuBuilder;
        if (menuBuilder == null || (listMenuPresenter = this.listMenuPresenter) == null) {
            return;
        }
        menuBuilder.addMenuPresenter(listMenuPresenter);
    }

    public void setStyle(Context context) {
        TypedValue typedValue = new TypedValue();
        Resources$Theme resources$ThemeNewTheme = context.getResources().newTheme();
        resources$ThemeNewTheme.setTo(context.getTheme());
        resources$ThemeNewTheme.resolveAttribute(R$attr.actionBarPopupTheme, typedValue, true);
        int i = typedValue.resourceId;
        if (i != 0) {
            resources$ThemeNewTheme.applyStyle(i, true);
        }
        resources$ThemeNewTheme.resolveAttribute(R$attr.panelMenuListTheme, typedValue, true);
        int i2 = typedValue.resourceId;
        if (i2 != 0) {
            resources$ThemeNewTheme.applyStyle(i2, true);
        } else {
            resources$ThemeNewTheme.applyStyle(R$style.Theme_AppCompat_CompactMenu, true);
        }
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, 0);
        contextThemeWrapper.getTheme().setTo(resources$ThemeNewTheme);
        this.listPresenterContext = contextThemeWrapper;
        TypedArray typedArrayObtainStyledAttributes = contextThemeWrapper.obtainStyledAttributes(R$styleable.AppCompatTheme);
        this.background = typedArrayObtainStyledAttributes.getResourceId(R$styleable.AppCompatTheme_panelBackground, 0);
        this.windowAnimations = typedArrayObtainStyledAttributes.getResourceId(R$styleable.AppCompatTheme_android_windowAnimationStyle, 0);
        typedArrayObtainStyledAttributes.recycle();
    }
}
