package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.discord.app.AppViewFlipper;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetGlobalSearchBinding implements ViewBinding {

    @NonNull
    public final CoordinatorLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final MaterialButton f2403b;

    @NonNull
    public final TextInputLayout c;

    @NonNull
    public final TextInputEditText d;

    @NonNull
    public final RecyclerView e;

    @NonNull
    public final MaterialButton f;

    @NonNull
    public final RecyclerView g;

    @NonNull
    public final AppViewFlipper h;

    public WidgetGlobalSearchBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull MaterialButton materialButton, @NonNull TextInputLayout textInputLayout, @NonNull TextInputEditText textInputEditText, @NonNull RecyclerView recyclerView, @NonNull MaterialButton materialButton2, @NonNull RecyclerView recyclerView2, @NonNull AppViewFlipper appViewFlipper) {
        this.a = coordinatorLayout;
        this.f2403b = materialButton;
        this.c = textInputLayout;
        this.d = textInputEditText;
        this.e = recyclerView;
        this.f = materialButton2;
        this.g = recyclerView2;
        this.h = appViewFlipper;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
