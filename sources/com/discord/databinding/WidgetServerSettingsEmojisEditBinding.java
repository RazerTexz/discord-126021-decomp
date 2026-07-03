package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetServerSettingsEmojisEditBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final CoordinatorLayout f17640a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextInputLayout f17641b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final FloatingActionButton f17642c;

    public WidgetServerSettingsEmojisEditBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull TextInputLayout textInputLayout, @NonNull FloatingActionButton floatingActionButton) {
        this.f17640a = coordinatorLayout;
        this.f17641b = textInputLayout;
        this.f17642c = floatingActionButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17640a;
    }
}
