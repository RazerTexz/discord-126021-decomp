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

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f18218a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TabsHostBottomNavigationView f18219b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final ConstraintLayout f18220c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final FragmentContainerView f18221d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final FragmentContainerView f18222e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final FragmentContainerView f18223f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final FrameLayout f18224g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final FrameLayout f18225h;

    /* JADX INFO: renamed from: i */
    @NonNull
    public final FragmentContainerView f18226i;

    public WidgetTabsHostBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TabsHostBottomNavigationView tabsHostBottomNavigationView, @NonNull ConstraintLayout constraintLayout2, @NonNull FragmentContainerView fragmentContainerView, @NonNull FragmentContainerView fragmentContainerView2, @NonNull FragmentContainerView fragmentContainerView3, @NonNull FragmentContainerView fragmentContainerView4, @NonNull FrameLayout frameLayout, @NonNull FrameLayout frameLayout2, @NonNull FragmentContainerView fragmentContainerView5) {
        this.f18218a = constraintLayout;
        this.f18219b = tabsHostBottomNavigationView;
        this.f18220c = constraintLayout2;
        this.f18221d = fragmentContainerView;
        this.f18222e = fragmentContainerView3;
        this.f18223f = fragmentContainerView4;
        this.f18224g = frameLayout;
        this.f18225h = frameLayout2;
        this.f18226i = fragmentContainerView5;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f18218a;
    }
}
