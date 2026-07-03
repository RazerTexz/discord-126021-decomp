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

    /* JADX INFO: renamed from: a */
    @NonNull
    public final CoordinatorLayout f17830a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextInputLayout f17831b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextInputLayout f17832c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final FloatingActionButton f17833d;

    public WidgetSettingsAccountEditBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull TextView textView, @NonNull TextInputLayout textInputLayout, @NonNull RelativeLayout relativeLayout, @NonNull TextInputLayout textInputLayout2, @NonNull FloatingActionButton floatingActionButton) {
        this.f17830a = coordinatorLayout;
        this.f17831b = textInputLayout;
        this.f17832c = textInputLayout2;
        this.f17833d = floatingActionButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17830a;
    }
}
