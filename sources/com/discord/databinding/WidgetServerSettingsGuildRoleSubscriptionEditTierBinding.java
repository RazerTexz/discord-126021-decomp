package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.discord.app.AppViewFlipper;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetServerSettingsGuildRoleSubscriptionEditTierBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final MaterialButton f2569b;

    @NonNull
    public final Group c;

    @NonNull
    public final TabLayout d;

    @NonNull
    public final ViewPager2 e;

    @NonNull
    public final MaterialButton f;

    @NonNull
    public final FloatingActionButton g;

    @NonNull
    public final AppViewFlipper h;

    public WidgetServerSettingsGuildRoleSubscriptionEditTierBinding(@NonNull ConstraintLayout constraintLayout, @NonNull MaterialButton materialButton, @NonNull TextView textView, @NonNull Group group, @NonNull TabLayout tabLayout, @NonNull ViewPager2 viewPager2, @NonNull Barrier barrier, @NonNull AppBarLayout appBarLayout, @NonNull MaterialButton materialButton2, @NonNull FloatingActionButton floatingActionButton, @NonNull AppViewFlipper appViewFlipper) {
        this.a = constraintLayout;
        this.f2569b = materialButton;
        this.c = group;
        this.d = tabLayout;
        this.e = viewPager2;
        this.f = materialButton2;
        this.g = floatingActionButton;
        this.h = appViewFlipper;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
