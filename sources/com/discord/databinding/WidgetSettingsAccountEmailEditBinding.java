package com.discord.databinding;

import android.view.View;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetSettingsAccountEmailEditBinding implements ViewBinding {

    @NonNull
    public final CoordinatorLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final DimmerView f2599b;

    @NonNull
    public final LinkifiedTextView c;

    @NonNull
    public final TextInputLayout d;

    @NonNull
    public final Button e;

    @NonNull
    public final FloatingActionButton f;

    public WidgetSettingsAccountEmailEditBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull DimmerView dimmerView, @NonNull LinkifiedTextView linkifiedTextView, @NonNull TextInputLayout textInputLayout, @NonNull Button button, @NonNull FloatingActionButton floatingActionButton) {
        this.a = coordinatorLayout;
        this.f2599b = dimmerView;
        this.c = linkifiedTextView;
        this.d = textInputLayout;
        this.e = button;
        this.f = floatingActionButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
