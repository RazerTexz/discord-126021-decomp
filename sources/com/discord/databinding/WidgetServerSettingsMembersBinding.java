package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.discord.app.AppViewFlipper;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetServerSettingsMembersBinding implements ViewBinding {

    @NonNull
    public final CoordinatorLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextInputLayout f2579b;

    @NonNull
    public final RecyclerView c;

    @NonNull
    public final Spinner d;

    @NonNull
    public final AppViewFlipper e;

    public WidgetServerSettingsMembersBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull TextView textView, @NonNull LinearLayout linearLayout, @NonNull TextInputLayout textInputLayout, @NonNull RecyclerView recyclerView, @NonNull Spinner spinner, @NonNull AppViewFlipper appViewFlipper) {
        this.a = coordinatorLayout;
        this.f2579b = textInputLayout;
        this.c = recyclerView;
        this.d = spinner;
        this.e = appViewFlipper;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
