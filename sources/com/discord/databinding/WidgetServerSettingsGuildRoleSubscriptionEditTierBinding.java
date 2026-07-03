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

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f17660a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final MaterialButton f17661b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final Group f17662c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TabLayout f17663d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final ViewPager2 f17664e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final MaterialButton f17665f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final FloatingActionButton f17666g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final AppViewFlipper f17667h;

    public WidgetServerSettingsGuildRoleSubscriptionEditTierBinding(@NonNull ConstraintLayout constraintLayout, @NonNull MaterialButton materialButton, @NonNull TextView textView, @NonNull Group group, @NonNull TabLayout tabLayout, @NonNull ViewPager2 viewPager2, @NonNull Barrier barrier, @NonNull AppBarLayout appBarLayout, @NonNull MaterialButton materialButton2, @NonNull FloatingActionButton floatingActionButton, @NonNull AppViewFlipper appViewFlipper) {
        this.f17660a = constraintLayout;
        this.f17661b = materialButton;
        this.f17662c = group;
        this.f17663d = tabLayout;
        this.f17664e = viewPager2;
        this.f17665f = materialButton2;
        this.f17666g = floatingActionButton;
        this.f17667h = appViewFlipper;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17660a;
    }
}
