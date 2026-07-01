package com.google.android.material.appbar;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.core.view.accessibility.AccessibilityViewCommand$CommandArguments;

/* JADX INFO: loaded from: classes3.dex */
public class AppBarLayout$BaseBehavior$b implements AccessibilityViewCommand {
    public final /* synthetic */ CoordinatorLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AppBarLayout f3026b;
    public final /* synthetic */ View c;
    public final /* synthetic */ int d;
    public final /* synthetic */ AppBarLayout$BaseBehavior e;

    public AppBarLayout$BaseBehavior$b(AppBarLayout$BaseBehavior appBarLayout$BaseBehavior, CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i) {
        this.e = appBarLayout$BaseBehavior;
        this.a = coordinatorLayout;
        this.f3026b = appBarLayout;
        this.c = view;
        this.d = i;
    }

    @Override // androidx.core.view.accessibility.AccessibilityViewCommand
    public boolean perform(@NonNull View view, @Nullable AccessibilityViewCommand$CommandArguments accessibilityViewCommand$CommandArguments) {
        this.e.onNestedPreScroll(this.a, this.f3026b, this.c, 0, this.d, new int[]{0, 0}, 1);
        return true;
    }
}
