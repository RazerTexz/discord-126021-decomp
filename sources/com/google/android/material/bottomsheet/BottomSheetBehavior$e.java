package com.google.android.material.bottomsheet;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.core.view.accessibility.AccessibilityViewCommand$CommandArguments;

/* JADX INFO: loaded from: classes3.dex */
public class BottomSheetBehavior$e implements AccessibilityViewCommand {
    public final /* synthetic */ int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BottomSheetBehavior f3032b;

    public BottomSheetBehavior$e(BottomSheetBehavior bottomSheetBehavior, int i) {
        this.f3032b = bottomSheetBehavior;
        this.a = i;
    }

    @Override // androidx.core.view.accessibility.AccessibilityViewCommand
    public boolean perform(@NonNull View view, @Nullable AccessibilityViewCommand$CommandArguments accessibilityViewCommand$CommandArguments) {
        this.f3032b.setState(this.a);
        return true;
    }
}
