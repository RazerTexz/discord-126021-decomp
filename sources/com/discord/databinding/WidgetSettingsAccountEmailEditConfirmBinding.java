package com.discord.databinding;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetSettingsAccountEmailEditConfirmBinding implements ViewBinding {

    @NonNull
    public final CoordinatorLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final DimmerView f2600b;

    @NonNull
    public final TextInputLayout c;

    @NonNull
    public final TextView d;

    @NonNull
    public final LinkifiedTextView e;

    @NonNull
    public final Button f;

    public WidgetSettingsAccountEmailEditConfirmBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull DimmerView dimmerView, @NonNull TextInputLayout textInputLayout, @NonNull TextView textView, @NonNull LinkifiedTextView linkifiedTextView, @NonNull Button button) {
        this.a = coordinatorLayout;
        this.f2600b = dimmerView;
        this.c = textInputLayout;
        this.d = textView;
        this.e = linkifiedTextView;
        this.f = button;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
