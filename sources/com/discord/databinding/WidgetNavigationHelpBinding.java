package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetNavigationHelpBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f2499b;

    @NonNull
    public final TabLayout c;

    @NonNull
    public final ViewPager2 d;

    public WidgetNavigationHelpBinding(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull TabLayout tabLayout, @NonNull ViewPager2 viewPager2) {
        this.a = linearLayout;
        this.f2499b = imageView;
        this.c = tabLayout;
        this.d = viewPager2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
