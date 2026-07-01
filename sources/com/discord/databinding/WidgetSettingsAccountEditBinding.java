package com.discord.databinding;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetSettingsAccountEditBinding implements ViewBinding {

    @NonNull
    public final CoordinatorLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextInputLayout f2598b;

    @NonNull
    public final TextInputLayout c;

    @NonNull
    public final FloatingActionButton d;

    public WidgetSettingsAccountEditBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull TextView textView, @NonNull TextInputLayout textInputLayout, @NonNull RelativeLayout relativeLayout, @NonNull TextInputLayout textInputLayout2, @NonNull FloatingActionButton floatingActionButton) {
        this.a = coordinatorLayout;
        this.f2598b = textInputLayout;
        this.c = textInputLayout2;
        this.d = floatingActionButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
