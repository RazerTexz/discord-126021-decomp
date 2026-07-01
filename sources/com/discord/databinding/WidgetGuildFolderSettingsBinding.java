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
public final class WidgetGuildFolderSettingsBinding implements ViewBinding {

    @NonNull
    public final CoordinatorLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextInputLayout f2413b;

    @NonNull
    public final TextView c;

    @NonNull
    public final RelativeLayout d;

    @NonNull
    public final View e;

    @NonNull
    public final FloatingActionButton f;

    public WidgetGuildFolderSettingsBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull TextInputLayout textInputLayout, @NonNull TextView textView, @NonNull RelativeLayout relativeLayout, @NonNull View view, @NonNull FloatingActionButton floatingActionButton) {
        this.a = coordinatorLayout;
        this.f2413b = textInputLayout;
        this.c = textView;
        this.d = relativeLayout;
        this.e = view;
        this.f = floatingActionButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
