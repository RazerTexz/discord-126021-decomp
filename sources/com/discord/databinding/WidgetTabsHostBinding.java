package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import com.discord.widgets.tabs.TabsHostBottomNavigationView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetTabsHostBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TabsHostBottomNavigationView f2664b;

    @NonNull
    public final ConstraintLayout c;

    @NonNull
    public final FragmentContainerView d;

    @NonNull
    public final FragmentContainerView e;

    @NonNull
    public final FragmentContainerView f;

    @NonNull
    public final FrameLayout g;

    @NonNull
    public final FrameLayout h;

    @NonNull
    public final FragmentContainerView i;

    public WidgetTabsHostBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TabsHostBottomNavigationView tabsHostBottomNavigationView, @NonNull ConstraintLayout constraintLayout2, @NonNull FragmentContainerView fragmentContainerView, @NonNull FragmentContainerView fragmentContainerView2, @NonNull FragmentContainerView fragmentContainerView3, @NonNull FragmentContainerView fragmentContainerView4, @NonNull FrameLayout frameLayout, @NonNull FrameLayout frameLayout2, @NonNull FragmentContainerView fragmentContainerView5) {
        this.a = constraintLayout;
        this.f2664b = tabsHostBottomNavigationView;
        this.c = constraintLayout2;
        this.d = fragmentContainerView;
        this.e = fragmentContainerView3;
        this.f = fragmentContainerView4;
        this.g = frameLayout;
        this.h = frameLayout2;
        this.i = fragmentContainerView5;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
