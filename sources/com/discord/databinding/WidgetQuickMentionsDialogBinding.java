package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetQuickMentionsDialogBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ViewPager2 f2516b;

    @NonNull
    public final TabLayout c;

    public WidgetQuickMentionsDialogBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ViewPager2 viewPager2, @NonNull TabLayout tabLayout) {
        this.a = constraintLayout;
        this.f2516b = viewPager2;
        this.c = tabLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
