package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.discord.app.AppViewFlipper;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetSettingsBlockedUsersBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final CoordinatorLayout f17917a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final AppViewFlipper f17918b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final RecyclerView f17919c;

    public WidgetSettingsBlockedUsersBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppViewFlipper appViewFlipper, @NonNull RecyclerView recyclerView, @NonNull ImageView imageView) {
        this.f17917a = coordinatorLayout;
        this.f17918b = appViewFlipper;
        this.f17919c = recyclerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17917a;
    }
}
