package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetQuickMentionsDialogBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f17398a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final ViewPager2 f17399b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TabLayout f17400c;

    public WidgetQuickMentionsDialogBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ViewPager2 viewPager2, @NonNull TabLayout tabLayout) {
        this.f17398a = constraintLayout;
        this.f17399b = viewPager2;
        this.f17400c = tabLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17398a;
    }
}
