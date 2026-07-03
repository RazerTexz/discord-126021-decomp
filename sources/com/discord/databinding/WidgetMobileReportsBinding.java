package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetMobileReportsBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final CoordinatorLayout f17267a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final FrameLayout f17268b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final ProgressBar f17269c;

    public WidgetMobileReportsBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FrameLayout frameLayout, @NonNull ProgressBar progressBar) {
        this.f17267a = coordinatorLayout;
        this.f17268b = frameLayout;
        this.f17269c = progressBar;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17267a;
    }
}
