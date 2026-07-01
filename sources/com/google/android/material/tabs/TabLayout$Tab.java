package com.google.android.material.tabs;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.DrawableRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.content.res.AppCompatResources;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.badge.BadgeUtils;

/* JADX INFO: loaded from: classes3.dex */
public class TabLayout$Tab {
    public static final int INVALID_POSITION = -1;

    @Nullable
    private CharSequence contentDesc;

    @Nullable
    private View customView;

    @Nullable
    private Drawable icon;

    @Nullable
    public TabLayout parent;

    @Nullable
    private Object tag;

    @Nullable
    private CharSequence text;

    @NonNull
    public TabLayout$TabView view;
    private int position = -1;

    @TabLayout$LabelVisibility
    private int labelVisibilityMode = 1;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private int f3067id = -1;

    public static /* synthetic */ int access$000(TabLayout$Tab tabLayout$Tab) {
        return tabLayout$Tab.f3067id;
    }

    public static /* synthetic */ int access$1100(TabLayout$Tab tabLayout$Tab) {
        return tabLayout$Tab.labelVisibilityMode;
    }

    public static /* synthetic */ CharSequence access$200(TabLayout$Tab tabLayout$Tab) {
        return tabLayout$Tab.contentDesc;
    }

    public static /* synthetic */ CharSequence access$300(TabLayout$Tab tabLayout$Tab) {
        return tabLayout$Tab.text;
    }

    @Nullable
    public BadgeDrawable getBadge() {
        return TabLayout$TabView.access$900(this.view);
    }

    @Nullable
    public CharSequence getContentDescription() {
        TabLayout$TabView tabLayout$TabView = this.view;
        if (tabLayout$TabView == null) {
            return null;
        }
        return tabLayout$TabView.getContentDescription();
    }

    @Nullable
    public View getCustomView() {
        return this.customView;
    }

    @Nullable
    public Drawable getIcon() {
        return this.icon;
    }

    public int getId() {
        return this.f3067id;
    }

    @NonNull
    public BadgeDrawable getOrCreateBadge() {
        return TabLayout$TabView.access$700(this.view);
    }

    public int getPosition() {
        return this.position;
    }

    @TabLayout$LabelVisibility
    public int getTabLabelVisibility() {
        return this.labelVisibilityMode;
    }

    @Nullable
    public Object getTag() {
        return this.tag;
    }

    @Nullable
    public CharSequence getText() {
        return this.text;
    }

    public boolean isSelected() {
        TabLayout tabLayout = this.parent;
        if (tabLayout != null) {
            return tabLayout.getSelectedTabPosition() == this.position;
        }
        throw new IllegalArgumentException("Tab not attached to a TabLayout");
    }

    public void removeBadge() {
        TabLayout$TabView.access$800(this.view);
    }

    public void reset() {
        this.parent = null;
        this.view = null;
        this.tag = null;
        this.icon = null;
        this.f3067id = -1;
        this.text = null;
        this.contentDesc = null;
        this.position = -1;
        this.customView = null;
    }

    public void select() {
        TabLayout tabLayout = this.parent;
        if (tabLayout == null) {
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }
        tabLayout.selectTab(this);
    }

    @NonNull
    public TabLayout$Tab setContentDescription(@StringRes int i) {
        TabLayout tabLayout = this.parent;
        if (tabLayout != null) {
            return setContentDescription(tabLayout.getResources().getText(i));
        }
        throw new IllegalArgumentException("Tab not attached to a TabLayout");
    }

    @NonNull
    public TabLayout$Tab setCustomView(@Nullable View view) {
        this.customView = view;
        updateView();
        return this;
    }

    @NonNull
    public TabLayout$Tab setIcon(@Nullable Drawable drawable) {
        this.icon = drawable;
        TabLayout tabLayout = this.parent;
        if (tabLayout.tabGravity == 1 || tabLayout.mode == 2) {
            tabLayout.updateTabViews(true);
        }
        updateView();
        if (BadgeUtils.USE_COMPAT_PARENT && TabLayout$TabView.access$500(this.view) && TabLayout$TabView.access$600(this.view).isVisible()) {
            this.view.invalidate();
        }
        return this;
    }

    @NonNull
    public TabLayout$Tab setId(int i) {
        this.f3067id = i;
        TabLayout$TabView tabLayout$TabView = this.view;
        if (tabLayout$TabView != null) {
            tabLayout$TabView.setId(i);
        }
        return this;
    }

    public void setPosition(int i) {
        this.position = i;
    }

    @NonNull
    public TabLayout$Tab setTabLabelVisibility(@TabLayout$LabelVisibility int i) {
        this.labelVisibilityMode = i;
        TabLayout tabLayout = this.parent;
        if (tabLayout.tabGravity == 1 || tabLayout.mode == 2) {
            tabLayout.updateTabViews(true);
        }
        updateView();
        if (BadgeUtils.USE_COMPAT_PARENT && TabLayout$TabView.access$500(this.view) && TabLayout$TabView.access$600(this.view).isVisible()) {
            this.view.invalidate();
        }
        return this;
    }

    @NonNull
    public TabLayout$Tab setTag(@Nullable Object obj) {
        this.tag = obj;
        return this;
    }

    @NonNull
    public TabLayout$Tab setText(@Nullable CharSequence charSequence) {
        if (TextUtils.isEmpty(this.contentDesc) && !TextUtils.isEmpty(charSequence)) {
            this.view.setContentDescription(charSequence);
        }
        this.text = charSequence;
        updateView();
        return this;
    }

    public void updateView() {
        TabLayout$TabView tabLayout$TabView = this.view;
        if (tabLayout$TabView != null) {
            tabLayout$TabView.update();
        }
    }

    @NonNull
    public TabLayout$Tab setCustomView(@LayoutRes int i) {
        return setCustomView(LayoutInflater.from(this.view.getContext()).inflate(i, (ViewGroup) this.view, false));
    }

    @NonNull
    public TabLayout$Tab setContentDescription(@Nullable CharSequence charSequence) {
        this.contentDesc = charSequence;
        updateView();
        return this;
    }

    @NonNull
    public TabLayout$Tab setText(@StringRes int i) {
        TabLayout tabLayout = this.parent;
        if (tabLayout != null) {
            return setText(tabLayout.getResources().getText(i));
        }
        throw new IllegalArgumentException("Tab not attached to a TabLayout");
    }

    @NonNull
    public TabLayout$Tab setIcon(@DrawableRes int i) {
        TabLayout tabLayout = this.parent;
        if (tabLayout != null) {
            return setIcon(AppCompatResources.getDrawable(tabLayout.getContext(), i));
        }
        throw new IllegalArgumentException("Tab not attached to a TabLayout");
    }
}
