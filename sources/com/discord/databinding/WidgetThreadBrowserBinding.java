package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.simple_pager.SimplePager;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetThreadBrowserBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TabLayout f2670b;

    @NonNull
    public final SimplePager c;

    public WidgetThreadBrowserBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TabLayout tabLayout, @NonNull AppBarLayout appBarLayout, @NonNull SimplePager simplePager) {
        this.a = constraintLayout;
        this.f2670b = tabLayout;
        this.c = simplePager;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
