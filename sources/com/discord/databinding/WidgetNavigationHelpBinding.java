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

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f17291a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final ImageView f17292b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TabLayout f17293c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final ViewPager2 f17294d;

    public WidgetNavigationHelpBinding(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull TabLayout tabLayout, @NonNull ViewPager2 viewPager2) {
        this.f17291a = linearLayout;
        this.f17292b = imageView;
        this.f17293c = tabLayout;
        this.f17294d = viewPager2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17291a;
    }
}
