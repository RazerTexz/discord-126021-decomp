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

    /* JADX INFO: renamed from: a */
    @NonNull
    public final CoordinatorLayout f16707a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final MaterialButton f16708b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextInputLayout f16709c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextInputEditText f16710d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final RecyclerView f16711e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final MaterialButton f16712f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final RecyclerView f16713g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final AppViewFlipper f16714h;

    public WidgetGlobalSearchBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull MaterialButton materialButton, @NonNull TextInputLayout textInputLayout, @NonNull TextInputEditText textInputEditText, @NonNull RecyclerView recyclerView, @NonNull MaterialButton materialButton2, @NonNull RecyclerView recyclerView2, @NonNull AppViewFlipper appViewFlipper) {
        this.f16707a = coordinatorLayout;
        this.f16708b = materialButton;
        this.f16709c = textInputLayout;
        this.f16710d = textInputEditText;
        this.f16711e = recyclerView;
        this.f16712f = materialButton2;
        this.f16713g = recyclerView2;
        this.f16714h = appViewFlipper;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16707a;
    }
}
