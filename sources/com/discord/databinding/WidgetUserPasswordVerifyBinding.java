package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserPasswordVerifyBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final CoordinatorLayout f18344a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final DimmerView f18345b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextInputLayout f18346c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final FloatingActionButton f18347d;

    public WidgetUserPasswordVerifyBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull DimmerView dimmerView, @NonNull TextInputLayout textInputLayout, @NonNull FloatingActionButton floatingActionButton) {
        this.f18344a = coordinatorLayout;
        this.f18345b = dimmerView;
        this.f18346c = textInputLayout;
        this.f18347d = floatingActionButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f18344a;
    }
}
