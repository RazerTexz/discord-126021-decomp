package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetSearchBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final CoordinatorLayout f17419a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final FloatingActionButton f17420b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextInputLayout f17421c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final FragmentContainerView f17422d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final FragmentContainerView f17423e;

    public WidgetSearchBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton, @NonNull TextInputLayout textInputLayout, @NonNull FragmentContainerView fragmentContainerView, @NonNull FragmentContainerView fragmentContainerView2) {
        this.f17419a = coordinatorLayout;
        this.f17420b = floatingActionButton;
        this.f17421c = textInputLayout;
        this.f17422d = fragmentContainerView;
        this.f17423e = fragmentContainerView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17419a;
    }
}
