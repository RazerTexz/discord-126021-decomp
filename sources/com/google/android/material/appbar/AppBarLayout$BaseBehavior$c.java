package com.google.android.material.appbar;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.core.view.accessibility.AccessibilityViewCommand$CommandArguments;

/* JADX INFO: loaded from: classes3.dex */
public class AppBarLayout$BaseBehavior$c implements AccessibilityViewCommand {
    public final /* synthetic */ AppBarLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f3027b;

    public AppBarLayout$BaseBehavior$c(AppBarLayout$BaseBehavior appBarLayout$BaseBehavior, AppBarLayout appBarLayout, boolean z2) {
        this.a = appBarLayout;
        this.f3027b = z2;
    }

    @Override // androidx.core.view.accessibility.AccessibilityViewCommand
    public boolean perform(@NonNull View view, @Nullable AccessibilityViewCommand$CommandArguments accessibilityViewCommand$CommandArguments) {
        this.a.setExpanded(this.f3027b);
        return true;
    }
}
