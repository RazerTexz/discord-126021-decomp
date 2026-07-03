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

    /* JADX INFO: renamed from: a */
    @NonNull
    public final CoordinatorLayout f17834a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final DimmerView f17835b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final LinkifiedTextView f17836c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextInputLayout f17837d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final Button f17838e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final FloatingActionButton f17839f;

    public WidgetSettingsAccountEmailEditBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull DimmerView dimmerView, @NonNull LinkifiedTextView linkifiedTextView, @NonNull TextInputLayout textInputLayout, @NonNull Button button, @NonNull FloatingActionButton floatingActionButton) {
        this.f17834a = coordinatorLayout;
        this.f17835b = dimmerView;
        this.f17836c = linkifiedTextView;
        this.f17837d = textInputLayout;
        this.f17838e = button;
        this.f17839f = floatingActionButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17834a;
    }
}
